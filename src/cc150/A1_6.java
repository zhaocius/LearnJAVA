package cc150;

import java.util.Arrays;

public class A1_6 {
	public static void call(int[][] a){
		for(int i=0;i<4;i++){
			for(int j=0;j<i;j++){
				int temp=a[i][j];
				a[i][j]=a[j][i];
			    a[j][i]=temp;
			} 
		}
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				int temp=a[i][j];
				a[i][j]=a[3-i][j];
				a[3-i][j]=temp;
			}
		}
		System.out.print(Arrays.deepToString(a));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] a=new int[4][4];
        int count=1;
        for(int i=0;i<4;i++)
        	for(int j=0;j<4;j++)
        		a[i][j]=count++;
        
        call(a);
      
  
	}

}
