package overriding.test1;

public class x3 {

	public static void main(String[] args) {
		int i = Short.MAX_VALUE + 10;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString((short)i));
	}
}
