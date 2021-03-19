package onJava8.character2;

public class MNA {
    private void f() {
    }

    class A {
        private void g() {
        }

        public class B {
            void h(){
                g();
                f();
            }
        }
    }
}

class MultiNestingAccess{
    public static void main(String[] args){
       MNA mna = new MNA();
       MNA.A mnaa = mna.new A();
       MNA.A.B mnaab = mnaa.new B();
       mnaab.h();
    }
}
