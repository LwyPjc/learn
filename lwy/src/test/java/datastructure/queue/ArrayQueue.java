package datastructure.queue;

import datastructure.array.Array;
import datastructure.queue.service.Queue;


/**
 * 队列
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.add(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: front [ ");
        int size = array.getSize();
        for (int i = 0; i < size; i++) {
            result.append(array.getElementByIndex(i));
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append(" ] tail");
        return result.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue.toString());
            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue.toString());
            }
        }
    }
}
