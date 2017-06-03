package outOfMemoryTest;

//java heap space
public class Test2 {
	public static void main(String args[]){
		try{
			long []array = new long[Integer.MAX_VALUE/2];
		}catch(OutOfMemoryError error){
			System.out.print(error);
		}
	}
}
