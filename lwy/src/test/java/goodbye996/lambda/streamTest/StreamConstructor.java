package goodbye996.lambda.streamTest;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建流的4中方式
 */
public class StreamConstructor {

    /**
     * 由数值直接构建流
     */
    @Test
    public void streamFromValue(){
        Stream stream = Stream.of(1,2,3,4,5);
        stream.forEach(System.out::println);
    }

    /**
     * 通过数组构建流
     */
    @Test
    public void streamFromArray(){
        int[] arr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
    }

    /**
     * 通过文件形式生成流
     * @throws IOException
     */
    @Test
    public void streamFromFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("goodbye996\\lambda\\streamTest\\StreamConstructor.java"));
        lines.forEach(System.out::println);
    }

    /**
     * 通过函数生成流
     */
    @Test
    public void streamFromFunction(){
//        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);

        Stream<Double> generate = Stream.generate(Math::random);

//        iterate.forEach(System.out::println);
        generate.limit(100).forEach(System.out::println);
    }
}
