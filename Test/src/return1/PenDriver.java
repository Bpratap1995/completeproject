package return1;

public class PenDriver {
	
	
	
	
 public static   void pr(String colour,String color) {
	 
	 String sum = color;
	 System.out.println(sum);
	 
	 Pen p1 = new Pen();
	 
	 p1.setName("Reynolds");
	 p1.setColour(colour);      
	 p1.setType("Ballpoint");
	 System.out.println(p1.getColour());
	 
	
	 
 
 }
 
 
	public static void main(String[] args) {
		
		String colour ="red";
		
		String colour1="blue";
		
	   pr(colour,colour1);
		
		//System.out.println(a);
		
		//System.out.println(pr(colour,colour1));
		
		//System.out.println(pr(colour).getName());
		//System.out.println(pr(colour).getType());
		
		
		
		
		
	}

}
