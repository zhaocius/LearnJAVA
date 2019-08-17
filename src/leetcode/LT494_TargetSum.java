package leetcode;
/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
*/

public class LT494_TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,2,3,4,5};
		System.out.println(getMax1(nums,3));
	}
//	思想：在某个解中正数和为x，负数和的绝对值为y，则x+y=sum，x-y=S，解得x=(sum+S)/2
//	所以就有在nums中选择一部分数（装与不装到背包中），让其和为x（总的容量为x），此时转化为了0-1背包问题,

//	此时dp数组中保存能凑到和为j的数量
	public static int getMax(int[] nums,int target){
		int length=nums.length;
		int sum=0;
		for(int i=0;i<length;i++){
			sum+=nums[i];
		}
		int T=(target+sum)/2;
		
		int[]dp=new int[T+1];
		dp[0]=1;
		for(int i=0;i<length;i++){
			for(int j=T;j>=nums[i];j--){
				dp[j]=dp[j]+dp[j-nums[i]];
			}
		}
		return dp[T];
	}
	
	
	//当然也可以使用二维数组：前i个数能凑到和为j的数量
	//dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
	public static int getMax1(int[] nums,int target){
		int length=nums.length;
		int sum=0;
		for(int i=0;i<length;i++){
			sum+=nums[i];
		}
		int T=(target+sum)/2;
		
		int[][]dp=new int[length][T+1];
		//每次往前都一个数组中数字，都不取，和都为0，所有dp[i][0]=1,有一种方案。
		for(int i=0;i<length;i++){
			dp[i][0]=1;
		}
		//取第一个数字，在对应的地方设置为1，作为初始值
		for(int i=0;i<T+1;i++){
			if(nums[0]==i){
				dp[0][i]=1;
			}
		}
		
		for(int i=1;i<length;i++){
			for(int j=0;j<nums[i];j++){
				dp[i][j]=dp[i-1][j];
			}
			for(int j=nums[i];j<T+1;j++){
				dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];
			}
		}
		return dp[length-1][T];
	}
}
