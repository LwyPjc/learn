package datastructure;

import datastructure.link.LinkedListStack;
import datastructure.stack.service.Stack;

public class StackTest {


    public static void main(String[] args) {
        Stack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i = 0;i<5;i++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        linkedListStack.pop();
        System.out.println(linkedListStack);

    }

}
