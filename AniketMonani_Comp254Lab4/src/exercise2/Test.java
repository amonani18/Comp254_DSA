package exercise2;
/*
 * Developed By - Aniket Monani
 * Student Id -   301422485
 */
public class Test {

    /**
     * Transfers all elements from stack S onto stack T, so that the element
     * that starts at the top of S is the first to be inserted onto T,
     * and the element at the bottom of S ends up at the top of T.
     * 
     * @param S the source stack
     * @param T the destination stack
     */
    public static <E> void transferViaArray(Stack<E> S, Stack<E> T) {
    	while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }
    
    public static <E> void transferViaStack(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>();
        Stack<Integer> T = new ArrayStack<>();

        // Push some elements onto stack S
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);
        

//        T.push(5);
//        T.push(6);
//        T.push(7);

        // Before transfer
        System.out.println("Stack S before transfer: " + S);
//        System.out.println("Stack T before transfer: " + T);

        // Transfer elements from S to T
        transferViaStack(S, T);

        // After transfer
//        System.out.println("Stack S after transfer: " + S);
        System.out.println("Stack T after transfer: " + T);
    }
}
