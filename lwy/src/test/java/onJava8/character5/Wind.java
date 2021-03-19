package onJava8.character5;


import onJava8.enumClass.Note;

class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}

public class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}

class Music{
    public static void tune(Instrument i){
        i.play(Note.MMIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
