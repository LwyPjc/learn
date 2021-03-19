package datastructure;

import datastructure.queue.ArrayQueue;
import datastructure.queue.LoopQueue;
import datastructure.queue.service.Queue;

import java.util.Random;

/**
 * 队列和循环队列性能比较
 */
public class QueueTest<E> {

    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        return time;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayTime = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue : " + arrayTime + " s");

        Queue<Integer> loopQueue = new LoopQueue<>();
        double loopTime = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue: " + loopTime + " s");
    }
}
