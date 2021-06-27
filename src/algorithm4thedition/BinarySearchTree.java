package algorithm4thedition;

public class BinarySearchTree {
    private Node root;
    private class Node {
        private int key;
        private String value;
        private Node left, right;
        private int N;
        public Node(int key, String value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
    public int size() {
        return size(root);
    }
    public int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }
    public String get(int key) {
        return get(root, key);
    }
    private String get(Node x, int key) {
        if (x == null)
            return null;
        if (key <x.key)
            return get(x.left, key);
        else if (key > x.key)
            return get(x.right, key);
        else
            return x.value;
    }
    public void put(int key, String value) {
        root=put(root, key, value);
    }
    private Node put(Node x, int key, String value) {
        if (x == null)
            return new Node(key, value, 1);
        if (key < x.key)
            x.left = put(x.left, key, value);
        if (key > x.key)
            x.right = put(x.right, key, value);
        else
            x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int getDepth() {
        return getDepth(root);
    }


    private int getDepth(Node node) {
        if (node == null)
            return 0;
        else {
            int m = getDepth(node.left);
            int n = getDepth(node.right);
            if (m > n)
                return m + 1;
            else
                return n + 1;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(6, "zhangsan6");
        binarySearchTree.put(3, "zhangsan3");
        binarySearchTree.put(8, "zhangsan8");
        binarySearchTree.put(1, "zhangsan1");
        binarySearchTree.put(5, "zhangsan5");
        binarySearchTree.put(7, "zhangsan7");
        binarySearchTree.put(9, "zhangsan9");
        binarySearchTree.put(0, "zhangsan0");
        binarySearchTree.put(2, "zhangsan2");
        binarySearchTree.put(4, "zhangsan4");
        binarySearchTree.put(10, "zhangsan10");
        System.out.println(binarySearchTree.get(4));
        System.out.println(binarySearchTree.getDepth());

    }
}