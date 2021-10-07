package onJava8.character5;

public class Mugs {
    Mug mug1;
    Mug mug2;
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("");
    }

    public static void main(String[] args) {
        Test t = new Test();
    }
}

class Mug{
    Mug(int marker){
        System.out.println("Mug("+marker
        +")");
    }
}

class Test{
    {
        System.out.println("nihao");
    }
}
