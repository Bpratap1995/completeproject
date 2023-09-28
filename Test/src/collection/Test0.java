package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Test0 {

	
	public static void main(String[] args) {
		
 ArrayList<String> list = new ArrayList<>();
 list .add("ram");
 list.add("bhanu");
 list.add("kamal");
 list.add(2, "d");
 System.out.println(list.get(1));
 
 list.clone();
 System.out.println(list.clone());
 



	}
}


