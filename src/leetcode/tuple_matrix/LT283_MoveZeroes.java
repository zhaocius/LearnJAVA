package leetcode.tuple_matrix;

import java.util.Arrays;

public class LT283_MoveZeroes {

    /*
    *
    * For example, given nums = [0, 1, 0, 3, 12],
    * after calling your function,
    * nums should be [1, 3, 12, 0, 0].
    *
    * */
    public static void moveZeroes(int[] a){
        int noZeroesNum = 0;
        int[] tmp=new int[a.length];
        for(int i =0;i<a.length;i++){
            if(a[i]!=0){
                tmp[noZeroesNum++]=a[i];
            }
        }
        System.out.println(Arrays.toString(tmp));
    }
    public static void main(String[] args){
       int[] a = new int[]{0, 1, 0, 3, 12};
       moveZeroes(a);
    }
}
