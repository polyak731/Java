package outOfMemoryTest;


public class Test4 {

	public static void main(String args[]){
		
		Object arr[] = new Object[1];
		while(true){
			arr = new Object[]{arr};
		}
	}
}
