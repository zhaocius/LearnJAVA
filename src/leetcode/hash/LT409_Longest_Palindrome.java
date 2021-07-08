package leetcode.hash;

public class LT409_Longest_Palindrome {

    /*
     * 计算一组字符集合可以组成的回文字符串的最大长度
     * Input : "abccccdd"
     * Output : 7
     * Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
     * */
    public static int longestPalindrome(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int lengh = 0;
        boolean hasSingle = false;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] % 2 != 0) {
                hasSingle = true; //如果有单数，则可以放在中间。
            }
            lengh += (hash[i] / 2 * 2);
        }
        lengh += (hasSingle ? 1 : 0);
        return lengh;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
