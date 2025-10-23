package org.example.publisherSubscriberWithQueue;

import java.util.concurrent.BlockingDeque;

public class Subscriber implements Runnable{
    private final BlockingDeque<String> queue;

    public Subscriber(BlockingDeque<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            String message;
            try {
                message = queue.take();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumed " + message);
        }
    }
}
