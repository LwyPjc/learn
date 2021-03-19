package datastructure.segment;

public class Main {
    public static void main(String[] args) {
//       test01();
        test02();
    }

    public static void test01(){
        Integer[] nums= {2,-1,0,5,3,-3};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,(a,b)->a+b);
        System.out.println(segTree);
    }

    public static void test02(){
        Integer[] nums= {2,-1,0,5,3,-3};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,(a,b)->a+b);
        System.out.println(segTree.query(0, 2));

    }
}
