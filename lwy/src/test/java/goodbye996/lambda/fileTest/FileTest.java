package goodbye996.lambda.fileTest;

import goodbye996.lambda.demo2.implService.FileConsumer;
import goodbye996.lambda.demo2.service.FileService;
import org.junit.Test;

import java.io.IOException;

public class FileTest {


    @Test
    public void fileHandler() throws IOException {
        //通过lambda表达式打印文件内容
        FileService.fileHandler("src\\main\\java\\goodbye996" +
                        "\\lambda\\demo2\\service\\FileService.java",
                fileContent -> System.out.println(fileContent));

        //通过匿名类方式
        FileService.fileHandler("src\\main\\java\\goodbye996\\" +
                "lambda\\demo2\\service\\FileService.java", new FileConsumer() {
            @Override
            public void fileHandler(String fileContent) {
                System.out.println(fileContent);
            }
        });
    }
}
