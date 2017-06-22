package serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Copy implements Serializable{
	
	public class User implements Serializable{
		
		private static final long serialVersionUID = 1L;
		String login;
		String password;
		
		public User(String login, String password){
			this.login = login;
			this.password = password;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+login+", "+password+"]";
		}
		
		
	}
	
	public static <T extends Serializable> T copy(T user) throws IOException, ClassNotFoundException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutput oos = new ObjectOutputStream(baos);
		oos.writeObject(user);
		oos.flush();
		oos.close();
		byte[] rawData = baos.toByteArray();
		
		return (T)(new ObjectInputStream(new ByteArrayInputStream(rawData)).readObject());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		User usr1 = new Copy().new User("L","1");
		User usr2 = new Copy().new User("A","2");
		
		System.out.println(usr1);
		System.out.println(usr2);
		
		usr1 = copy(usr2);
		
		usr2.login = "3";
		HashMap map;
		System.out.println(usr1);
		System.out.println(usr2);
	}
}
