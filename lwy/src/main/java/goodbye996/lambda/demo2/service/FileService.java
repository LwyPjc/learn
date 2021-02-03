package goodbye996.lambda.demo2.service;

import goodbye996.lambda.demo2.implService.FileConsumer;

import java.io.*;

public class FileService {

    public static void fileHandler(String url, FileConsumer fileConsumer) throws IOException {

        //创建文件读取流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(url)));
        //定义行变量和内容
        String readLine;
        StringBuffer stringBuffer = new StringBuffer();

        //循环读取文件内容
        while((readLine = bufferedReader.readLine()) != null){
            stringBuffer.append(readLine+"\n");
        }
        //调用函数式接口方法，将文件内容传递给lambda表达式，实现业务逻辑
        fileConsumer.fileHandler(stringBuffer.toString());
    }
}
