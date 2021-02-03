package goodbye996.lambda.demo2.implService;

/**
 * 文件处理函数式接口
 */

/**
 * @FunctionalInterface 注解用来校验该接口是否是函数式接口
 * （接口中只有一个抽象方法），不是必须要写
 */
@FunctionalInterface
public interface FileConsumer {
    /**
     * 函数式接口抽象方法
     * @param fileContent
     */
    void fileHandler(String fileContent);
}
