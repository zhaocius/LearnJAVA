package leetcode.doublepointer;

import java.util.Arrays;
import java.util.HashSet;


/*
*
* Given s = "leetcode", return "leotcede".
使用双指针，指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
*
* */
public class LT345_Reverse_Vowels_of_a_String {

    private HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public void reverseVowels(String s) {
        int i = 0,j= s.length()-1;
        while(i<j){
            if(!vowels.contains(s.charAt(i))){
                i++;
            }else if(!vowels.contains(s.charAt(j))){
                j--;
            }else{
                //change 使用引用，或者之前构造一个tmp string
                i++;
                j--;
            }
        }

    }
}
