package onJava8.functionprogramming;

import onJava8.service.IntCall;
import org.junit.Test;

public class RecursiveFactorial {

    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    public int recur(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * recur(n - 1);
    }

    @Test
    public void test() {
        System.out.println(recur(0));
    }

    /**
     * 使用lambda编程方式实现阶乘
     */
    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for (int i = 0; i <= 10; i++) {
            System.out.println(fact.call(i));
        }
    }

}

