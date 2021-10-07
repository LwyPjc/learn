package onJava8.character3;

public class Egg {
    private Yolk y;
    protected class Yolk{
        public Yolk(){
            System.out.println("Egg.Yolk()");
        }
    }

    Egg(){
        System.out.println("New Egg()");
        y = new Yolk();
    }
}
 class BigEgg extends Egg{
    public class Yolk{
        public Yolk(){
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();

    }
}
