package practice;

import java.io.File;


    public class Test {
	public static void main(String[] args)  {
		String folderName = "C:\\Users\\Bhanu Pratap\\Downloads\\new2\\";
		File f = new File(folderName);
		File filesList[] = f.listFiles();
		System.out.println(filesList.length);
		int i=0;
		
		for ( i=0;i<filesList.length;i++) {
			String fileName = filesList[i].getName();
			System.out.println(fileName);
			for( i =i+1;i<filesList.length;i++) {
				String fileName1 = filesList[i].getName();
				System.out.println(fileName1);
				
			}
			
			
		}
	    
	   
	
		
	}
}


