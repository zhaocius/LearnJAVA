package leetcode.greedy;

/*

Input: flowerbed = [1,0,0,0,1], n = 1
Output: True

* */
public class LT605_Can_Place_Flowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1) continue;
            int pre = (i == 0 ? 0 : flowerbed[i - 1]);//边界条件
            int next = (i == flowerbed.length - 1 ? 0 : flowerbed[i + 1]);//边界条件
            if(pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
    public static void main(String[] args){
        int[] a = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(a,1));
        System.out.println(canPlaceFlowers(a,2));

    }
}
