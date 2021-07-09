package leetcode.doublepointer;

/*
* Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
题目描述：判断一个数是否为两个数的平方和，例如 5 = 12 + 22。
*
* */
public class LT633_Sum_of_Square_Numbers {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while(left <= right){
            int powSum = left * left + right * right;
            if(powSum == c) return true;
            else if(powSum > c) right--;
            else left++;
        }
        return false;
    }

}
