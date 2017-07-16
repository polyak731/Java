package overriding.test1;

public class x1 {

	public static void main(String args[]){
		f(1);
	}
	
	public static void f(int arg){
		System.out.print("int");
	}
	
	public static void f(long arg){
		System.out.print("int");
	}
}
