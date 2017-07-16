package loop.arrays;

import java.util.Arrays;

public class ArrayInvert {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		invert(arr);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void invert(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length/2;i++){
			int tmp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = tmp;
		}
	}
}
