package leetcode.tree;

import algorithm4thedition.BinarySearchTree;

public class LT104_Maximum_Depth_of_Binary_Tree {


    private static int getMaxDepth(BinarySearchTree.Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getMaxDepth(node.left),getMaxDepth(node.right));
    }


    //要注意如果根节点的左或右子树为空的话是构不成子树的。
    // 而最小深度是要求从根节点到子树的。当左或右子树为空时，不符合要求。
    private static int getMinDepth(BinarySearchTree.Node node) {
        if (node == null)
            return 0;

        // null节点不参与比较
        if (node.left == null && node.right != null) {
            return 1 + getMinDepth(node.right);
        }
        // null节点不参与比较
        if (node.right == null && node.left != null) {
            return 1 + getMinDepth(node.left);
        }
        return 1 + Math.min(getMinDepth(node.left), getMinDepth(node.right));
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
        System.out.println(getMaxDepth(binarySearchTree.root));
        System.out.println(getMinDepth(binarySearchTree.root));
    }


}
