package testSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class Test2 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\photo\\passportsizea.jpg");
	    FileInputStream fis = new FileInputStream(f);
	    byte b[] = new byte[(int)f.length()];
	    fis.read(b);
	    String imageString = Base64.encodeBase64String(b);
	    
	   
	    FileOutputStream fos = new FileOutputStream("C:\\photo\\passportsizea.jpg");
	    b=Base64.decodeBase64(imageString);
	    fos.write(b);
	    fis.close();
	    fos.close();
	 
	    }

}
