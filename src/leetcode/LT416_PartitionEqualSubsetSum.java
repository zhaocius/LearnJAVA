package leetcode;

import java.util.Arrays;

public class LT416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 5, 11, 5 };
		System.out.print(canPartition1(array));
	}

	// 标准解法
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
