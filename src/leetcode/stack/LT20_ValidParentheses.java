package leetcode.stack;

import java.util.Stack;
import java.lang.Character;

public class LT20_ValidParentheses {

    /*
    * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
    *
    *
    * */

    public static boolean isValid(String str){
        if(null == str)
            return false;
        if(str.length()%2 != 0)
            return false;
        if(str.charAt(0) == '}'
                || str.charAt(0) == ']'
                || str.charAt(0) == ')')
            return false;

        Stack<Character> stack = new Stack();
        for(int i = 0 ;i< str.length();i++){
            if(str.charAt(i) == '{'
            || str.charAt(i) == '['
            || str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }else{
                char c = stack.pop();
                if(str.charAt(i) =='}' && c!='{'
                ||str.charAt(i) ==']' && c!='['
                ||str.charAt(i) ==')' && c!='('){
                    return false;
                }

            }
        }

        return true;

    }
    public static void main(String[] args) {
        System.out.println(LT20_ValidParentheses.isValid("{}[]{}[]()"));
        System.out.println(LT20_ValidParentheses.isValid("{([{}])}"));
        System.out.println(LT20_ValidParentheses.isValid("{}[]{}(]{}{}"));
        System.out.println(LT20_ValidParentheses.isValid("{([{}]}}"));
    }
}
