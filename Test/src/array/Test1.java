package array;

public class Test1 {

	public static void main(String[] args) {
	
		int arr [][] = new int[3][];
		
		arr[0] = new int [3];
		arr[1]=new int [4];
		arr [2]= new int [2];
		
		int count =0;
		
		for (int i= 0; i<arr.length;i++) {
			//int count =0;
			for(int j=0;j<arr[i].length;j++) {
				
				//int count =0;
				System.out.print(arr[i][j]=count);
				count++;
				
				
			}
			
		}

	}

}
