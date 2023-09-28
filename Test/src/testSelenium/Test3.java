package testSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Test3 {
	public static byte[]method(File file) throws IOException{
		FileInputStream f1 = new FileInputStream(file);
		byte[]arr = new byte[(int)file.length()];
		f1.read(arr);
		f1.close();
		return arr;
	}

	public static void main(String[] args) throws IOException {
		File path = new File("C:\\photo1.jpg");
		byte[]array = method(path);
		System.out.println(Arrays.toString(array));
		

	}

}
