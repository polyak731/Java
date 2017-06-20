package adapter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import decorator.SniffInputStream;

public class Main {

	public static void main(String[] args) throws IOException{

		ArrayList<Byte> arrListBuf = new ArrayList<>();
		ArrayListInputStream alis = new ArrayListInputStream(arrListBuf);
		
		arrListBuf.add((byte) 10);
		arrListBuf.add((byte)20);
		arrListBuf.add((byte)30);
		arrListBuf.add((byte)40);
		
		byte[] buf = new byte[4];
		System.out.println(alis.read(buf,0,4));
		System.out.println(Arrays.toString(buf));
	}

}
