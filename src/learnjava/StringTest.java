package learnjava;

import java.io.UnsupportedEncodingException;

public class StringTest {
    public static void main(String[] args) {
        String a = "我日";
        byte[] b = a.getBytes();
        System.out.println(b.length);
        for (byte c : b)
            System.out.println(c);
        String d;
        try {
            d = new String(b, "GBK");
            System.out.println(d);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
