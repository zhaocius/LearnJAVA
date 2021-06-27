package algorithm4thedition;

import java.util.Arrays;
//排序 + 二分查找

public class AllKindsOfSort {
    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9, 4, 5, 6, 53, 23, 654, 34, 29, 43, 76, 345};
        sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(find(a,7));

    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    exchange(a, j, j + 1);
                }
            }
        }
    }

    public static void sort1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            exchange(a, i, min);
        }
    }

    public static void sort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--)
                exchange(a, j, j - 1);
        }
    }


    public static int find(int[] a ,int num){
        int low = 0;
        int high = a.length-1;
        while(low<= high){
            int mid = low+(high-low)/2;
            if(a[mid]==num) {
                return mid;
            }
            else if(a[mid]>num){
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

}
