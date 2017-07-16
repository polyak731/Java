package test;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread main = Thread.currentThread();
		Thread t = new Thread(()->{
			try {
				main.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t.start();
		t.join();
	}

}
