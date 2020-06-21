package learn.java8.optional;

import org.junit.Test;

import java.nio.file.attribute.AclEntryPermission;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 判空
 */
public class OptionalTest {

    /**
     * 3种创建Optional
     * empty
     * of 非null
     * ofNullable
     */
    @Test
    public void createOptional() {
        Optional<Object> empty = Optional.empty();
        Optional<String> aa = Optional.of("aa");
        Optional<Object> o = Optional.ofNullable(null);
    }

    @Test
    /**
     * 判空
     */
    public void nullAble() {
        Optional<String> cc = Optional.ofNullable("cc");

        // TODO 不要使用下面的方式判空
        boolean present = cc.isPresent();

        /**
         * 非空时才执行括号里面的方法
         * 类似的 map filter flatMap
         */
        cc.ifPresent(System.out::println);

        /**
         * 当为空时
         * orElse 返回一个值
         * orElseGet 可以做业务处理
         */
        cc.orElse("默认值");
        cc.orElseGet(() -> {
            return "业务处理";
        });
//        cc.orElseThrow(() -> {
//            throw new RuntimeException("不能为空");
//        });

    }

    @Test
    /**
     * Optional 与 Stream
     */
    public void streamOptional() {
        List<String> stringList = null;
        Optional.ofNullable(stringList)
        .map(List::stream)
                .orElseGet(Stream::empty)
                ;
    }
}
