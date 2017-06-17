package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileExample {

	public static void main(String args[])throws IOException{
		
		String fromFile = "/home/max/tmp.txt";
		String toFile = "/home/max/tmp1.txt";
		
		InputStream in = null;
		OutputStream out = null;
		try{
			out = new FileOutputStream(toFile);
			in = new FileInputStream(fromFile); 
			copy(in,out);
		}catch(IOException e){
			throw new IOException("Problem when copy file" + fromFile);
		}finally{
			closeQuitlyIn(in);
			closeQuitlyOut(out);
		}
	}

	private static void copy(InputStream in, OutputStream out) throws IOException{
		// TODO Auto-generated method stub
		byte []buf = new byte[8];
		int count = -1;
		while((count = in.read(buf))!=-1){
			out.write(buf,0,count);
		}
	}
	
	private static void closeQuitlyIn(InputStream in){
		if(in == null) return;
		try{
			in.close();
		}catch(IOException ignore){
			/*NOP*/
		}
	}
	
	private static void closeQuitlyOut(OutputStream out){
		if(out == null) return;
		try{
			out.flush();
		}catch(IOException ignore){
			/*NOP*/
		}
		try{
			out.close();
		}catch(IOException ignore){
			/*NOP*/
		}
	}
}
