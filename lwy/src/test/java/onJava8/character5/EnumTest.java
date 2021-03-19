package onJava8.character5;

import onJava8.enumClass.Sponge;

public class EnumTest {
    public static void main(String[] args) {
        Sponge sponge = Sponge.BLUE;
        System.out.println(sponge.ordinal());
    }
}
