package leetcode;
import java.util.Arrays;

/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

*/

public class LT1_TwoSum {

    public static int[] twoSum(int[] arr,int target){
        int[] hash = new int[Integer.MAX_VALUE>>5];
        for(int i = 0;i<arr.length;i++){
            hash[arr[i]]=i;
        }
        for(int i =0;i<arr.length;i++){
            if(hash[target-arr[i]]!=0){
                return new int[]{hash[arr[i]],hash[target-arr[i]]};
            }
        }
        return null;
    }
   
    public static void main(String[] args){
        int arr[] = {3,33,5,24,7,100,10000,1222436,34262,15,416,45,27,3578,358,436};
        int target = 51;
        System.out.println(Arrays.toString(LT1_TwoSum.twoSum(arr,target)));

    }
}
