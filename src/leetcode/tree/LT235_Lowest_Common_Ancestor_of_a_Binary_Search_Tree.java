public class LT235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree{
/*    
这一题的重点在于利用BST的二分性质:对两个节点进行二分判断
节点均小于root,那么递归到root的左子树
节点均大于root,那么递归到root的右子树
位于root左右,那么显然root就是最近公共祖先
*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
    if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
    return root;
}


}