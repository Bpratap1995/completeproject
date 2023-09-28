package practice;

public class M_FDriver {
	
	public static M_F written(String name,String price,String colour) {
	M_F f = new M_F();
	f.setM_F( name, price,colour);
	f.displayM_F();
	return f;
	}

	public static void main(String[] args) {
	 String name = "bhanu";
	 String price="2000";
	 String colour="white";
	 written(name,price,colour);
	 
	 
	


	}

	



	

}
