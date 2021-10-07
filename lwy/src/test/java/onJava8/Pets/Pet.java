package onJava8.Pets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pet {
    static List<Pet> list = new ArrayList<>();

    public static List<Pet> list() {

        Random random = new Random(47);
        int i = 0;
        while (i < 3) {
            i++;
            int index = random.nextInt(3);
            switch (index) {
                case 0:
                    list.add(new Rat());
                    break;
                case 1:
                    list.add(new Mutt());
                    break;
                case 2:
                    list.add(new Manx());
                    break;
                case 3:
                    list.add(new Cymric());
                    break;
                default:
                    break;
            }

        }
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
