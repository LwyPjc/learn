package onJava8.character5;

public class OrderOfInitialization {

    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}

class Windows{
    Windows(int winder){
        System.out.println("Windows("+winder+")");
    }
    Windows(Windows w){
        System.out.println("hhhh");
    }
}

class House{
    Windows w1 = new Windows(1);

    House(){
        System.out.println("House()");
        w3 = new Windows(33);
    }

    Windows w2 = new Windows(2);

    void f(){
        System.out.println("f()");
    }

    Windows w3 = new Windows(3);
}

