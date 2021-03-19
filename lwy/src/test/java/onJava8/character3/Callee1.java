package onJava8.character3;

import onJava8.service.Incrementable;

class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        ++i;
        System.out.println("callee1 i = " + i);
    }
}

class MyIncrement {
    public static void f(MyIncrement mi) {
        mi.increment();
    }

    public void increment() {
        System.out.println("MyIncrement increment() ");
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println("callee2 i = " + i);
    }

    private class Closure implements Incrementable {

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getIncrementable(){
        return new Closure();
    }
    

}

class Caller{
    private Incrementable callbackInference;
    Caller(Incrementable cbh){
        callbackInference = cbh;
    }
    void go(){
        callbackInference.increment();
    }
}

class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getIncrementable());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
