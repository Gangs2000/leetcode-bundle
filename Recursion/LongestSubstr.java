import java.util.Scanner;
class LongestSubstr
{
	String string;
	boolean flag=true;
	int start,end,count=1,keep=0;
	LongestSubstr(String string)
	{
		this.string=string;
	}
	void calculate(int start,int end)
	{
		if(start==(string.length()) || end==(string.length()))
				System.out.println("Longest SubString length is "+keep);
		else
		{
			if((string.charAt(start)!=string.charAt(end)))
			{
				flag=true;
				for(int i=start;i<end;i++)	
				{
					if(string.charAt(i)!=string.charAt(end))
						count++;
					else
						flag=false;
				}
			}
			else
				flag=false;
			repeatation(start,end,flag);
		}
	}
	void repeatation(int start,int end,boolean flag)
	{
		if(flag)
		{
			if(keep<count)
				keep=count;
			start=start;
			end++;count=1;
			calculate(start,end);
		}
		else
		{
			if(keep<count)
				keep=count;
			start=start+1;
			end=start+1;count=1;
			calculate(start,end);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc;
		LongestSubstr obj;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter the String : ");
			String str=sc.nextLine();
			if(str.length()==1)
				System.out.println("Longest SubString length is "+str.length());
			else
			{
				obj=new LongestSubstr(str.toLowerCase());
				obj.calculate(0,1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured : "+e);
			e.printStackTrace();
		}
	}
}