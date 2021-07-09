package leetcode;

import java.util.Arrays;

/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
*/
public class LT416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 5, 11, 5 };
		System.out.print(canPartition1(array));
	}

	// 标准解法
	/*
	 * 0-1
	 * 背包问题也是最基础的背包问题，它的特点是：待挑选的物品有且仅有一个，可以选择也可以不选择。下面我们定义状态，不妨就用问题的问法定义状态试试看。
	 * 
	 * dp[i][j]：表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和等于 j。
	 * 
	 * 根据我们学习的 0-1 背包问题的状态转移推导过程，新来一个数，例如是 nums[i]，根据这个数可能选择也可能不被选择：
	 * 
	 * 如果不选择 nums[i]，在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
	 * 如果选择 nums[i]，在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]
	 * ，我既然这样写出来了，你就应该知道，这里讨论的前提条件是 nums[i] <= j。 以上二者成立一条都行。于是得到状态转移方程是：
	 * 
	 * dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]], (nums[i] <= j) 于是按照
	 * 0-1 背包问题的模板，我们不难写出以下代码。
	 */
	public static boolean canPartition(int[] nums) {
		int sum = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		boolean[][] dp = new boolean[length][sum / 2 + 1];
		for (int i = 0; i < length; i++) {
			dp[i][0] = true;
			break;
		}

		for (int i = 0; i < sum / 2 + 1; i++) {
			if (i == nums[0]) {
				dp[0][i] = true;
				break;
			}
		}

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < sum / 2 + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= nums[i]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
				}
			}
		}

		for (int i = 0; i < length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[length - 1][sum / 2];
	}

	// 减少空间复杂度，变成一维数组
	public static boolean canPartition1(int[] nums) {
		int sum = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		boolean[] dp = new boolean[sum / 2 + 1];
		dp[0] = true;

		for (int i = 0; i < sum / 2 + 1; i++) {
			if (i == nums[0]) {
				dp[i] = true;
				break;
			}
		}

		for (int i = 1; i < length; i++) {
			for (int j = sum / 2; j >= 0 && j >= nums[i]; j--) {
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[sum / 2];
	}

}
