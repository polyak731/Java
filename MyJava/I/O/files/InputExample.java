package files;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

public class InputExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataInput dataInput = new DataInputStream(System.in);
		String s = dataInput.readLine();
		System.out.println(s);
	}

}
