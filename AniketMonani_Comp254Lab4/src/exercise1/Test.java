package exercise1;
/*
 * Developed By - Aniket Monani
 * Student Id -   301422485
 */
public class Test {
    public static void main(String[] args) {
        PositionalList<Integer> list = new LinkedPositionalList<>();

        // Adding data in list
        Position<Integer> pos1 = list.addFirst(10);
        Position<Integer> pos2 = list.addLast(20);
        Position<Integer> pos3 = list.addLast(30);
        Position<Integer> pos4 = list.addLast(40);

        // Test
        System.out.println("Index of pos1: " + list.indexOf(pos1)); // Should print 0
        System.out.println("Index of pos2: " + list.indexOf(pos2)); // Should print 1
        System.out.println("Index of pos3: " + list.indexOf(pos3)); // Should print 2
        System.out.println("Index of pos4: " + list.indexOf(pos4)); // Should print 3
    }
}