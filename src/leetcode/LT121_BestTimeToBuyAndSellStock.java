package leetcode;

public class LT121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 5, 11, 5 };
		System.out.print(getMax(nums));
	}
	
	//动态规划解法 最大利润=max{前一天最大利润, 今天的价格 - 之前最低价格}
	private static int getMax(int[] nums){
		int length=nums.length;
		int[]dp=new int[length];
		int lowest=nums[0];
		for(int i=1;i<length;i++){
		    dp[i]=Math.max(nums[i]-lowest, dp[i-1]);
		    if(nums[i]<lowest){
		    	lowest=nums[i];
		    }
		}
		int max=dp[0];
		for(int i=1;i<length;i++){
			max=Math.max(max, dp[i]);
		}
		return max;
	}

}
