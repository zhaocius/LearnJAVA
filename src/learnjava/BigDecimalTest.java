package learnjava;

import java.math.BigDecimal;
import java.math.BigInteger;


public class BigDecimalTest {
    public static void main(String[] args){

    	float f1=0.01f;
    	float f2=0.05f;
    	System.out.println(f1+f2);
    	
    	BigDecimal bd=new BigDecimal(0.01);
    	BigDecimal bd1=new BigDecimal(0.1);
    	float a=bd.add(bd1).floatValue();
    	System.out.println(a);
    	
    	float b=bd.subtract(bd1).floatValue();
    	System.out.println(b);   
    	
    	float c=bd.multiply(bd1).floatValue();
    	System.out.println(c);
    	
    	BigInteger e=BigInteger.valueOf(Integer.MAX_VALUE);
    	BigInteger f=BigInteger.valueOf(Integer.MAX_VALUE);
    	System.out.println(e.add(f).longValue());
    	
    	
    }
}
