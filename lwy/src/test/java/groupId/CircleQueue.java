package groupId;

public class CircleQueue {



    public void quit(int startIndex, int targetIndex, int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }
        LoopList<Integer> list = new LoopList<>();
        Integer[] array = new Integer[nums.length];

        for (int i = 0;i<nums.length;i++){
          list.add(nums[i]);
        }

        for (int i = 0;i<targetIndex-1;i++){

        }

        int i = 0;
        while (i!=targetIndex){

        }


    }


    public static void main(String[] args) {
        LoopList<Integer> list = new LoopList<>();
        int[] nums = {3,2,5};
        for (int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }
//        list.remove(1);
        System.out.println(list);
    }

}
