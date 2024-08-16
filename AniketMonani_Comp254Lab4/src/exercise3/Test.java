package exercise3;
/*
 * Developed By - Aniket Monani
 * Student Id -   301422485
 */
public class Test {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        LinkedQueue<Integer> queue2 = new LinkedQueue<>();

        // queue1
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // queue2
        queue2.enqueue(4);
        queue2.enqueue(5);
        queue2.enqueue(6);

        // Output queue1 before concatenation
        System.out.println("Queue 1 before concatenation: " + queue1);
        System.out.println("Queue 2 before concatenation: " + queue2);
        
        // Concatenate queue2 to queue1
        queue1.concatenate(queue2);

        // Output queue1 after concatenation
        System.out.println("Queue 1 after concatenation: " + queue1);
        System.out.println("Queue 2 after concatenation: " + queue2);
    }
}
