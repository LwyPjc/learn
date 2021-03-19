package onJava8.character5;

public class ReferenceCounting {
    public static void main(String[] args) {


        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };
        for (Composing c:composing){
            c.dispose();
        }
    }

}

class Shared {
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;

    Shared() {
        System.out.println("creating Shared " + id+"counter"+counter);
    }

    public void addRef() {
        refCount++;
        System.out.println("Shared refCount ="+refCount);
    }

    public void dispose() {
        if (--refCount == 0)
            System.out.println("Disposing " + this);
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static  long counter = 0;
    private final long id = counter++;

    Composing(Shared shared) {

        System.out.println("Creating id" + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing id" + this+" counter "+counter);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
