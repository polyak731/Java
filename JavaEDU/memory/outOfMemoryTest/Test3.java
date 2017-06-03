package outOfMemoryTest;

public class Test3 {

	private static int counterFoo=0;
	private static int counterBar=0;
	private static int counterLee=0;
	
	private static void foo(){
		counterFoo++;
		
		foo();
	}
	
	private static void bar(){
		counterBar++;
		long l=0;
		long l1=0;
		long l2=0;
		long l3=0;
		long l4=0;
		long l5=0;
		bar();
	}
	
	private static void lee(){
		counterLee++;
		Object o0;
		Object o1;
		Object o2;
		Object o3;
		Object o4;
		Object o5;
		lee();
	}
	
	public static void main(String args[]){
		
		try{
			foo();
		}catch(Error err){
			System.out.println(counterFoo);
			System.err.println(err);
		}
		
		try{
			bar();
		}catch(Error err){
			System.out.println(counterBar);
			System.err.println(err);
		}

		try{
			lee();
		}catch(Error err){
			System.out.println(counterLee);
			System.err.println(err);
		}
	}
}
