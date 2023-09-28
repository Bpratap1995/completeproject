package practice;

import java.util.Arrays;
import java.util.List;

public class Array1 {

	public static void main(String args[]) {

		String str1[] = { "potato .txt", "tomato .txt", "pine .txt" };

		List<String> ele = Arrays.asList(str1);
		int size = ele.size();
		System.out.println(ele.size());

		for (int i = 0; i < size; i++) {
			System.out.println(ele.get(i));

			String[] ele1 = ele.get(i).split("\\.");
			String veg = ele1[0];

			System.out.println(veg);

		}

	}

}
