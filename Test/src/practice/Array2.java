package practice;

public class Array2 {

	public static void main(String[] args) {
		
		String[] veg = {"potato-1kg","tomato-1kg","pine-1kg"};
		String []veg1 = {"potato","tomato","pine"};
		
		int size=veg.length;
		int size1=veg1.length;
		
		System.out.println(size);
		int j=0;
		
		for(int i=0;i<size;i++) {
			j++;
			String name=veg[i];
			
			System.out.println(name);
			
			String[] Vname = name.split("-");
			
			String nm=Vname[0];
			System.out.println(nm);
			System.out.println("......");
			
			for(int k=0;k<veg1.length;k++) {
				if(nm.equalsIgnoreCase(veg1[k])) {
					System.out.println("pass");
				}
				
				
				
				
			}
			
			
		
		}

	}
}


