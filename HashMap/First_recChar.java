import java.util.HashMap;
import java.util.Scanner;
class First_recChar
{
	String string;
	char val='\0';
	HashMap<Integer,Character> hm;
	First_recChar(String string)
	{
		this.string=string;
		hm=new HashMap<Integer,Character>();
	}
	private void recurrence(int pos)
	{
		if(pos==string.length())
		{
			if(val!='\0')
				System.out.println("First recurrence character of the String : "+Character.toString(val));
			else
				System.out.println("All characters are unique no recurrence character found in the String..");
		}
		else
		{
			if(isContain(string.charAt(pos)))
			{
				val=string.charAt(pos);
				System.out.println("First recurrence character of the String : "+Character.toString(val));
			}
			else
			{
				hm.put(pos,string.charAt(pos));
				pos++;
				recurrence(pos);
			}
		}
	}
	private boolean isContain(char c)
	{
		boolean value=(hm.containsValue(c))?true:false;
		return value;
	}
	public static void main(String[] args)
	{
		
		Scanner sc;String str;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter a String to identify its first recurrence character : ");
			str=sc.nextLine().toLowerCase();
			new First_recChar(str).recurrence(0); //Passing first position of String as an argument
		}
		catch(Exception e)
		{
			System.out.println("Exception caught : "+e);
			e.printStackTrace();
		}
	}
}