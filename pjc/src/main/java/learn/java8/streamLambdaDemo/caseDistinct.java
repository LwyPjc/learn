package learn.java8.streamLambdaDemo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.thymeleaf.expression.Lists;
import tools.PrintStreamUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 用户请求的创建标签模型
 */
@Data
@AllArgsConstructor
class TagReqDTO {
    /**
     * 标签名字
     */
    private String name;
    /**
     * 标签值：年龄
     */
    private Integer age;
}

/**
 * 去重
 */
public class caseDistinct {

    /**
     * 从DB中查询出来的已经存在的标签名
     */
    List<String> tagListFromDB;
    /**
     * 用户请求的标签列表
     */
    List<TagReqDTO> tagListFromReq;


    @Before
    public void init() {
        // 数据库中存在的标签名列表
        tagListFromDB = Arrays.asList(
                "李四", "王五", "赵六");

        // 用户提交的
        tagListFromReq =  Arrays.asList(
                new TagReqDTO("张三", 10),
                new TagReqDTO("李四", 30),
                new TagReqDTO("张三", 11));
    }

    /**
     *
     */
    @Test
    public void distictTest(){
        tagListFromReq.stream()
                .filter(tag->!tagListFromDB.contains(tag.getName()))
                // 比较元素的equals
                .distinct()
                .forEach(PrintStreamUtil::printObject);
    }

}
