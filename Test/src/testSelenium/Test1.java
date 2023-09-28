package testSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.codec.binary.Base64;

public class Test1 {
	public static void main(String[] args) throws IOException {
		//store the data in reference variable
		File f = new File("C:\\photo\\passportsizea.jpg");
		// read the dta
		FileInputStream fis = new FileInputStream(f);
		byte b[] = new byte[(int)f.length()];
		fis.read(b);
		//convert into base64
		String imageString = Base64.encodeBase64String(b);
		//create a file along with the path to store the text
		File path = new File("C:\\photo\\passportsizea.txt");
		PrintWriter pw = new PrintWriter(path);
		pw.write(imageString);
        
	
		fis.close();
		pw.close();
		
		
		
	
		
}
}
