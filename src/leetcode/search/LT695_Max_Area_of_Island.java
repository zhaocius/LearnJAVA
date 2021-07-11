package leetcode.search;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/*
*
* 从一个节点出发，使用 DFS 对一个图进行遍历时，能够遍历到的节点都是从初始节点可达的，DFS 常用来求解这种 可达性 问题。
在程序实现 DFS 时需要考虑以下问题：
* 栈：用栈来保存当前节点信息，当遍历新节点返回时能够继续遍历当前节点。也可以使用递归栈。
* 标记：和 BFS 一样同样需要对已经遍历过得节点进行标记。
*
* */
public class LT695_Max_Area_of_Island {
    private static int dfs(int[][] grad,int i ,int j){
        int w = grad[0].length;
        int h = grad.length;
        if(i<0||j<0||i>=h||j>=w)
            return 0;
        if(grad[i][j]==0)
            return 0;
        grad[i][j]=0;
        return dfs(grad,i+1,j)+dfs(grad,i-1,j)+dfs(grad,i,j+1)+dfs(grad,i,j-1)+1;
    }

    private static int bfs(int[][] grad,int i ,int j){
        int w = grad[0].length;
        int h = grad.length;
        int num = 0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(i,j));
        grad[i][j]=0;
        while(queue.size()!=0){
            int size = queue.size();
            for(int k = 0;k<size;k++){
                Pair<Integer,Integer> item = queue.poll();
                int m = item.getKey(),n = item.getValue();
                num++;
                if(m-1>=0&&m-1<grad.length&&n>=0&&n<grad.length&&grad[m-1][n]>0) {
                    queue.add(new Pair<>(m - 1, n));
                    grad[m-1][n]=0;
                }
                if(m+1>=0&&m+1<grad.length&&n>=0&&n<grad.length&&grad[m+1][n]>0) {
                    queue.add(new Pair<>(m + 1, n));
                    grad[m+1][n]=0;

                }
                if(m>=0&&m<grad.length&&n-1>=0&&n-1<grad.length&&grad[m][n-1]>0) {
                    queue.add(new Pair<>(m, n - 1));
                    grad[m][n-1]=0;

                }
                if(m>=0&&m<grad.length&&n+1>=0&&n+1<grad.length&&grad[m][n+1]>0) {
                    queue.add(new Pair<>(m, n + 1));
                    grad[m][n+1]=0;

                }
            }
        }
        return num;
    }

    public static int getMaxArea(int[][] grad){
        int max = 0;
        for(int i =0 ;i<grad.length;i++)
            for(int j = 0;j<grad[0].length;j++)
                if(grad[i][j]>0)
                    max = Math.max(max,bfs(grad,i,j));
        return max;
    }


    public static void main(String[] args){
        int[][]grad = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        System.out.println(getMaxArea(grad));
    }
}
