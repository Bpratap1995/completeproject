package practice;

public class Array {

	public static void main(String[] args) {
	int row=3;
	int col=2;
		int a [][] = new int[row][col];
		 a[0][0]=0;
		 a[0][1]=1;
		 a[1][0]=2;
		 a[1][1]=3;
		 a[2][0]=4;
		 a[2][1]=5;
		 
		 for (int i=0;i<=row-1;i++) {
			 for(int j=0;j<=col-1;j++) {
				 System.out.print(a[i][j]+" ");
			 }
			 System.out.println();
		 }
		
		 
		 

	}

}
