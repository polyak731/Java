package DDS;

import java.util.Arrays;

public class DinArray {
	
	public int []arr = {};
	
	public void add(int item){
		int[] newArr = new int[arr.length+1];
		newArr[arr.length] = item;
		
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(arr);
	}



	public static void main(String[] args) {
		DinArray arr = new DinArray();
		arr.add(2);
		arr.add(1);
		System.out.println(arr);
	}
}
