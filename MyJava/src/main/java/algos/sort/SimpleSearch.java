package algos.sort;

public class SimpleSearch {

	public static int search(int key,int []array){
		for(int i=0;i<array.length;i++) 
			if(key == array[i]) return i;
		return -1;
	}
	
	public static int search(byte key,byte []array){
		for(int i=0;i<array.length;i++) 
			if(key == array[i]) return i;
		return -1;
	}

	public static int search(short key,short []array){
		for(int i=0;i<array.length;i++) 
			if(key == array[i]) return i;
		return -1;
	}
	
	public static int search(float key,float []array){
		for(int i=0;i<array.length;i++) 
			if(key == array[i]) return i;
		return -1;
	}
	
	public static int search(double key,double []array){
		for(int i=0;i<array.length;i++) 
			if(key == array[i]) return i;
		return -1;
	}
	
	public static void main(String args[]){
		int []a = new int[]{2,3,1,2,3,4,2,55};
		System.out.println(SimpleSearch.search(55, a));
	}
}
