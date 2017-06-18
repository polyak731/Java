package files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteObjectFileExample {

	public static class User{
		private String name;
		private int age;
		private float salary;
		
		public User(){
			
		}
		
		public User(String name, int age, float salary) {
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		
		public void writeToFile(String path) throws IOException{
			OutputStream out = null;
			DataOutput dataOutput = null;
			try{
				out = new BufferedOutputStream(new FileOutputStream(new File(path+"/name.dat"))); 
				dataOutput = new DataOutputStream(out);
				
				dataOutput.writeUTF(name);
				dataOutput.writeInt(age);
				dataOutput.writeFloat(salary);
			}catch(IOException ex){
				throw new IOException(ex.getMessage()+ "trouble with create user file"+name);
			}finally{
				if(out!=null){
				out.flush();
				out.close();}
			}
		}
		
		public void readFromFile(String path) throws IOException{
			InputStream in = null;
			DataInput dataInput = null;
			try{
				in = new BufferedInputStream(new FileInputStream(new File(path+"/name.dat"))); 
				dataInput = new DataInputStream(in);
				
				name = dataInput.readUTF();
				age = dataInput.readInt();
				salary = dataInput.readFloat();
			}catch(IOException ex){
				throw new IOException(ex.getMessage()+ "trouble with create user file"+name);
			}finally{
				in.close();
			}
		}
		
		@Override
		public String toString(){
			return "[name = "+name+", age ="+ age+", salary ="+salary+"]";
		}
	}
	
	public static void main(String args[]){
		
		User john = new User("John", 25,300);
		try{
			john.writeToFile("/home/max");
		}catch(IOException ex){
			System.out.println(ex);
		}
		User secondJohn = new User();
		try{
			secondJohn.readFromFile("/home/max");
		}catch(IOException ex){
			System.out.println(ex);
		}
		System.out.println(secondJohn);
	}
}
