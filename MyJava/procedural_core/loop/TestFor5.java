package loop;

public class TestFor5 {
	public static void main(String[] args) {
		for(int i=0;i<10;i+=2){
			System.out.println(i);
		}
		for(int i=0;i<10;i++){
			if(i%2==0)
				System.out.println(i);
		}
	}
}
