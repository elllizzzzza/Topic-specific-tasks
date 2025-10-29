package org.example;

import org.example.publisherSubscriberV1.PublisherV1;
import org.example.publisherSubscriberV1.SubscriberV1;
import org.example.publisherSubscriberWithQueue.Publisher;
import org.example.publisherSubscriberWithQueue.Subscriber;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();

        Thread publisher = new Thread(new Publisher(queue));
        Thread subscriber = new Thread(new Subscriber(queue));

        publisher.start();
        subscriber.start();

//        Queue<String> queue1 = new PriorityQueue<>();
//        Thread publisher1 = new Thread(new PublisherV1(queue1));
//        Thread consumer1 = new Thread(new SubscriberV1(queue1));
//
//        publisher1.start();
//        consumer1.start();
    }
}