package practice;

public class SavingAc extends Bank{
	String Cusname;
	String Cusacnum;
	
	public SavingAc(String Bname,String Branchname,String BLoc,String Cusname,String Cusacnum)
	{
		super(Bname,Branchname,BLoc);
		this.Cusname= Cusname;
		this.Cusacnum=Cusacnum;
	}
	public void display() {
		System.out.println(Bname);
		System.out.println(Branchname);
		System.out.println(BLoc);
		System.out.println(Cusname);
		System.out.println(Cusacnum);
	}
}
