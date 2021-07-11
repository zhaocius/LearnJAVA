package leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class LT257_BinaryTreePaths {
    public static List<String> binaryTreePaths(Node root) {
        List<String> ret = new ArrayList();
        if(root == null) return ret;
        dfs(root, "", ret);
        return ret;
    }

    public static void dfs(Node root,String text ,List<String> ret){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            ret.add(text+root.item);
            return;
        }
        text+=root.item;
        dfs(root.left,text,ret);
        dfs(root.right,text,ret);

    }
}
