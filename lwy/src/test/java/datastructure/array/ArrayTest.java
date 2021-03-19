package datastructure.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        for (int i = 0;i<5;i++){
            arr.add(i);
        }
        System.out.println(arr);
//        arr.add(10);
        arr.remove(3);
        System.out.println(arr);

    }
}
