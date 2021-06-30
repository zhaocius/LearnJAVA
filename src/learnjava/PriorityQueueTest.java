package learnjava;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(6);

        priorityQueue.offer(3);
        priorityQueue.offer(4);
        priorityQueue.offer(1);
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        while(priorityQueue.size()>3)
            priorityQueue.poll();
        System.out.println(priorityQueue.toString());

    }
}
