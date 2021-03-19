package onJava8.functionprogramming;

public class RunnableMethodReference {
    public static void main(String[] args) {
        /**
         * 只有匿名内部类才要求显示声明run方法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
                () -> System.out.println("lambda")
        ).start();

        new Thread(Go::go).start();
    }


}

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}