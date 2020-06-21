package tools;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.stream.Stream;

/**
 * 打印流
 */
public class PrintStreamUtil {

    public static void printObject(Stream stream) {
        if (stream == null) {
            System.out.println("流 为null");
        }
        stream.forEach(v -> System.out.println(JSON.toJSONString(v, true)));
    }

    public static void printObject(List list) {
        if (list == null) {
            System.out.println("list 为null");
        }
        list.forEach(v -> System.out.println(JSON.toJSONString(v, true)));
    }

    public static void printObject(Object o) {
        if (o == null) {
            System.out.println("对象 为null");
        }
        System.out.println(JSON.toJSONString(o, true));
    }
}
