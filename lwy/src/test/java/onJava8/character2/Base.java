package onJava8.character2;

abstract class Base {
    Base(int i) {
        System.out.println("Base Constructor,i = " + i);
    }

    abstract void f();
}

class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("通过实例初始化，实现构造器效果");
            }

            @Override
            void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(22);
        base.f();
    }
}