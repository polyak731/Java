package files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileExmplArray {

	public static void main(String args[]){
		
		String fileName = "/home/max/tmp.txt";
		
		InputStream inFile = null;
		
		try {
			inFile = new FileInputStream(fileName);
			System.out.println(new String(readFullyByByte(inFile)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeQuitly(inFile);
		}
	}
	
	public static byte[] readFullyByByte(InputStream inStream) throws IOException{
		
		int result = -1;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((result = inStream.read())!=-1){
			bos.write(result);
		}
		return bos.toByteArray();
	}
	
	public static void closeQuitly(InputStream inStream){
		if(inStream!=null)
		try{
			inStream.close();
		}catch(IOException ignore){
			/*NOP*/
		}
	}
}
