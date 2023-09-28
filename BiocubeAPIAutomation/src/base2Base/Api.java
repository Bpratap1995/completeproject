package base2Base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;

public class Api {
	
	/*public static HashMap<String, String> data(String image,String document) {
		
		HashMap<String ,String> map = new HashMap<String,String>();
		
		map.put("image_person","image-person");
		map.put("image_document", "image-document");
		return map;
		
	}*/
	public static  HashMap<String, String> Data(String image_person,String image_document) {
		HashMap<String ,String>map= new HashMap<String,String>();
		map.put("image-person", "image_person");
		map.put("image-document","image_document");
		return map;
	}
	
	


	public static void main(String[] args) throws IOException {
		
		File file = new File ("C:\\Users\\Bhanu Pratap\\Downloads\\practice_pic\\");
		File[] file1 = file.listFiles();
	
		for(File f:file1) {
			String filePath =f.toString();
			System.out.println(filePath);
			FileInputStream fis = new FileInputStream(f);
		    byte b[] = new byte[(int)f.length()];
			fis.read(b);
			String imageString = Base64.encodeBase64String(b).toString();
			System.out.println(imageString);
			Data(imageString, imageString);
			
			File file3 = new File(filePath.split("\\.")[0]+".txt");
		//	FileWriter writer = new FileWriter(file3);
			//writer.write(imageString);
			//writer.close();
			fis.close();
		}
		
		

	}

}
