package onJava8.character2;

import onJava8.service.Destination;

public class Parcel5 {
    public Destination destination(String s) {
        final class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLine() {
                return null;
            }
        }
        return new PDestination(s);

    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("hello");
    }
}
