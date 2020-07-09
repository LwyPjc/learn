package tools;

/**
 * 数学工具
 */
public class MathTool {

    /**
     * 交换两个元素 好像没什么用啊
     *
     * @param t1
     * @param t2
     * @param <T>
     */
    public static <T> void swap(T t1, T t2) {
        T temp;
        temp = t1;
        t1 = t2;
        t2 = temp;
    }

    /**
     * 交换两个元素 好像没什么用啊
     *
     * @param <T>
     */
    public static void swapWithArray(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
