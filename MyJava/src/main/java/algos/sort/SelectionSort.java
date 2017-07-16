package algos.sort;

import java.util.Arrays;

public class SelectionSort {
	
	public static int[] sort(int ...array){
		
		int []tmp = Arrays.copyOf(array, array.length);
		for(int i = 0;i<tmp.length;i++){
			int min = i;
			for(int j=i;j<tmp.length;j++){
				if(tmp[j]<tmp[min]) min = j; 
			}
			int data = tmp[i];
			tmp[i] = tmp[min];
			tmp[min] = data;
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		int []arr = {1,2,5,6,3,2,6,7};
		System.out.println(Arrays.toString(SelectionSort.sort(arr)));
		System.out.println(Arrays.toString(arr));
	}
}
