import java.util.Scanner;
class Parantheses
{
	int stack[],top,count;
	String output="",input;	
	Parantheses(String input)
	{
		this.input=input;
		stack=new int[(input.length()-1)];
		top=-1;count=0;
	}
	void validate(int pointer)
	{
		if(pointer==(input.length()-1))
		{
			if(input.charAt(pointer)==')')
			{
				int temp=stack[top];
				top--;
				output+=Integer.toString(temp);
			}
			System.out.println("Output String : "+output);
		}
		else if((input.charAt(pointer)!='(' && input.charAt(pointer)!=')') || (input.charAt(pointer)==')' && top==-1))
		{
			pointer++;
			validate(pointer);
		}
		else if(input.charAt(pointer)=='(')
		{
			top++;count++;
			stack[top]=count;
			output+=Integer.toString(count);
			pointer++;
			validate(pointer);
		}
		else if(input.charAt(pointer)==')')
		{
			int temp=stack[top];
			top--;
			output+=Integer.toString(temp);
			pointer++;
			validate(pointer);
		}
	}
	public static void main(String[] args)
	{
		String str;Scanner sc;
		try
		{
			sc=new Scanner(System.in);	
			System.out.println("Enter a String to find out Parantheses location : ");
			str=sc.nextLine();
			Parantheses obj=new Parantheses(str);
			obj.validate(0);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught : "+e);
			e.printStackTrace();
		}
	}
}