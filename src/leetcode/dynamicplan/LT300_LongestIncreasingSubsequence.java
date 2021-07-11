package leetcode.dynamicplan;

import java.util.Arrays;
/*
*
* 第 1 步：状态定义。dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度。即：在 [0, ..., i] 的范围内，选择以数字 nums[i] 结尾可以获得的最长上升子序列的长度。

说明：以 nums[i] 结尾，是子序列动态规划问题的经典设计状态思路，思想是动态规划的无后效性（定义得越具体，状态转移方程越好推导）。

第 2 步：推导状态转移方程：遍历到 nums[i] 的时候，我们应该把下标区间 [0, ... ,i - 1] 的 dp 值都看一遍，如果当前的数 nums[i] 大于之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。把前面的数都看了， dp[i] 就是它们的最大值加1。即比当前数要小的那些里头，找最大的，然后加1。

状态转移方程即：dp[i] = max(1 + dp[j] if j < i and nums[j] < nums[i])。

第 3 步：初始化。单独一个数是子序列，初始化的值为 1；

第 4 步：输出。应该扫描这个 dp 数组，其中最大值的就是题目要求的最长上升子序列的长度。
*
* */

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
		// 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
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
