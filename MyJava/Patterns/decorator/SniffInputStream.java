package decorator;

import java.io.IOException;
import java.io.InputStream;

public class SniffInputStream extends InputStream{

	private InputStream inputStream;
	
	public SniffInputStream(InputStream inputStream) {
		super();
		this.inputStream = inputStream;
	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1 byte");
		return this.inputStream.read();
	}

	@Override
	public int read(byte[] b) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(b.length+" bytes");
		return this.inputStream.read(b);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(len+" bytes from "+off+" to "+off+len);
		return this.inputStream.read(b, off, len);
	}
	
	
}
