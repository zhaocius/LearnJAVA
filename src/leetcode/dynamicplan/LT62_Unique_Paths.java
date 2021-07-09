package leetcode.dynamicplan;

// 题目描述：统计从矩阵左上角到右下角的路径总数，每次只能向左和向下移动。

public class LT62_Unique_Paths {
    public static int uniquePaths(int[][] grid){
        int x=grid.length;
        int y=grid[0].length;
        int dp[][] =new int[x][y];

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(i==0&&j!=0){          //沿着上边缘往前走
                    dp[i][j]=1;
                }else if(j==0&&i!=0){    //沿着左边缘往下走
                    dp[i][j]=1;
                }else if(j==0&&i==0){    //起点
                    dp[0][0]=1;
                }else{                   //中间点，取从上来和从左来之间的走法之和。
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[x-1][y-1];
    }
}
