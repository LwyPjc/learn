package learn.java8.guava;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BGoogleImmutableCollection {

    /**
     * 三种方式
     * ImmutableSet.copyOf
     * ImmutableSet.of
     * ImmutableSet.builder()
     */
    @Test
    public void create() {
        List<Integer> integerList = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
            }
        };
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(integerList);

        ImmutableSet<Integer> of = ImmutableSet.of(1, 2, 3);

        ImmutableSet.Builder<Object> add = ImmutableSet.builder()
                .add(1)
                .add(3);

    }

}
