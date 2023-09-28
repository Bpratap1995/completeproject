package testSelenium;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class Test6 {
	
	public static void base64(String filepath) throws IOException {
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);
		
		byte[]b = new byte[(int)f.length()];
		fis.read(b);
		String image = Base64.encodeBase64String(b);
		System.out.println(image);
		File file = new File(filepath.split("\\.")[0]+".txt");
		System.out.println("Base64 files "+filepath.split("\\.")[0]+".txt");
		FileWriter writer = new FileWriter(file);
		writer.write(image);
		writer.close();
		fis.close();
		
		
	}
	

	public static void main(String[] args) throws IOException  {
		String filepath ="C:\\Users\\Bhanu Pratap\\Downloads\\pic\\";
		File file = new File(filepath);
		File[]f = file.listFiles();
		int size = f.length;
		System.out.println(size);
		
		for(int i=0;i<size;i++) {
     base64( f[i].toString());
     
	}

	}

}
