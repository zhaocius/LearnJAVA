package leetcode.doublepointer;

/*
*
* Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
题目描述：字符串可以删除一个字符，判断是否能构成回文字符串。
*
*
* */
public class LT680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() -1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j); //找一个不同点，试两个新串。
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }


}
