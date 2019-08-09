package algorithm4thedition;

import java.util.Arrays;

public class Partation {
    public static int[] a={1,546,86,4235,75376,3245426,684,52345,7453,354,8746,5234,84};	
	public static void exch(int[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
    public static void rank(int[] a){
    	rank(a,0,a.length-1);
    }
    public static void rank(int[] a,int lo,int hi){
    	if(lo>=hi)
    		return;
    	int part=partation(a,lo,hi);
    	rank(a,lo,part-1);
    	rank(a,part+1,hi);
    }
    public static int partation(int[]a,int lo,int hi){
    	int k=a[lo];
    	int i=lo;
    	int j=hi+1;
    	while(true){
    		while(k>a[++i])
    			if(i==hi)
    				break;
    		while(k<a[--j])
    			if(j==lo)
    				break;
    		if(i>=j)
    			break;
    		exch(a,i,j);
    	}
    	exch(a,lo,j);
    	
    	return j;
    }
	public static void main(String[] args){
	    rank(a);
	    System.out.println(Arrays.toString(a));
		
	}
}
