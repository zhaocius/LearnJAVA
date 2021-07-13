package leetcode.tree;
import algorithm4thedition.BinarySearchTree;
public class LT101_Symmetric_Tree{
/*
    1
   / \
  2   2
/ \ / \
3  4 4  3

*/

public boolean isSymmetric(BinarySearchTree.Node root) {
    if(root == null) return true;
    return isSymmetric(root.left, root.right);
}

private boolean isSymmetric(BinarySearchTree.Node t1, BinarySearchTree.Node t2){
    if(t1 == null && t2 == null) return true;
    if(t1 == null || t2 == null) return false;
    if(t1.value != t2.value) return false;
    return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
}

}