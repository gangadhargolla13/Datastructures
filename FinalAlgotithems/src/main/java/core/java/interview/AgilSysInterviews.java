package core.java.interview;

public class AgilSysInterviews {

	 int m=10;
	static
	{
		 int m=20;
	}
	protected  AgilSysInterviews()
	{
		
	}
	public static void main(String[] args) {
		Boolean[] bb = new Boolean[10];
		//bb.length=15;  // We con't change final feild value
		System.out.println(bb[0]); // Out put is null value
		System.out.println();
		String st= "Hello india";
		st.concat(" Iam roo");
	}
	public void master(String ...x)
	{
		
	}
	public static void master(String y)
	{
		
	}
}

class x
{
	static void master(int m)
	{
		System.out.println("I am ok");
	}
}

class x1 extends x
{
	static void master(int m)
	{
		
	}
}
class x2 
{
	x c = new x();
	x1 c1 = new x1();
	// c=c1; we con't assign one reference to another one
	
	public void master()
	{
		int m=10;
		/*while(++m > 0)
			;*/
		 int n=20;
		 boolean status;
		 if(status=m==n)
		 {
			 
		 }
	}
}

interface master
{
	void checking();
}

abstract class master1 implements master
{
	@Override
	public void checking()
	{
		
	}
}