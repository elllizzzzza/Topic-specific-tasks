package org.example.publisherSubscriberWithQueue;

import java.util.concurrent.BlockingDeque;

public class Publisher implements Runnable{
    private final BlockingDeque<String> queue;

    public Publisher(BlockingDeque<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++){
            try {
                String message = "Message " + i;
                queue.put(message);
                System.out.println("Published " + message);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
