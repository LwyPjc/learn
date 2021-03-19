package datastructure.link;

import datastructure.stack.service.Stack;

/**
 * 使用链表是实现栈
 */
public class LinkedListStack<E> implements Stack<E> {

    private MyLinkedListWithHead<E> linkedList;

    public LinkedListStack() {
        linkedList = new MyLinkedListWithHead<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("stack top: ");
        result.append(linkedList);
        return result.toString();
    }
}
