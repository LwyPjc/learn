package onJava8.functionprogramming;

import onJava8.service.Callable;

public class MethodReference {
    static void hello(String name){
        System.out.println("Hello,"+name);
    }
    static class Description{
        String about;
        Description(String desc){
            about = desc;
        }
        void help(String msg){
            System.out.println(about+" "+msg);
        }
    }
    static class Hepler{
        static void assist(String msg){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
       Describle describle = new Describle();
        Callable c = describle::show;
        c.call("call()");
        c = new Description("xiaoming")::help;
    }
}

class Describle{
    void show(String msg){
        System.out.println("Describle show() "+msg);
    }
}
