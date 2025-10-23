package org.example.publisherSubscriberV1;

import java.util.Queue;

public class SubscriberV1 implements Runnable{
    private Queue<String> queue;

    public SubscriberV1(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("Queue is empty...");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                String message = queue.poll();
                System.out.println("Consumed " + message);
                try {
                    queue.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queue.notify();
            }
        }
    }
}
