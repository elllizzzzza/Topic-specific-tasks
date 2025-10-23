package org.example.publisherSubscriberV1;

import java.util.Queue;

public class PublisherV1 implements Runnable{
    private Queue<String> queue;
    private int capacity = 10;

    public PublisherV1(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 16; i++) {
            synchronized (queue) {
                while (queue.size() == capacity) {
                    System.out.println("Queue is full...");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            String message = "Message " + i;
            queue.add(message);
            System.out.println("Produced " + message);
            queue.notify();
            }
        }
    }
}
