package algorithm4thedition;

import java.util.Arrays;

public class Merge{
	static int[] temp;
	public static void main(String[] args) {
		int[] a = { 4, 3, 6, 1, 2, 7, 9, 8, 5 };
		sort(a);
		System.out.println(Arrays.toString(a));

	}

	public static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void sort(int[] a) {
	  temp=new int[a.length];
	  sort(a,0,a.length-1);
	}
	public static void sort(int[] a,int lo,int hi){
	  if(lo>=hi)
		  return;
	  int mid=lo+(hi-lo)/2;
	  sort(a,lo,mid);
	  sort(a,mid+1,hi);
	  merge(a,lo,mid,hi);
		
	}
	
	public static void merge(int[] a,int lo,int mid,int hi){
	   for(int i=lo;i<=hi;i++)
		   temp[i]=a[i];
	   int j=lo;
	   int k=mid+1;
	   for(int i=lo;i<=hi;i++){
		   if(j>mid)
			   a[i]=temp[k++];
		   else if(k>hi)
			   a[i]=temp[j++];
		   else if(temp[j]>temp[k])
			   a[i]=temp[k++];
		   else 
			   a[i]=temp[j++];
			   
	   }
		
	}

}
