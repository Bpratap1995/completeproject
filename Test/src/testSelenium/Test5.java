package testSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class Test5 {
	public static void base64(String filePath) throws IOException {
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		
		byte b[] = new byte[(int)f.length()];
		fis.read(b);
		
		String imageString = Base64.encodeBase64String(b);
		System.out.println(imageString);
		
		File file = new File(filePath.split("\\.")[0]+".txt");
		System.out.println("Base64 files "+filePath.split("\\.")[0]+".txt");
		FileWriter writer = new FileWriter(file);
		writer.write(imageString);
		
		writer.close();
		fis.close();
	}
	
	
	

	public static void main(String[] args) throws IOException {
		String folderPath = "C:\\Users\\Bhanu Pratap\\Downloads\\practice_pic\\";
		File file = new File(folderPath);
		File[] f = file.listFiles();
		for( File f1:f) {
			System.out.println(">>>>>>>>>>>>>"+f1.toString());
			base64(f1.toString());
			f1.toString();
		}

	}

}
