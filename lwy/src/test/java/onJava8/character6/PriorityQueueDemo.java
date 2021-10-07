package onJava8.character6;

import org.junit.Test;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>();
        Random random = new Random(47);
        for (int i = 0;i<10;i++)
            priorityQueue.offer(random.nextInt(i+10));
        QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25,22,20);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);

        priorityQueue = new PriorityQueue<>(
                ints.size(), Collections.reverseOrder()
        );
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);

        System.out.println(priorityQueue);
    }

    @Test
    public void test(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0;i<10;i++){
            priorityQueue.offer(i);
        }
        while(priorityQueue.peek()!=null)
            System.out.print(priorityQueue.remove()+" ");
        System.out.println();
        List<Integer> ints = Arrays.asList(20,21);
        priorityQueue = new PriorityQueue<>(1,Collections.reverseOrder());
        priorityQueue.addAll(ints);
        System.out.println(priorityQueue);
    }
}
