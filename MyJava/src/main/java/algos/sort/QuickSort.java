package algos.sort;

import java.util.Arrays;

public class QuickSort {

	public static int[] sort(int[] array, int start, int end){
		int first = start;
		int last = end;
		
		int mid = (first+last)/2;
		
		while(first<last){
			while(array[first] <= array[mid]) first++;
			while(array[last] >= array[mid]) last--;
			
			if(first<last){
				int data = array[first];
				array[first] = array[last];
				array[last] = data;
			}
		}
		
		sort(array,start,mid);
		sort(array,mid,end);
		
		return array;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,5,1,2,3,5,7};
		System.out.println(Arrays.toString(sort(arr,0,6)));
	}
}
