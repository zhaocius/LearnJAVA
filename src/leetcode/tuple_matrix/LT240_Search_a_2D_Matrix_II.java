package leetcode.tuple_matrix;

public class LT240_Search_a_2D_Matrix_II {
    public static boolean search(int[][] a,int target){
        int row = a.length;
        int column = a[0].length;
        int m = 0;
        int n = column-1;
        while(m<row&&n>=0){
            if(a[m][n]==target)
                return true;
            else if(a[m][n]<target)
                m++;
            else
                n--;
        }
        return false;
    }
    public static void main(String[] args){
        int[][] metrix = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        System.out.println(search(metrix,11));
    }
}
