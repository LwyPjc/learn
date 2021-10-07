package onJava8.character6;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        for (String str:"hello world".split(" ")){
            stack.push(str);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }
}
