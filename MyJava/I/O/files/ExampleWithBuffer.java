package files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExampleWithBuffer {
	
	public static void main(String args[]){
		
		String filename = "/home/max/tmp.txt";
		String copy = "/home/max/tmp1.txt";
		
		InputStream in = null;
		OutputStream out = null;
		
		try{
			in = new BufferedInputStream(new FileInputStream(filename));
			out = new BufferedOutputStream(new FileOutputStream(copy));
			copyFile(in,out);
		}catch(IOException ex){
			
		}finally{
			closeQuitlyIn(in);
			closeQuitlyAndFlushOut(out);
		}
	}
	
	public static void copyFile(InputStream in, OutputStream out) throws IOException{
		
		byte []buffer = new byte[256];
		int count = -1;
		while((count = in.read(buffer))!=-1){
			out.write(buffer, 0, count);
		}
	}
	
	public static void closeQuitlyIn(InputStream in){
		if(in==null) return;
		try{
			in.close();
		}catch(IOException ignore){
			/*NOP*/
		}
	}
	
	public static void closeQuitlyAndFlushOut(OutputStream out){
		if(out==null) return;
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
