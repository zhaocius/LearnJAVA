package cc150;

import java.util.*;

public class A9_7 {
	private static class Person{
		 public int weight;
		 public int height;
		 public Person(int weight,int height){
			 this.weight=weight;
			 this.height=height;
		 }
	}

	public static void main(String[] args) {
	   Person[] p=new Person[10];
	   p[0]=new Person(165,100);
	   p[1]=new Person(270,102);
	   p[2]=new Person(356,10);
	   p[3]=new Person(475,170);
	   p[4]=new Person(560,880);
	   p[5]=new Person(668,150);
	   p[6]=new Person(776,10);
	   p[7]=new Person(843,110);
	   p[8]=new Person(921,120);
	   p[9]=new Person(1078,130);
	   
	   
	    System.out.println(find(p));
		
		
	}
	public static int find(Person[] p ){
		int k=1;
		for(int i=0;i<p.length;i++){
			int key=1;
			for(int j=i;j<p.length-1&&p[j+1].height>p[j].height;j++)
				key++;		
			if(key>k)
				k=key;
		}
		return k;
		
	}

}
