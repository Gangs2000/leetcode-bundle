import java.util.Scanner;
interface Interface
{
	double PI=3.18;
	void calculate();
}
class Circle implements Interface
{
	double radius;
	Circle(double radius)
	{
		this.radius=radius;
	}
	public void calculate()
	{
		System.out.printf("Area of Circle is : %.4f",(Interface.PI*radius*radius));
	}
}
class Cone implements Interface
{
	double radius;
	Cone(double radius)
	{	
		this.radius=radius;
	}
	public void calculate()
	{
		System.out.printf("Area of Cone is : %.4f",(Interface.PI*radius*radius*radius));
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int choice;
		double radius;
		System.out.println("Enter choice 1 to calculate Area of Circle 2 to calculate Area of Cone..");
		choice=sc.nextInt();
		if(choice==1)
		{
			System.out.println("Enter the radius to calculate area of Circle :");
			radius=sc.nextDouble();
			Interface obj=new Circle(radius);
			obj.calculate();
		}
		else if(choice==2)
		{
			System.out.println("Enter the radius to calculate area of Cone:");
			radius=sc.nextDouble();
			Interface obj=new Cone(radius);
			obj.calculate();
		}	
	}
}