package leetcode.tree;


import algorithm4thedition.BinarySearchTree;

public class LT617_Merge_Two_Binary_Trees {
/*
    Input:
    Tree 1                     Tree 2
            1                         2
            / \                       / \
            3   2                     1   3
            /                           \   \
            5                             4   7
    Output:
    Merged tree:
            3
            / \
            4   5
            / \   \
            5   4   7

 */

    
public BinarySearchTree.Node mergeTrees(BinarySearchTree.Node t1, BinarySearchTree.Node t2) {
    if(t1 == null && t2 == null) return null;
    if(t1 == null) return t2;
    if(t2 == null) return t1;
    BinarySearchTree.Node root = new BinarySearchTree.Node(t1.key + t2.key,t1.value+t1.value,1);
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);
    return root;

}

}
