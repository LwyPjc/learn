package datastructure.stack.service;

public interface Stack<E> {
    //栈大小
    int getSize();
    //入栈
    void push(E e);

    //出栈
    E pop();

    //获取栈顶元素
    E peek();

    boolean isEmpty();
}
