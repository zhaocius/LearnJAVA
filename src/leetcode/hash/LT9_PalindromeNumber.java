package leetcode.hash;

public class LT9_PalindromeNumber {

    /*
     * 判断一个整数是否是回文数
     * */
    public static boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0) return false;
        if(x % 10 == 0) return false;
        int tmp = 0; // 反向重新构建一个数字，
        while(x > tmp){
            tmp = tmp * 10 + x % 10;
            x /= 10;
        }
        return x == tmp || x == tmp / 10;
    }

    public static void main(String[] args) {

        int a = 12321;
        System.out.println(isPalindrome(a));
    }
}
