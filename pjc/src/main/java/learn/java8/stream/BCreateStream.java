package learn.java8.stream;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 转化为流
 */
public class BCreateStream {

    /**
     * 各种类型转为流
     * char[] 怎么转为流？Character[]可以
     */
    public void convertToStream() {
        char[] chars = {'a', 'b', 'c'};

        Character[] characters = {'b', 'c', 'd'};

        String str ="hello world";

        /**
         * char[] 不能使用 Arrays.stream
         */
//        Arrays.stream(chars)

        /**
         * 对象数组都可以使用这种方式 转换成流
         */
        Stream<Character> characterStream1 = Arrays.stream(characters);

        /**
         * 使用 Stream.of 也能使对象数组转成流
         */
        Stream<Character> characterStream2 = Stream.of(characters);

        /**
         * char[] 转 Stream<char[]>
         */
        Stream<char[]> chars1 = Stream.of(chars);

        /**
         * 字符串转 Stream<char[]>
         */
        Stream<char[]> stream = Stream.of(str.toCharArray());

        /**
         * 字符串转字符串数组 再转String流
         */
        String[] split = str.split("");

        HashMap<String,Integer> stringIntegerHashMap = new HashMap<>();

        /**
         * map 转 Stream<Map<X, Y>>
         */
        Stream<HashMap<String, Integer>> stringIntegerHashMap1 = Stream.of(stringIntegerHashMap);

        /**
         * map的 entrySet<> 拿到Set<Map.Entry<K,V>> 再转String
         */
        Stream<Map.Entry<String, Integer>> stream1 = stringIntegerHashMap.entrySet().stream();

        // 拿到 List<HashMap<String, Integer>>
        List<HashMap<String, Integer>> hashMaps = Arrays.asList(stringIntegerHashMap);
        /**
         * 产生 Stream<HashMap<String, Integer>> 流元素是个map
         * todo 如何处理map
         */
        Stream<HashMap<String, Integer>> stream2 = hashMaps.stream();


    }

    /**
     * Stream 数组 参数
     */
    @Test
    public void testConvertToStreamByParams() {
        convertToStreamByParams("abc", "two");
    }

    public void convertToStreamByParams(String... strs) {
        /**
         * 产生String流
         */
        Stream<String> stream = Arrays.stream(strs);
        printStreamMeta(stream);

        /**
         * 产生String流
         */
        Stream<String> stream1 = Arrays.asList(strs).stream();
        printStreamMeta(stream1);

        /**
         * 产生String流
         */
        Stream<String> strs1 = Stream.of(strs);
        printStreamMeta(strs1);
    }

    /**
     * 输出流元素
     *
     * @param stream
     */
    private void printStreamMeta(Stream stream) {
        if (stream == null) {
            System.out.println("流 为null");
        }
        stream.forEach(v -> System.out.println(JSON.toJSONString(v)));
    }
}
