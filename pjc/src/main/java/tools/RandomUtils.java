package tools;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * 随机工具
 */
public class RandomUtils {
    private static Random randomWithClass = new Random(System.currentTimeMillis());

    private static String names = "日出东海落西山，愁也一天，喜一天。\n" +
            "遇事不钻牛角尖，人舒坦，心舒坦。\n" +
            "\n" +
            "风急天高猿啸哀， 渚清沙白鸟飞回。\n" +
            "无边落木萧萧下， 不尽长江滚滚来。\n" +
            "万里悲秋常作客， 百年多病独登台。\n" +
            "艰难苦恨繁霜鬓， 潦倒新停浊酒杯。\n" +
            "\n" +
            "醉后不知天在水，满船清梦压星河 。\n" +
            "\n" +
            "障泥未解玉骢骄，我欲醉眠芳草。可惜一溪风月，莫教踏碎琼瑶。\n" +
            "\n" +
            "似此星辰非昨夜，为谁风露立中宵。\n" +
            "\n" +
            "别后相思空一水，重来回首已三生。云阶月地依然在，细逐空香百遍行。\n" +
            "\n" +
            "冬是孤独，夏是离别，春是两者之间的桥梁，唯独秋，渗透所有的季节。\n" +
            "\n" +
            "天上，只剩下几个被称为星星的窟窿。\n" +
            "\n" +
            "十年生死两茫茫，不思量，自难忘。\n" +
            "\n" +
            "春风得意马蹄疾，一日看尽长安花。\n" +
            "\n" +
            "人非木石皆有情，不如不遇倾城色。\n" +
            "\n" +
            "小楼一夜听春雨，深巷明朝卖杏花。\n" +
            "\n" +
            "我本楚狂人，凤歌笑孔丘。\n" +
            "\n" +
            "劝君且放两眉宽，满饮杯中酒，以尽一宵欢。";

    /**
     * 传一个任意类型的数组，随机选一个值出来
     *
     * @param ts
     */
    public static <T> T chooseOne(T[] ts) {
        if (ts == null) {
            return null;
        }
        int length = ts.length;
        int index = randomWithClass.nextInt(length);
        return ts[index];
    }

    /**
     * 获取字符串数字
     *
     * @param length
     */
    public static String getNumberString(String beginWith, int length) {
        if (length < 1) {
            return null;
        }

        int[] numbers = {9, 1, 9, 6, 2, 4, 1, 3, 4, 5, 6, 7, 8, 0};
        StringBuffer stringBuffer = new StringBuffer();
        if (beginWith != null) {
            stringBuffer.append(beginWith);
            length = length - beginWith.length();
        }
        for (int i = 0; i < length; i++) {
            stringBuffer.append(numbers[randomWithClass.nextInt(numbers.length)]);
        }
        return stringBuffer.toString();
    }

    /**
     * 传一个字符串，随机获取个数
     * 如人名 beginWith以这个开头，如姓
     */
    public static String getRandomStringByLength(String s, String beginWith, int addLength) {
        if (addLength < 1) {
            return null;
        }
        if (s == null) {
            s = names;
        }
        s = s.trim();
        String notSymbolString = s.replaceAll("[ ,，'`、/:;|()\\[\\]{}.。\\-_\n\\\\]", "");
        if (notSymbolString.length() < addLength) {
            addLength = s.length();
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (beginWith != null) {
            stringBuffer.append(beginWith);
        }
        for (int i = 0; i < addLength; i++) {
            stringBuffer.append(notSymbolString.charAt(randomWithClass.nextInt(notSymbolString.length())));
        }
        return stringBuffer.toString();
    }

    /**
     * 年龄等
     * <p>
     * 或取数字，小于 boundMax
     *
     * @param boundMax
     * @return
     */
    public static int getNumbers(int min, int boundMax) {
        IntStream ints = randomWithClass.ints(min, boundMax);
        return ints.findAny().getAsInt();
    }

    /**
     * 产生一个随机数组
     * minLength 最小长度
     * maxLength 最大长度
     * bound 最大数
     * <p>
     * 产生随机范围
     * https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
     *
     * @return
     */
    public static int[] randomArrays(int minLength, int maxLength, int bound) {

        /**
         * [a,b)
         * 取出一个给定的随机数
         */
        Random random = new Random(System.currentTimeMillis());
        int length = ThreadLocalRandom.current().nextInt(minLength, maxLength + 1);
//        int length = random.ints(1, maxLength, maxLength + 1).parallel().findFirst().getAsInt(); 这个不行?多试几次
        int[] result = new int[length];
        IntStream.range(0, length).forEach(
                i -> result[i] = random.nextInt(bound < 1 ? Integer.MAX_VALUE : bound)
        );
        return result;
    }

    public static void main(String[] args) {
//        Random random = new Random();
//        int i = random.nextInt(5);
//        System.out.println(i);

//        while (true) {
//            String numberString = getNumberString(11);
//            System.out.println(numberString);
//        }
//        String a = "生活的悲欢\n离,合永.远在。地-平_线以\n外，而眺望是一种青春的姿态";
//        while (true) {
//            String randomStringByLength = getRandomStringByLength(null,"测试", 2);
//            System.out.println(randomStringByLength);
//        }
//        Random random = new Random();
//        IntStream range = IntStream.range(1, 120);
////        range.forEach(System.out::println);
////        IntStream intStream = new IntStream();
//        IntStream ints = random.ints(1, 120);
//        ints.forEach(System.out::println);

        Random random = new Random();


        while (true) {
            int numbers = getNumbers(1, 100);
            System.out.println(numbers);
        }


    }

    @Test
    public void test() {
        int[] ints = randomArrays(10, 20, 100);
        System.out.println(ints.length);
        for (int i = 0; i < 10; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void testRandom() {
        int randomNum = ThreadLocalRandom.current().nextInt(10, 33 + 1);
//        System.out.println(randomNum);

        for (int i = 0; i < 100; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(10, 33 + 1));
        }
    }


    @Test
    public void testRandomInt() {
        int[] unSortNumbers;
        int n = 10;
        for (int i = 0; i < n; i++) {
            unSortNumbers = RandomUtils.randomArrays(10, 20, 100);
            System.out.println(unSortNumbers.length);
        }
    }
}
