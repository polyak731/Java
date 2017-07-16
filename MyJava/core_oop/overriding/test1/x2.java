package overriding.test1;

import java.io.IOException;

public class x2 {
	public static void main(String args[]){
		//f(1);
	}
	
	public static void f(byte arg){
		System.out.print("byte");
	}
	
	public static void f(short arg){
		System.out.print("short");
	}
}
