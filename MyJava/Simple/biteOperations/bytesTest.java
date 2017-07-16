package biteOperations;

public class bytesTest {

	private static String field = "Hello!";
	private static String field2 = new String("Hello!");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 6;
		int b = 10;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(a & b) +"-"+(a&b));
		System.out.println(field == field2);
	}

}
