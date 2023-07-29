package demo.java8;

public class MethodReference {
	public static void main(String[] args) {
		//Using Lambda
		X ref=() -> System.out.println("Demo");
		ref.f();
		
		//Using Method Reference
		X ref1=MethodReference::hi;
		ref1.f();
		
		
		/**method Reference for non void method
		 * 1.return type same or covariant
		 * 2.method argument must be same
		 * **/
		//Using Lambda
		Y refy=() -> {return MethodReference.nonVoid();};
		String s=refy.abstractmethod();
		System.out.println(s);
		
		//Using method Reference
		Y refy1=MethodReference::nonVoid;
		String s1=refy1.abstractmethod();
		System.out.println(s1);
		
		Z1 ref2=MethodReference::argMethod;
		ref2.abstractMethod(10, "String");
		
		D1 refd= new MethodReference()::demo;
		String sd=refd.dMethod();
		System.out.println(sd);
		
	}
	/*For Static Method*/
	public static void hi()
	{
		System.out.println("Method Call");
	}
	
	public static String nonVoid()
	{
		return "Non Void";
	}
	
	public static void argMethod(int a,String p)
	{
		System.out.println(a +" ,"+p);
	}
	
	//For Non Static Method
	String demo()
	{
		return "demo";
	}
	
	
	
}

@FunctionalInterface
interface X
{
	public void f();
}

@FunctionalInterface
interface Y
{
	String abstractmethod();
}

@FunctionalInterface
interface Z1
{
	void abstractMethod(int a,String p);
}

@FunctionalInterface
interface D1
{
	String dMethod();
}
