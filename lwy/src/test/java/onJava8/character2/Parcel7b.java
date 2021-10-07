package onJava8.character2;

import onJava8.service.Contents;

public class Parcel7b {
    class MyContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents(){
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b pb= new Parcel7b();
        Contents c = pb.contents();
    }
}
