package leetcode.search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LT547_Friend_Circles {
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

    public static int getCircleNum(int[][] grad){
        int num = 0;
        for(int i =0 ;i<grad.length;i++)
            for(int j = 0;j<grad[0].length;j++)
                if(grad[i][j]>0){
                    int result = dfs(grad,i,j);
                    num++;
                }
        return num;
    }
    public static void main(String[] args){
        int[][]grad = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        System.out.println(getCircleNum(grad));
    }
}
