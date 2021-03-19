package onJava8.functionprogramming;

import onJava8.service.Body;
import onJava8.service.Description;
import onJava8.service.Multi;

public class LambdaExpressions {

    static Body bod = h -> h+"No parens";
    static  Body bod2 = (h) -> h+"More details";
    static Description d = ()->"Short info";
    static Multi m = (h,n)->h+n;
    static Description moreLines = ()->{
        System.out.println("more Lines");
        return "from moreLines";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh! "));
        System.out.println(bod2.detailed("hhh"));
        System.out.println(d.brief());
        System.out.println(m.twoArg("dd ",22));
        System.out.println(moreLines.brief());
    }

}
