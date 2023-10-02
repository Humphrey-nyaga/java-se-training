package com.systechafrica.part3.collections;


import java.util.LinkedList;
import java.util.Queue;

public class WorkingWithQueues {
    public static void main(String[] args) {
        Queue<PrintJob> queue = new LinkedList<>();
        queue.offer(new PrintJob("Book"));
        queue.offer(new PrintJob("Newspaper"));
        queue.offer(new PrintJob("Article"));
        queue.offer(new PrintJob("Flyer"));
        queue.add(new PrintJob("Journal")); // insert elements and throws exception if insert fails
        System.out.println("queue = " + queue);
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.poll() = " + queue.poll()); // remove first element without exception. returns null if queue is empty
        System.out.println("queue.remove() = " + queue.remove()); // throws exception if queue is empty
        queue.offer(new PrintJob("Magazine")); // insert element or returns false otherwise
        System.out.println("queue.element() = " + queue.element()); // retrieve object at the front of queue and throws exception if queue is empty
        System.out.println("queue.peek() = " + queue.peek()); // retrieve object at the front of the queue and returns null if queue is empty

    }
}
