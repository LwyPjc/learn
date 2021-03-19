package onJava8.charcater4;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    private static void asListTest(){
        String stringArray[] = {"aa","bb","cc"};
        List<String> sList = Arrays.asList(stringArray);
        for (String str:sList){
            System.out.println(str);
        }
        System.out.println(sList.size());
        System.out.println("-------------");

        int intArray[] = {11,22,33};
        List intList = Arrays.asList(intArray);
        for (Object obj:intList){
            System.out.println(obj.toString());
        }

        System.out.println("--------------");

        Integer integerArray[]={11,22,33};
        List<Integer> objList = Arrays.asList(integerArray);
        for (int a : objList){
            System.out.println(a);
        }

        System.out.println("------------");
    }

    public static void main(String[] args) {
        asListTest();
    }
}
