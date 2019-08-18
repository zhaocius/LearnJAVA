package leetcode;

import java.util.Arrays;
import java.util.List;
/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

*/

public class LT139_WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "leetcode";
		String[] strs = { "leet", "code" };
		List<String> wordDict = Arrays.asList(strs);
		System.out.println(getWordBreak(str, wordDict));

	}

	/*
	 * dp[i]表示s到i位置是否可以由wordDict组成
	 * 
	 * 所以有 如果dp[i - j]是true并且s[j:i]在wordDict里, 那么dp[i] = true;
	 * 
	 */
	public static boolean getWordBreak(String str, List<String> dict) {
		int length = str.length();
		boolean[] dp = new boolean[length + 1];
		dp[0] = true;
		for (int i = 1; i < length + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(str.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[length];
	}

}
