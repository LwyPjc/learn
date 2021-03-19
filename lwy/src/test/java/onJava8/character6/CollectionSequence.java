package onJava8.character6;

import java.util.Map;

public class CollectionSequence {
    public static void main(String[] args) {
        for (Map.Entry entry:System.getenv().entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
}
