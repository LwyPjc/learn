package onJava8.character5;

public class Person {
    public void eat(Apple apple){
        System.out.println("Yummy");
    }
}

class Apple{
    Apple getPeeled(){
        return Peeler.peel(this);
    }
}

class Peeler{
    static Apple peel(Apple apple){
        return apple;
    }
}

class PassingThis{
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
