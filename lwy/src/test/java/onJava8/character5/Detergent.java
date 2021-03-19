package onJava8.character5;

public class Detergent extends Cleaner{
    @Override
    public void scrub() {
        append("Detergent.scrub()");
        super.scrub();
    }
    public void form(){
        append("form()");
    }

    public static void main(String[] args) {
        Detergent d = new Detergent();
        d.scrub();
        System.out.println(d);
    }
}

class Cleaner{
    private String s = "Cleaner";
    public void append(String a){
        s+=a;
    }
    public void dilute(){
        append(" dulite()");
    }
    public void apply(){
        append("apply()");
    }

    public void scrub(){
        append("scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleaner x = new Cleaner();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

