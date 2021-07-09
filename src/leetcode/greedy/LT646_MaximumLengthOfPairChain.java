package leetcode.greedy;

import java.util.Arrays;

public class LT646_MaximumLengthOfPairChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums={{10,11},{9,10},{2,3},{5,6},{3,4},{7,8},{101,102}};
		System.out.println(findLongestChain(nums));
	}

	//和放箭题一样，先排序。
	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs,(a,b)-> a[1]-b[1]);
		int res = 1,tmp = pairs[0][1];
		for(int i = 1;i < pairs.length;i++){
			if(pairs[i][0] > tmp){
				res++;
				tmp = pairs[i][1];
			}
		}
		return res;
	}

}
