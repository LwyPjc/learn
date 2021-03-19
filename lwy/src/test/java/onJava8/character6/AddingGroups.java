package onJava8.character6;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15, 16);
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(17, 18);
        list.set(1, 99);
        for (int i : list) {
//            System.out.println(i);
        }
        System.out.println(Arrays.toString(collection.toArray()));
    }
}
