package int1;

public class B implements A {

	public static void main(String[] args) {
	A a=new B();
	a.display();
	String a1=a.language;
	System.out.println(a1+">>>>>>");
	
	

	}

	@Override
	public void display() {
	System.out.println("dispaly");
		
	}

}
