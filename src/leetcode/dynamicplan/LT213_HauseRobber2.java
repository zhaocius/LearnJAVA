package leetcode.dynamicplan;

public class LT213_HauseRobber2 {


	//其实就是把环拆成两个队列，一个是从0到n-1，另一个是从1到n，然后返回两个结果最大的。
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,2,3,4,5,6,7};
		System.out.println(get(nums));
	}
	
	public static int get(int[] nums){
		int num=nums.length;
		int[] dp=new int[num-1];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		for(int i=2;i<num-1;i++){
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		
		int[] dp1=new int[num-1];
		dp[0]=nums[1];
		dp[1]=Math.max(nums[1], nums[2]);
		for(int i=2;i<num-1;i++){
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i+1]);
		}
		
		return dp[num-2]>dp1[num-2]?dp[num-2]:dp1[num-2];
	}

}
