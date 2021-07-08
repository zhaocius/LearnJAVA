package leetcode.hash;

import java.util.Arrays;

public class LT594_Longest_Harmonious_Subsequence {

    public static int longestHarmoniousSubsequence(int[] arr){ //可以用map模拟，节省内存
        int[] hash = new int[Integer.MAX_VALUE>>5];
        for(int i = 0 ;i<arr.length;i++){
            hash[arr[i]]++;
        }
        int max = 0;
        for(int i = 1 ;i<hash.length;i++){
            if(hash[i-1]+hash[i]>max)
                max=hash[i-1]+hash[i];
        }
        return max;
    }
    public static void main(String[] args){
        int arr[] = {1,3,2,2,5,2,3,7};
        System.out.println(longestHarmoniousSubsequence(arr));
    }

}
