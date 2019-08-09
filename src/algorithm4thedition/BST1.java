package algorithm4thedition;


public class BST1 {
    private Node root;             // root of BST

    private class Node {
        private int  key;           // sorted by key
        private String val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(int key, String val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

  
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public String get(int key) {
        return get(root, key);
    }

    private String get(Node x, int key) {
        if (x == null) return null;
        int cmp = key-x.key;
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(int key, String val) {
        
        root = put(root, key, val);
    
    }

    private Node put(Node x, int key, String val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key-x.key;
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }


    public static void main(String[] args) { 
        BST1 st = new BST1();
        st.put(1, "1s");
        st.put(2, "2s");
        st.put(3, "3s");
        st.put(4, "4s");
        System.out.println(st.get(4));
    }
}

