package loop;

public class TestFor8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<32;i++){
			System.out.println("pow(2,"+i+")"+Math.pow(2, i));
			System.out.println("2<<"+i+":"+(2<<i));
		}
	}

}
