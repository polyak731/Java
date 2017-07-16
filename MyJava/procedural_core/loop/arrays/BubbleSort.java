package loop.arrays;

public class BubbleSort {

	public static void sort(int[] arr){
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length;j++){
				if(arr[i]>arr[j]){
					arr[i] = arr[j] + arr[i];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
	}
}
