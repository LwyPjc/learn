package datastructure.queue;

import datastructure.queue.service.Queue;

/**
 * 循环队列
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;

    //指向头部
    private int front;

    //指向尾部
    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        //因为判断队列满的条件是 (tail+1)%capacity == front; 所以要多一个存储单元
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 向循环队列中添加元素
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            //如果队列已经满了，扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("loopQueue is empty,can't dequeue");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //如果当前存放的元素小于数组总容量的1/4，则缩小数组容量
        if (size <= getCapacity()  / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        return null;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("size = %d,\t capacity = %d \n",size,getCapacity()));
        result.append("LoopQueue: front [ ");
        for (int i = front;i!=tail;i=(i+1)%data.length){
            result.append(data[i]);
            if ((i+1)%data.length!=tail){
                result.append(", ");
            }
        }
        result.append(" ] tail");
        return result.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0;i<9;i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue.toString());
            if (i%3==2){
                loopQueue.dequeue();
                System.out.println(loopQueue.toString());
            }
        }
    }
}
