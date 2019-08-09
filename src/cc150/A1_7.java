package cc150;

import java.util.Arrays;

public class A1_7 {
	public static void call(int[][] a){
		boolean[] row=new boolean[a.length];
		boolean[] column=new boolean[a[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(a[i][j]==0){
					row[i]=true;
					column[j]=true;				
				}
			} 
		}
		for(int i=0;i<a.length;i++)
            if(row[i]==true)
            	for(int j=0;j<a[0].length;j++)
            		a[i][j]=0;
            
		
		for(int i=0;i<a[0].length;i++)
            if(column[i]==true)
            	for(int j=0;j<a.length;j++)
            		a[j][i]=0;
            
		
		System.out.print(Arrays.deepToString(a));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] a=new int[4][4];
        int count=1;
        for(int i=0;i<4;i++)
        	for(int j=0;j<4;j++)
        		a[i][j]=count++;
        a[0][1]=0;
        
        call(a);
      
  
	}

}
