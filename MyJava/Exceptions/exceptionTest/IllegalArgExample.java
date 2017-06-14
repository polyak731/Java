package exceptionTest;

public class IllegalArgExample {
	
	public static void main(String args[]){
		double d = Math.sqrt(-2231);
		System.out.println(d);
		foo(1,0);
	}
	
	public static double foo(int a, int b){
		if(b==0){
			throw new IllegalArgumentException();
		}
		return a/b;
	}
}
