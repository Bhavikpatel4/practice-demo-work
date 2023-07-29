package demo.java8;

public class MethodReferanceForParameter {
	public static void main(String[] args) 
	{
		MethodReferanceForParameter mr=new MethodReferanceForParameter();
		
		FunInterface1 d = MethodReferanceForParameter::M; //m -> m.M()
		String s=d.demo(mr);
		System.out.println(s);
	}
	
	public String M()
	{
		return "HI";
	}
}

@FunctionalInterface
interface FunInterface1
{
	String demo(MethodReferanceForParameter mrd);
}
