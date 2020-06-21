package learn.java8.guava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不可变集合
 */
public class AJDKImmutableTest {

    /**
     * JDK 自带的这种方式不好
     */
    @Test
    public void testImmutable() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(5);
        integerList.add(8);

        List<Integer> immutableList = Collections.unmodifiableList(integerList);

        immutableList.remove(0);
    }

}
