package onJava8.character2;

import onJava8.service.Destination;

public class Parcel9 {
    public Destination destination(final String dest, final float price){
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);
                if(cost>100){
                    System.out.println("Over budget!");
                }
            }
            private String label = dest;
            @Override
            public String readLine() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania",101.395f);
    }
}
