import java.util.*;
class A implements Runnable
{
	int age;
	A(int age)
	{
		this.age=age;
	}
	public void run()
	{
		System.out.println("Thread name : "+Thread.currentThread().getName());
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Exception caught :"+e);
		}
		System.out.println((age>18)?("You are eligible for vote since your age is "+age):("Age must be greater than 18 since your age is "+age));
	}
}
class Thread_demo
{
	public static void main(String[] args)
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			int i,age;
			System.out.print("Enter an age : ");
			age=sc.nextInt();
			Runnable r1=new A(age);
			Runnable r2=new A(age+20);
			Runnable r3=new A(age-10);
			Thread obj1=new Thread(r1,"Thread 1 using Runnable interface");
			Thread obj2=new Thread(r2,"Thread 2 using Runnable interface");
			Thread obj3=new Thread(r3,"Thread 3 using Runnable interface");
			obj3.setPriority(Thread.MAX_PRIORITY);
			obj1.setPriority(Thread.MIN_PRIORITY);
			System.out.println("Thread status before executing run method....");
			System.out.println("Thread 1 status : "+obj1.getState());
			System.out.println("Thread 2 status : "+obj2.getState());
			System.out.println("Thread 3 status : "+obj3.getState());
			obj1.start();
			obj2.start();
			obj3.start();
			System.out.println("Thread status after initiating run method....");
			System.out.println("Thread 1 status : "+obj1.getState());
			System.out.println("Thread 2 status : "+obj2.getState());
			System.out.println("Thread 3 status : "+obj3.getState());
			try
			{
				obj1.join();obj2.join();obj3.join();
				System.out.println("Thread status after executing all thread....");
				System.out.println("Thread 1 status : "+obj1.getState());
				System.out.println("Thread 2 status : "+obj2.getState());
				System.out.println("Thread 3 status : "+obj3.getState());
			}
			catch(Exception e)
			{
				System.out.println("Exceptuon occured :"+e);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught :"+e);
		}
	}
}