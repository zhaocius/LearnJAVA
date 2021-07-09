package leetcode.dynamicplan;

/*
*
* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
*
* */
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

	public static int get1(int stairs){
		if(stairs == 1)
			return 1;
		if(stairs == 2)
			return 2;
		return get1(stairs-1)+get1(stairs-2);

	}

}
