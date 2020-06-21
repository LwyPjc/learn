package learn.java8.resource;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 关闭资源
 */
public class ResourceCloseVs {

    /**
     * resource 关闭流
     */
    @Test
    public void closeResource() {
        // 路径
        String url = "";
        try (
                // 声明，创建文件的读取流
                FileInputStream fileInputStream = new FileInputStream(url);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
