package learn.algorithm.playstruct.binTree;

import org.junit.Test;

/**
 * 测试
 */
public class Run {

    /**
     * 测试前序遍历
     * 5
     * 3  6
     * 2 4  null  8
     */
    @Test
    public void testPreOrder() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.addVersionTwo(num);
        }
        System.out.println(bst);
        System.out.println("====先序-----");
        bst.preOrder();
        System.out.println("======中序======");
        bst.midOrder();
        System.out.println("=======后序====");
        bst.afterOrder();
        System.out.println("====== 非递归 前序 ======");
        bst.preOrderUseLoop();
        System.out.println("====层序遍历=======");
        bst.layerOrder();
    }

}
