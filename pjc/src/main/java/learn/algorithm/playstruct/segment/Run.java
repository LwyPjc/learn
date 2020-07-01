package learn.algorithm.playstruct.segment;

import org.junit.Test;


public class Run {

    /**
     * 线段树
     */
    @Test
    public void testSegmentTree(){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }

}
