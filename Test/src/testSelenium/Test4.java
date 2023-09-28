package testSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class Test4 {

	public static void main(String[] args) throws IOException {
		String folderName = "C:\\Users\\Bhanu Pratap\\Downloads\\practice_pic\\";
		File f = new File(folderName);
		File filesList[] = f.listFiles();
		
		for (int i=0;i<filesList.length;i++) {
			String fileName = filesList[i].getName().split("\\.")[0];
			System.out.println(fileName);
			//String path1 = filesList[i].getAbsolutePath();
			//System.out.println(path1);
			
			
			FileInputStream fis = new FileInputStream(new File(fileName));
			byte b[] = new byte[(int) fileName.length()];
			fis.read(b);
			String imageString = Base64.encodeBase64String(b);
			
			
			
			FileWriter writer = new FileWriter( fileName );
			writer.write(imageString);
			fis.close();
			writer.close();
			

		}

	}

}
