package leetcode.search;

import algorithm4thedition.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class LT257_BinaryTreePaths {
    public static List<String> binaryTreePaths(BinarySearchTree.Node root) {
        List<String> ret = new ArrayList();
        if(root == null) return ret;
        dfs(root, "", ret);
        return ret;
    }

    public static void dfs(BinarySearchTree.Node root,String text ,List<String> ret){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            ret.add(text+root.value);
            return;
        }
        text+=root.value;
        dfs(root.left,text,ret);
        dfs(root.right,text,ret);

    }
}
