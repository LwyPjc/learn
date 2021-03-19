package onJava8.character3;

import onJava8.service.Counter;

public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return ++count;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return ++count;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        Counter c2 = localInnerClass.getCounter2("Anonymous inner"),
                c1 =localInnerClass.getCounter("Local inner");
        for (int i = 0;i<5;i++){
            System.out.println(c2.next());
        }
        for (int i = 0;i<5;i++){
            System.out.println(c1.next());
        }
    }
}