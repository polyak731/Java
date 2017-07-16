package test;


public class MultySort {
	
	volatile static int t=0;
	
	public static void main(String args[]) throws InterruptedException{
		
		new Thread(()->{
			for(int i=0;i<100000;i++) t++;
		}).start();
		new Thread(()->{
			for(int i=0;i<100000;i++) t++;
		}).start();
		new Thread(()->{
			for(int i=0;i<100000*2;i++) System.out.println(t);
		}).start();
		
		Thread.sleep(2000);
		System.out.println(t);
	}
}
