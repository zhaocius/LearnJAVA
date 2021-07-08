package leetcode.tree;

import algorithm4thedition.BinarySearchTree;

public class LT226_Invert_Binary_Tree {

    public BinarySearchTree.Node invertTree(BinarySearchTree.Node root) {
        if(root == null) return null;
        BinarySearchTree.Node left = root.left; // 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
