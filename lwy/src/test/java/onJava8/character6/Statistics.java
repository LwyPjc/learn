package onJava8.character6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<1000;i++){
            int r = random.nextInt(20);
            Integer freq = map.get(r);
            map.put(r,freq==null?1:freq+1);
        }
        map.keySet().stream()
                .forEach(i-> System.out.println(i));
//        System.out.println(map);
    }
}
