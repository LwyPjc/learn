package worker.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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




}
