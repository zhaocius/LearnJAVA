package leetcode;

import java.util.Arrays;

public class LT646_MaximumLengthOfPairChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums={{10,11},{9,10},{2,3},{5,6},{3,4},{7,8},{101,102}};
		System.out.println(getMax(nums));
	}
	
	public static int getMax(int[][] nums){
		int length=nums.length;
		int[]dp =new int[length];
		//初始化每个都是1，
		Arrays.fill(dp, 1);
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++){
				if(nums[i][0]>nums[j][1]){
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
