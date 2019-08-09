package learnjava;
public class ParentTest {
	public  int test(){
		return num(1,2);
	}
	
	public static int num(int i,int j){
		return i+j;
	}
	
	public static void main(String[] args) {
		ParentTest p = new Child();
		System.out.println(p.test());
	}
}
class Child extends ParentTest{
	
	public static int num(int x,int y){
		return x-y;
	}
}

