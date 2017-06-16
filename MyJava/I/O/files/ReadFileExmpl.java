package files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileExmpl {

	public static void main(String args[]){
		
		String fileName = "/home/max/tmp.txt";
		
		InputStream inFile = null;
		try{
			inFile = new FileInputStream(fileName);
			readFullyByByte(inFile);
		}catch(IOException ex){
			
		}
		finally{
			if(inFile!=null)
			try {
				inFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void readFullyByByte(InputStream inFile)throws IOException{
		
		byte []arr = new byte[256];
		inFile.read(arr);
		
		for(int i=0;i<arr.length;i++){
			System.out.print((char)arr[i]);
		}
	}
}
