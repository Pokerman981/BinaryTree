
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree().createBinaryTree();
        int num = binaryTree.search(binaryTree.root, 8) == null ? -1 : binaryTree.search(binaryTree.root, 8).value;
        if (num == -1) {
            System.out.println("This number isn't in the binary tree! " + num);
        } else {
            System.out.println("This number is in the binary tree! " + num);
        }
    }

}

class BinaryTree {
    Node root;

    public Node search(Node root, int value) {
        if (root == null || root.value == value) return root;
        if (root.value > value) return search(root.right, value);

        return search(root.right, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) return new Node(value);

        if (value < current.value) current.left = addRecursive(current.left, value);
        else if (value > current.value) current.right = addRecursive(current.right, value);
        else return current;

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public static BinaryTree createBinaryTree() {
        Random random = new Random();
        BinaryTree bt = new BinaryTree();

        for (int i = 0; i < 10; i++) {
            bt.add(random.nextInt(20));
        }

        return bt;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
