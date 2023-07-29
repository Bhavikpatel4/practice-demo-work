package demo.java8;

public class LambdaVariable {

	int instanceVariable=100;
	static int staticVariable=200;
	
	
	public static void main(String[] args) 
	{
		new LambdaVariable().f1(300);
	}
	
	/**Lambda Expression can use only 2 type of local variable final or effectively final
	 * But this rule is only apply to local variables that are created outside the lambda
	 **/ 
	public void f1(int localVaraiable2)
	{
		int localVariable1=400;
		instanceVariable--;
		staticVariable--;
		Z ref=(localVariable3) -> {
			System.out.println(localVariable1);
			System.out.println(instanceVariable+ " "+staticVariable);
			System.out.println(localVariable3);
		};
		ref.z(localVaraiable2);
	}
	
	@FunctionalInterface
	interface Z
	{
		public void z(int age);
	}
}
