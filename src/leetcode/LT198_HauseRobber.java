package leetcode;

public class LT198_HauseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,3,2,4,6,5,7};
		System.out.println(get(nums));
	}
	
	public static int get(int[] nums){
		int num=nums.length;
		int[] dp=new int[num];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		for(int i=2;i<num;i++){
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return dp[num-1];
	}
	
}
