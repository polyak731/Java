package LangTests;

public class FloatTest {

	public static void main(String[] args) {
		float f = Float.valueOf("NaN");
		f*=0;
		System.out.println(f< Float.MAX_VALUE);
	}
}
