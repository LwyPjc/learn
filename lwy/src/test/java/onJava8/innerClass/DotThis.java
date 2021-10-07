package onJava8.innerClass;

public class DotThis {
    void f(){
        System.out.println("DotThis.f()");
    }

    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        Inner inner = dt.inner();
        inner.outer().f();
//        dti.outer().f();
    }

}
