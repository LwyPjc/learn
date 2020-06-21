package learn.java8.lambda.file;

import learn.java8.lambda.cart.Sku;
import org.junit.Test;

import java.io.*;
import java.util.function.Predicate;

/**
 * 处理文件
 */
public class FileService {

    @Test
    public void testFileHandler() throws IOException {
        FileService fileService = new FileService();
        fileService.fileHandler("C:\\Users\\99677\\Documents\\白夜行.md",
                str -> System.out.println(str)
        );

        // 使用jdk提供的函数式接口
        fileService.useJdkPredicate(sku -> sku.getSkuPrice() > 1000);
    }

    /**
     * 获取文件内容 调用函数式接口处理
     *
     * @param url
     * @param fileConsumer
     */
    public void fileHandler(String url, FileConsumer fileConsumer) throws IOException {
        // 读取文件流
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(url))
        );
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        // 产生string
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        // 处理文本
        fileConsumer.fileHandler(stringBuilder.toString());
    }

    /**
     * 函数式接口
     *
     * @param skuPredicate
     */
    public void useJdkPredicate(Predicate<Sku> skuPredicate) {

    }
}
