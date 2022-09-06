import java.util.*;
class String_reverse
{	
	String string;
	int str_ptr,end_ptr,i,j;
	boolean flag1=false,flag2=false;
	char[] alphas={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	String_reverse(String string,int sp,int ep)
	{
		this.string=string;
		str_ptr=sp;
		end_ptr=ep;
	}
	void get_positions(int sp,int ep)
	{
		for(i=str_ptr;i<string.length()-1;i++)
		{
			for(char a:alphas)
			{
				if(string.charAt(i)==a)
				{
					str_ptr=i;
					flag1=true;
					break;
				}
			}
			if(flag1)
				break;
		}
		for(j=end_ptr;j>=str_ptr;j--)
		{
			for(char a:alphas)
			{
				if(string.charAt(j)==a)
				{
					end_ptr=j;
					flag2=true;
					break;
				}
			}
			if(flag2)
				break;
		}
		swap(str_ptr,end_ptr);
		if(str_ptr<end_ptr)
		{
			flag1=false;flag2=false;
			get_positions(str_ptr,end_ptr);
		}
		else 
			System.out.println("Modified String : "+string);
	}
	void swap(int start,int end)
	{
		str_ptr=start;end_ptr=end;
		if(str_ptr<end_ptr)
		{
			char chars[]=string.toCharArray();
			char temp=chars[str_ptr];
			chars[str_ptr]=chars[end_ptr];
			chars[end_ptr]=temp;
			string=new String(chars);
			str_ptr++;end_ptr--;
		}	
	}
	public static void main(String[] args) throws Exception
	{
		try
		{
			System.out.println();
			System.out.print("Enter the String : ");
			Scanner sc=new Scanner(System.in); 
			String get_str=sc.next();
			String_reverse obj=new String_reverse(get_str,0,get_str.length()-1);
			obj.get_positions(0,get_str.length()-1);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught :"+e);
			e.printStackTrace();
		}
	}
}