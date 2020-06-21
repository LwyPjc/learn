package learn.java8.stream;

import org.junit.Test;
import tools.PrintStreamUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 流的四种构建形式
 * 数值 Stream.of
 * <p>
 * 数组 Arrays.stream
 * <p>
 * 文件
 * <p>
 * 函数 有意思
 */
public class EStreamConstructor {


    @Test
    /**
     * 通过文件构建流
     */
    public void streamFromFile() throws IOException {
        Stream<String> stringStream = Files.lines(Paths.get("路径"));
    }

    @Test
    /**
     * 利用函数生成流 无限流 有意思
     */
    public void streamFromFunction(){
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.limit(10).forEach(PrintStreamUtil::printObject);
        // 流只能处理一次噢 下面会IllegalStateException
        iterate.forEach(PrintStreamUtil::printObject);
    }

    @Test
    /**
     * 使用 Stream.generate
     */
    public void streamFromGenerate(){
        Random random = new Random();
        Stream<Integer> generate = Stream.generate(random::nextInt);
        generate.limit(100).forEach(PrintStreamUtil::printObject);
    }
}
