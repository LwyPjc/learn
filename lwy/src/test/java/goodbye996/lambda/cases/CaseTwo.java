package goodbye996.lambda.cases;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//标签去重
public class CaseTwo {

    /**
     * 用户请求的从创建标签模型
     */
    class TagReqDto{
        /**
         * 标签名称
         */
        private String name;

        /**
         * 标签纸：年龄
         */
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public TagReqDto(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    //从数据库中查找的标签列表
    List<String> tagListFromDB;
    //用户请求的标签列表
    List<TagReqDto> tagListFromReq;

    @Before
    public void init(){
        //数据库中存在的标签名列表
        tagListFromDB = new ArrayList<>();
        tagListFromDB.add("赵六");
        tagListFromDB.add("李四");
        tagListFromDB.add("王五");

        //用户提交的
        tagListFromReq = new ArrayList<>();
        TagReqDto zsTag = new TagReqDto("张三",10);
        tagListFromReq.add(zsTag);
        tagListFromReq.add(new TagReqDto("李四",30));
        tagListFromReq.add(zsTag);

    }

    @Test
    public void distinctTest(){
        tagListFromReq.stream()
                //TODO true:通过测试，数据不过滤，false:未通过测试，数据被过滤
                .filter(tag->!tagListFromDB.contains(tag.getName()))
                //TODO 使用equals比较元素
                .distinct()
                .forEach(tag-> System.out.println(JSON.toJSONString(tag,true)));
    }
}
