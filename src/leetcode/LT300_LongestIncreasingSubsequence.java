package leetcode;

import java.util.Arrays;

public class LT300_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{10,9,2,5,3,7,101,8};
		System.out.println(findMax(nums));

	}
	
	public static int findMax(int[] nums){
		int length=nums.length;
		int[] dp=new int[length];
		Arrays.fill(dp, 1);
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++){
				if(nums[i]>nums[j]){
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max=dp[0];
		for(int i=1;i<length;i++){
			max=Math.max(max, dp[i]);
		}
		return max;
		
		
	}


}
