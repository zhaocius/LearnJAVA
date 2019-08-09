package leetcode;

public class LT70_ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(get(3));
	}

	public static int get(int stairs){
		int[] dp=new int[stairs];
		dp[0]=1;
		dp[1]=2;
		for(int i=2;i<stairs;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[stairs-1];
		
	}

}
