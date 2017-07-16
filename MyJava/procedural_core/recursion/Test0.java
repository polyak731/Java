package recursion;

public class Test0 {

	public static void main(String[] args) {
		f(1);
	}

	private static void f(int i) {
		// TODO Auto-generated method stub
		System.out.println(i);
		if(i<15){
			f(2*i);
		}
	}
	
	
}
