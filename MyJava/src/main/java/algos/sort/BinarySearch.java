package algos.sort;

public class BinarySearch {

	public static int search(int key, int[]array){
		
		int right =0;
		int left = array.length-1;
		int mid;
		while(right<=left){
			mid = right + (left - right)/2;
			if(key<array[mid]) left = mid-1;
			else if(key> array[mid]) right = mid+1;
			else return mid;
		}
		
		return -1;
	}
	
	public static int search(double key, double[]array){
		
		int right =0;
		int left = array.length-1;
		int mid;
		while(right<=left){
			mid = right + (left - right)/2;
			if(key<array[mid]) left = mid-1;
			else if(key> array[mid]) right = mid+1;
			else return mid;
		}
		
		return -1;
	}
	
	public static int search(float key, float[]array){
		
		int right =0;
		int left = array.length-1;
		int mid;
		while(right<=left){
			mid = right + (left - right)/2;
			if(key<array[mid]) left = mid-1;
			else if(key> array[mid]) right = mid+1;
			else return mid;
		}
		
		return -1;
	}
	
	public static int search(short key, short[]array){
		
		int right =0;
		int left = array.length-1;
		int mid;
		while(right<=left){
			mid = right + (left - right)/2;
			if(key<array[mid]) left = mid-1;
			else if(key> array[mid]) right = mid+1;
			else return mid;
		}
		
		return -1;
	}
	
	public static int search(byte key, byte[]array){
		
		int right =0;
		int left = array.length-1;
		int mid;
		while(right<=left){
			mid = right + (left - right)/2;
			if(key<array[mid]) left = mid-1;
			else if(key> array[mid]) right = mid+1;
			else return mid;
		}
		
		return -1;
	}
	
	public static int search(char key, char[]array){
		
		int right =0;
		int left = array.length-1;
		int mid;
		while(right<=left){
			mid = right + (left - right)/2;
			if(key<array[mid]) left = mid-1;
			else if(key> array[mid]) right = mid+1;
			else return mid;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = new int[]{2,3,1,2,3,4,2,55};
		System.out.println(BinarySearch.search(55, a));
	}

}
