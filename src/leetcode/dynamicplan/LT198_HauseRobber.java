package leetcode.dynamicplan;

/*
* 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
* 由于不能抢劫邻近住户，因此如果抢劫了第 i 个住户那么只能抢劫 i - 2 和 i - 3 的住户，所以
* dp[i] = max(dp[i-2],dp[i-3]+a[i])  //最大是倒数第二的dp 和 倒数第3的dp+当前的大值。
*
* */
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
