package recursion;

import java.util.Arrays;

public class Test3 {
	
	private static int count =0;
	
	public static void main(String[] args) {
		permutation(new int[]{1,2,3}, 3);
	}
	
	private static void permutation(int[] arr, int size){
		System.out.println(count++ +""+Arrays.toString(arr));
		if(size>2){
			for(int i=0;i<arr.length;i++){
				int tmp = arr[size-1];
				arr[size-1] = arr[i];
				arr[i] = tmp;
				permutation(arr, size-1);
			}
		}
	}
}
