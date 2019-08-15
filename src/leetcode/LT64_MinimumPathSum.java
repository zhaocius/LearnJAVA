package leetcode;

public class LT64_MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
    	System.out.print(getMinimumPathSum(grid));
	}
	
	public static int getMinimumPathSum(int[][] grid){
		int x=grid.length;
		int y=grid[0].length;
		int dp[][] =new int[x][y];
		
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(i==0&&j!=0){
					dp[i][j]=dp[i][j-1]+grid[i][j];
				}else if(j==0&&i!=0){
					dp[i][j]=dp[i-1][j]+grid[i][j];
				}else if(j==0&&i==0){
					dp[0][0]=grid[0][0];
				}else{
					dp[i][j]=Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
				}
			}
		}
		return dp[x-1][y-1];
	}

}
