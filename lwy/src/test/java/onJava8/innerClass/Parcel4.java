package onJava8.innerClass;

import onJava8.service.Contents;
import onJava8.service.Destination;

public class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected final class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLine() {
            return label;
        }
    }

    public PDestination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}

class TestParcel4 {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents contents = p.contents();
        Parcel4.PDestination destination = p.destination("Tasmania");

    }

    public void test(){

    }
}

