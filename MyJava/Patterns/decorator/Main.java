package decorator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
	public static void main(String[] args){
		InputStream is = null;
		try {
			is = new SniffInputStream(new BufferedInputStream(new FileInputStream(new File("/home/max/tmp.txt"))));
			readFully(is);
		} catch (IOException e) {
			// TODO: handle exception
		} finally{
			if(is!=null)
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	private static void readFully(InputStream is) throws IOException{
		int result = -1;
		byte buf[] = new byte[12];
		
		while((result = is.read(buf))!=-1){
			System.out.print(new String(buf,0,result,"UTF-8"));
		}
	}
}
