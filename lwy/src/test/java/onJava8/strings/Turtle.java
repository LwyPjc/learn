package onJava8.strings;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name,Formatter f){
        this.name = name;
        this.f = f;
    }

    public void mave(int x, int y){
        f.format("%s The Turtle is at (%d,%d)%n",name,x,y);
    }

    public static void main(String[] args) {
        PrintStream outAlias= System.out;
        Turtle tommy = new Turtle("tommy",new Formatter(System.out));
        Turtle terry = new Turtle("Terry",new Formatter(outAlias));

    }
}
