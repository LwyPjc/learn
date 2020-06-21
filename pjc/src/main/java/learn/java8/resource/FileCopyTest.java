package learn.java8.resource;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * JDK7 之前的文件拷贝功能
 * java8 的文件操作
 */
public class FileCopyTest {

    private String url = "D:/code/learn/frontEndlearning/pjc/src/main/java/";

    //    @Before
    @Test
    public void init() {
        URL systemResource = ClassLoader.getSystemResource("");
        url = systemResource.toString();
        System.out.println(url);
    }

    @Test
    /**
     * jdk7之前
     * 创建输入/输出流
     * 执行拷贝，读取文件内容，写入到另一个文件中
     * 关闭文件资源流
     */
    public void copyFile() {
        String originalUrl = url + "learn/java8/fileOriginal/ok.md";
        String targetUrl = url + "learn/java8/fileTarget/targetOk.md";

        FileInputStream originalFileInputStream = null;
        FileOutputStream targetFileOutStream = null;

        try {
            // 实例化输入 输出流
            originalFileInputStream = new FileInputStream(originalUrl);
            targetFileOutStream = new FileOutputStream(targetUrl);

            // 读取的字节信息
            int content;
            // originalFileInputStream.read() 为-1 表示没字节了
            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutStream.write(content);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (targetFileOutStream != null) {
                try {
                    targetFileOutStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (originalFileInputStream != null) {
                try {
                    originalFileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /**
     * jdk7之后关闭文件流
     */
    public void copyFileUseTry() {
        String originalUrl = url + "learn/java8/fileOriginal/ok.md";
        String targetUrl = url + "learn/java8/fileTarget/targetOkUseTry.md";

        try (
                FileInputStream originalFileInputStream = new FileInputStream(originalUrl);
                FileOutputStream targetFileOutStream = new FileOutputStream(targetUrl);
        ) {
            // 读取的字节信息
            int content;
            // originalFileInputStream.read() 为-1 表示没字节了
            while ((content = originalFileInputStream.read()) != -1) {
                targetFileOutStream.write(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
