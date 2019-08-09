package cc150;

import java.util.*;

public class A9_5 {

	public static void main(String[] args) {
	    int[] a={1,0,0,0,2,3,0,0,4,5,0,0,6,7,0,8,0,0,0,9};
	    System.out.println(find(9,a));
		
		
	}
	public static int find(int key,int[] a ){
		int lo=0;
		int hi=a.length-1;
		while(lo<=hi){
		    int mid=lo+(hi-lo)/2;
		    int t=mid;
		    while(a[t]!=0&&t<hi)
		    	t++;
		    if(key>a[t])
		    	lo=t+1;
		    else if(key<a[t])
		    	hi=mid-1;
		    else
		    	return mid;
		    
		}
		return -1;
	}

}
