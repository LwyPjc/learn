package datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class Test implements Comparable<Test> {
    private int nums;

    public Test(int nums) {
        this.nums = nums;
    }


    @Override
    public int compareTo(Test o) {
        return this.nums - o.nums;
    }

    @Override
    public String toString() {
        return "Test{" +
                "nums=" + nums +
                '}';
    }

    public static void main(String[] args) {
        List<Test> list = new ArrayList<>();

    }
}
