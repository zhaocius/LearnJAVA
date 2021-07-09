package leetcode.greedy;


import java.util.Arrays;

/*
*
*
* 题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直射向坐标轴，使得路径上的气球都会刺破。求解最小的投飞镖次数使所有气球都被刺破。
从左往右投飞镖，并且在每次投飞镖时满足以下条件：
1. 左边已经没有气球了；
2. 本次投飞镖能够刺破最多的气球。
*
*
* Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

* */
public class LT452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->(a[1]-b[1]));
        int currentPos = points[0][1];
        int arrows = 1;
        for(int i = 1;i<points.length;i++){
            if(points[i][0]<=currentPos)
                continue;
            arrows++;
            currentPos=points[i][1];
        }
        return arrows;
    }

    public static void main(String[] args){
        int[][]points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
    }
}
