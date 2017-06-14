package exceptionTest;

public class ErrorCompetitions {
	
	public static void main(String args[]){
		f(new Object());
	}
	
	public static void f(Object o){
		f(new Object[]{o, new Object()});
	}
}
