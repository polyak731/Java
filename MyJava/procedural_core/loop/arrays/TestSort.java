package loop.arrays;

import java.util.Arrays;

public class TestSort {

	public static void main(String[] args) {
		int []arr = {5,4,2,1,4,2,32,41,24,12,};
		BubbleSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
