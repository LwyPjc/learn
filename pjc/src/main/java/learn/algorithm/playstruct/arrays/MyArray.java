package learn.algorithm.playstruct.arrays;

/**
 * 自定义 数组
 */
public class MyArray<E> {
    private E[] data;
    private int size;

    public MyArray(int capacity) {
//        data = new E[capacity]; 不支持这样做
        data = (E[])new Object[capacity];
        size = 0;
    }

    public MyArray(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
