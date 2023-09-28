package return1;

public class FsResponse {
	
	public static FS response(int a) {
		FS f = new FS();
		f.setColour("red");
		f.setDevice("mobile");
		f.setSum(a);
		return f;
	}
	
	

	public static void main(String[] args) {
		
		int a= 5;
		int b=10;
		int c=a+b;
		FS i = response(c);
		
		System.out.println(i.getColour());
		System.out.println(i.getDevice());
		System.out.println(i.getSum());
		
		r(i);

	}
	
	public static void r(FS d) {
		String a=d.getColour();
	
	
	}

}
