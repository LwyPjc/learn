package worker.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class JunitTest {

    @Before
    public void beforeTest() {
        System.out.println("before");
    }

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("beforeClass");
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @Test
    public void test01(){

        Instant now = Instant.now();
        System.out.println(now);
    }

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
        System.out.println();
    }




}
