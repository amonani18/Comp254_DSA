package question1;

public class Test {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.addLeft(root, 2);
        Position<Integer> right = tree.addRight(root, 3);
        tree.addLeft(left, 4);
        tree.addRight(left, 5);
        tree.addLeft(right, 6);

        // Computing and printing the path length
        int pathLength = tree.pathLength();
        System.out.println("Path Length of the tree: " + pathLength);
    }
}

