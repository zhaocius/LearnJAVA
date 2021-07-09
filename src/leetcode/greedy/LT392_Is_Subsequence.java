package leetcode.greedy;

/*
*
* s = "abc", t = "ahbgdc"
Return true.
*
* */
public class LT392_Is_Subsequence {
    public static boolean isSubsequence(String s, String t ){
        int index = 0;
        for(int pos = 0;index<s.length()&&pos<t.length();){
            if(t.charAt(pos)==s.charAt(index))
                index++;
            pos++;
        }
        return index==s.length();
    }

    public static void main(String[] args){
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));

        s = "abf";
        System.out.println(isSubsequence(s,t));
    }
}
