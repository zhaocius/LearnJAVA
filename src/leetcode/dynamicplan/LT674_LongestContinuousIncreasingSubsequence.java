package leetcode.dynamicplan;

import java.util.Arrays;

/*
* 动态规划，dp[i]表示位置i的连续递增子序列长度，初始化为1，因为每个数字是最小的递增子序列。
* 状态转移方程：若nums[i-1]<nums[i]，则dp[i]=dp[i-1]+1；否则dp[i]=1。
* */
public class LT674_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums=new int[]{1,3,5,4,8};
        System.out.println(findMax(nums));

    }

    public static int findMax(int[] nums){
        int length=nums.length;
        int[] dp=new int[length];
        Arrays.fill(dp, 1);
        for(int i=1;i<length;i++){
            if(nums[i]>nums[i-1])
                dp[i]=dp[i-1]+1;
        }
        int max=dp[0];
        for(int i=1;i<length;i++){
            max=Math.max(max, dp[i]);
        }
        return max;
    }
}
