package leetcode.hash;

import java.util.Arrays;

public class LT205_IsomorphicStrings {

    /*
     * Given "egg", "add", return true.
     * Given "foo", "bar", return false.
     * Given "paper", "title", return true.
     * */
    public static boolean isomorphicStrings(String s, String t) {
        int[] letters1 = new int[26];
        int[] letters2 = new int[26];
        for(int i =0;i<s.length();i++) {
            //在遍历的时候就判断，保证过程一样。而不是构建完hash再判断。
            if(letters1[s.charAt(i)-'a']!=letters2[t.charAt(i)-'a'])
                return false;
            letters1[s.charAt(i) - 'a']++;
            letters2[t.charAt(i) - 'a']++;

        }
        return true;

    }

    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(isomorphicStrings(s,t));
        s = "foo";
        t = "bar";
        System.out.println(isomorphicStrings(s,t));
    }
}
