interface One
{
	void execute();
}
interface Two extends One
{
	void develop();
}
abstract class Three implements Two
{
	abstract void implement();
	public void execute()
	{	
		System.out.println("Implementation of Interface execute method");
	}
	public void develop()
	{
		System.out.println("Implementation of Interface develop method");
	}
}
class Interface extends Three
{
	public void implement()
	{
		System.out.println("Implementation of abstract class method");
	}	
	public static void main(String[] args)
	{
		Three obj=new Interface();
		obj.execute();
		obj.develop();
		obj.implement();
	}	
}