package recursion;

public class Test1 {

	public static void main(String[] args) {
		f(1);
	}

	private static void f(int i) {
		// TODO Auto-generated method stub
		if(i<15) f(2*i);
		System.out.println(i);
	}
}
