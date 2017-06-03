package outOfMemoryTest;

//VM array limit
public class Test1 {
	public static void main(String args[]){
		long []l = new long[Integer.MAX_VALUE-1];
	}
}
