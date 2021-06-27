import com.sun.jdi.ByteValue;

import java.util.Arrays;

class Base{
    public static String BASE = "BASE";
    public static final String FINAL_BASE = "FINAL_BASE";
    static {
        System.out.println("base");
    }
}

class Impl extends Base{
    static {
        System.out.println("impl");
    }
}
public class Test {
    public static void main(String[] args){
        System.out.println(Impl.FINAL_BASE);
    }
}
