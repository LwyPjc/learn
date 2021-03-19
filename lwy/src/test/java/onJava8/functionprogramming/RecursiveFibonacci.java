package onJava8.functionprogramming;

import onJava8.service.IntCall;

/**
 * 使用lambda方式实现斐波那契数列
 */
public class RecursiveFibonacci {
    static IntCall fib;

    public static void main(String[] args) {
        fib = n -> n == 0 ? 0 : n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2);
        for (int i = 0; i <= 10; i++)
            System.out.println(fib.call(i));
    }
}
