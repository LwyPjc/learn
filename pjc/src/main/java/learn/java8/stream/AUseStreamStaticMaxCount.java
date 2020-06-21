package learn.java8.stream;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 统计一个字符串中出现次数最多的字符 或 次数
 */
public class AUseStreamStaticMaxCount {

    public static void main(String[] args) {
        String str = "qwertyuiopwerwerwwwwwueyfuewww";
        Map<String, Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<String, Long>> max = collect.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        System.out.println(JSON.toJSONString(max));

        Arrays.asList(str.toCharArray()).stream().forEach(System.out::println);

//        Arrays.stream(str.toCharArray())
        Stream.of(str.toCharArray()).forEach(System.out::println);

        String[] stringArray ={"aa","bb"};

        Arrays.stream(stringArray).forEach(System.out::println);

    }

    /**
     * 使用map的values 来做计算
     * 如何处理 List<Map<String,Integer>>
     * 找出最大的Integer的那个map
     */
    @Test
    public void useMapValues(){
        String str = "qwertyuiopwerwerwwwwwueyfuewww";

//        Arrays.stream(str.split(""))
//                .collect(Collectors.groupingBy((x) -> x)).values().stream()
//                .map(object -> {
//                    Map<String,Integer> map = new HashMap<>(); map.put(object.get(0), object.size());
//                    return map;
//                })
//                .mapToInt(map-> {
//                    return map.get(map.keySet().toArray()[0]);
//                }).forEach(System.out::println);

        Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy((x) -> x)).values().stream()
                .map(object -> {
                    Map<String,Integer> map = new HashMap<>(); map.put(object.get(0), object.size());
                    return map;
                });
//                .filter()
    }




}
