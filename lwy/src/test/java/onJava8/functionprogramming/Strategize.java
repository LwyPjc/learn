package onJava8.functionprogramming;

import onJava8.service.Strategy;

public class Strategize {
    Strategy strategy;
    String msg;
    Strategize(String msg){
        strategy = new Soft();
        this.msg = msg;
    }

    void communicate(){

    }
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}