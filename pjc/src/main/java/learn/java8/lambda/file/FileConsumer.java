package learn.java8.lambda.file;

/**
 * 文件处理函数时接口
 */
@FunctionalInterface
public interface FileConsumer {

    /**
     * @param fileContent 处理文件内容
     */
    void fileHandler(String fileContent);
}
