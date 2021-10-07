package onJava8.character5;

public class Bath {
    private String
            s1 = "happy",
    s2 = "Happy",
    s3,s4;
    private Soap castile;
    private int i;
    private float toy;
    public Bath(){
        System.out.println("Inside Bath");
        s3 = "Joy";
        toy = 3.14f;
        castile = new Soap();
    }
}

class Soap{
    private String s;
    Soap(){
        System.out.println("Sopa()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}
