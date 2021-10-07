package onJava8.strings;

import java.util.Random;
import java.util.stream.Collectors;

public class UsingStringBuilder {
    public static String string1(){
        Random random = new Random(47);
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0;i<25;i++){
            stringBuilder.append(random.nextInt(100));
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public static String string2() {
        String result = new Random(47)
                .ints(25,0,100)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        return "[ "+result+"]";
    }

    public static void main(String[] args) {
        System.out.println(string1());
        System.out.println(string2());
    }


}
