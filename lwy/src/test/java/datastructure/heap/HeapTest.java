package datastructure.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeapTest {
    public static void main(String[] args) {
        int n = 10000;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Random().nextInt(10000);
        }
        System.out.println("Heapify: "+testHeap(array, true));
        System.out.println("No Heapify: "+testHeap(array, false));

    }


    /**
     * 使用 Heapify方法和遍历方法转化普通数组，比较两者效率
     *
     * @param array
     * @param isHeapify
     */
    private static double testHeap(Integer[] array, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> heap;
        int n = 10000;
        List<Integer> list = new ArrayList<>();
        if (isHeapify) {
            heap = new MaxHeap<>(array);
            for (int i = 0; i < n; i++) {
                list.add(heap.extractMax());
            }
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1) < list.get(i)) {
                    throw new IllegalArgumentException("Error~");
                }
            }
        } else {
            heap = new MaxHeap<>();
            for (int i : array) {
                heap.add(i);
            }

            for (int i = 0; i < n; i++) {
                list.add(heap.extractMax());
            }
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1) < list.get(i)) {
                    throw new IllegalArgumentException("Error~");
                }
            }
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        return time;

    }

    public static void test01() {
        int n = 10000;
        MaxHeap<Integer> heap = new MaxHeap<>();

        for (int i = 0; i < n; i++) {
            heap.add(new Random().nextInt(10000));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(heap.extractMax());
        }
        for (int i = 1; i < n; i++) {
            if (list.get(i - 1) < list.get(i)) {
                throw new IllegalArgumentException("Error~");
            }
        }
        System.out.println("completed!");
    }
}
