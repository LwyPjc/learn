package datastructure.array;



public class Array<E> {
    //动态数组，实现增删改查

    private E[] data;
    //当前数组元素个数
    private int size;

    /**
     * 构造函数，传入数组的容量，构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        size = arr.length;
        for (int i = 0;i<size;i++){
            data[i] = arr[i];
        }
    }

    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组中添加新元素
     *
     * @param e
     */
    public void add(E e) {
        addByIndex(size, e);
    }

    /**
     * 在数组第一个位置添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        addByIndex(0, e);
    }

    /**
     * 在第index位置添加元素
     *
     * @param index
     * @param e
     */
    public void addByIndex(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取指定位置元素
    public E getElementByIndex(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index illegal.");
        return data[index];
    }

    //获取第一个元素
    public E getFirst() {
        return getElementByIndex(0);
    }

    //获取最后一个元素
    public E getLast() {
        return getElementByIndex(size - 1);
    }

    //修改指定位置元素
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index illegal.");
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中是否包含某元素，若有，返回下标，没有返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除下标为index的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal.");
        }
        E element = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size < data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return element;
    }

    /**
     * 根据需要改变数组大小
     *
     * @param newSize
     */
    private void resize(int newSize) {
        E[] newData = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }

    /**
     * 交换下标 k 和 下标j 位置的值
     *
     * @param k
     * @param j
     */
    public void swap(int k, int j) {
        if (k<0||k>size||j<0||j>size){
            throw new IllegalArgumentException("index illegal");
        }
        E e = data[k];
        data[k] = data[j];
        data[j] = e;
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        System.out.println(String.format("Array: size = %d, capacity = %d", size, data.length));
        result.append("[ ");
        for (int i = 0; i < size; i++) {

            result.append(data[i]);
            if (i != size - 1)
                result.append(",");
        }
        result.append(" ]");
        return result.toString();
    }


}
