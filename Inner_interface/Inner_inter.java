import java.util.*;
interface Outer
{
	default void default_method()
	{
		System.out.println("Default Outer method");
	}
	static void outer_method()
	{
		System.out.println("Static Outer method");
	}
	interface Inner
	{
		double PI=3.14;
		void method();
	}
}
class Inner_inter implements Outer,Outer.Inner
{
	double radius;
	Inner_inter(double radius)
	{
		this.radius=radius;
	}
	public void method()
	{
		Outer.outer_method();
		default_method();
		System.out.println("Value is:"+(PI*radius*radius));
	}
	public static void main(String[] args)
	{
		double radius;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a radius value :");
		try
		{	
			radius=sc.nextDouble();
			Inner_inter obj=new Inner_inter(radius);
			obj.method();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid data passed thorugh prompt : Please enter only double value...");
		}
		sc.close();
	}
}