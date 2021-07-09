package leetcode.dynamicplan;

public class LT474_OnesAndZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = { "10", "0001", "111001", "1", "0" };
		System.out.print(getMax(array, 3, 5));

	}

	public static int getMax(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < strs.length; i++) {
			int ones = 0;
			int zeroes = 0;
			for (int j = 0; j < strs[i].length(); j++) {
				if (strs[i].charAt(j) == '1') {
					ones++;
				} else {
					zeroes++;
				}
			}
			// 复用了数组降维度，想象一下 每次循环 dp[j][k] 会被 dp[j-zeros][k-ones]
			// 的数据改变，此时dp[j-zeros][k-ones]应该是上次最外层循环遗留下来的。如果从小到大的话，dp[j][k] 被
			// dp[j-zeros][k-ones] 改变，但是 dp[j+zeros][k+ones] 要被
			// dp[j][k]改变，此时dp[j][k]应该也要是上次循环遗留下来的，不应该被当前循环先改变。只有从 大到小，可以避免此问题。
			for (int k = m; k >= ones; k--) {
				for (int l = n; l >= zeroes; l--) {
					dp[k][l] = Math.max(dp[k][l], dp[k - ones][l - zeroes] + 1);
				}
			}
		}

		return dp[m][n];

	}

}
