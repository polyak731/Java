package adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListInputStream extends InputStream{

	private ArrayList<Byte> arrayList; 
	
	public ArrayListInputStream(ArrayList<Byte> arrayList){
		this.arrayList = arrayList;
	}
	
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return (!arrayList.isEmpty())? arrayList.remove(0):-1;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		if(b==null) throw new NullPointerException();
		if(off<0 || len<0 || off+len>b.length) throw new IndexOutOfBoundsException();
		if(b.length == 0) return -1;
		byte[] copy = new byte[arrayList.size()];
		for(int i=0;i<copy.length;i++){
			copy[i] = arrayList.get(i);
		}
		arrayList.clear();
		System.arraycopy(copy, 0 , b, off, len);
		return len;
	}
}
