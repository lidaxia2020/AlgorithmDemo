package com.lidaxia.queue;

import java.util.Random;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2021/12/19 18:16
 */
public class Main {

    private static double testQueue(Queue<Integer> queue, int opcount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opcount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opcount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        System.out.println("ArrayQueue, time:" + testQueue(arrayQueue, opCount) + "s");

        System.out.println("LoopQueue, time:" + testQueue(loopQueue, opCount) + "s");

    }
}
