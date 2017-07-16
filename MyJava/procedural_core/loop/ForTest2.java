package loop;

public class ForTest2 {
	public static void main(String[] args) {
		for(a();b();c()){
			
		}
		System.out.println("Now");
		a();
		for(;b();c()){
		}
		System.out.println("Now");
		a();
		for(;;c()){
			if(!b()) break;
		}
		System.out.println("Now");
		a();
		for(;;){
			if(!b()) break;
			c();
		}
	}

	private static void c() {
		// TODO Auto-generated method stub
		System.out.println("c()");
	}

	private static boolean b() {
		// TODO Auto-generated method stub
		return false;
	}

	private static void a() {
		// TODO Auto-generated method stub
		System.out.println("a()");
	}
}
