package loop;

public class TestPyramidFora {
	public static void main(String[] args) {
		int[] arr = {2,5,3,1,2,4,6,3};
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<=i;j++){
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
