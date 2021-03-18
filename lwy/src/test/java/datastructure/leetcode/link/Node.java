package datastructure.leetcode.link;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

//    @Override
//    public String toString() {
//        StringBuilder res = new StringBuilder();
//        Node node = this;
//        Node temp = recusion(node);
//        while (node != null) {
//            if (node.child!=null){
//
//               Node temp = node.child;
//               res.append("**"+node.val+" child ");
//                while(temp!=null){
//                    res.append(temp.val+"=》");
//                    temp = temp.next;
//                }
//            }
//            res.append(node.val+"->");
//            node = node.next;
//        }
//        res.append("NULL");
//        return res.toString();
//    }

    private Node recusion(Node modNode){
        StringBuilder res = new StringBuilder();
        Node node = modNode;
        while (node != null) {
            if (node.child!=null){
                Node temp = recusion(node.child);

            }
            node = node.next;
        }
        return modNode;
    }
}
