package onJava8.character5;

public class VarArgs {
    static void printArray(Object[] args){
        for (Object obj:args){
            System.out.println(obj);
        }

    }


    public static void main(String[] args) {
        printArray(new Object[]{47,(float)3.14});
    }
}

class A{}
