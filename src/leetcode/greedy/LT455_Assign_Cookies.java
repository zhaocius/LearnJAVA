package leetcode.greedy;

import java.util.Arrays;

/*
* 输入: g = [1,2], s = [1,2,3]
输出: 2
解释:
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.
*
* */
public class LT455_Assign_Cookies {
    public static int assignCookies(int[] babies,int[] cookies ){
        Arrays.sort(babies);
        Arrays.sort(cookies);
        int i = 0;
        for(int pos = 0 ;i<babies.length&&pos<cookies.length;){
            if(cookies[pos]>=babies[i])
                i++;
            pos++;
        }
        return i;
    }

    public static void main(String[] args){
        int[] g = {1,2}, s = {1,2,3};
        System.out.println(assignCookies(g,s));
    }

}
