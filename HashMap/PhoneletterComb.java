import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
class PhoneletterComb
{
	ArrayList<String> al;
	HashMap<Character,String> hm;
	String string;
	PhoneletterComb(String string)
	{
		al=new ArrayList<String>();
		hm=new HashMap<Character,String>();
		this.string=string;
	}
	private void assignValues()
	{
		for(int i=0;i<=string.length()-1;i++)
			hm.put(string.charAt(i),getString(string.charAt(i)));
		collectOutput();
	}
	private void collectOutput()
	{
		if(string.length()==0)
			System.out.println(al.toString());
		else if(string.length()==1)
		{
			String str=hm.get(string.charAt(0));
			for(int i=0;i<str.length();i++)
				al.add(Character.toString(str.charAt(i)));
			output();
		}
		else if(string.length()==2)
		{
			String str1=hm.get(string.charAt(0));
			String str2=hm.get(string.charAt(1));
			for(int i=0;i<str1.length();i++)
			{
				for(int j=0;j<str2.length();j++)
				{
					String val="";
					val=Character.toString(str1.charAt(i))+Character.toString(str2.charAt(j));
					al.add(val);
				}
			}
			output();
		}
		else if(string.length()==3)
		{
			String str1=hm.get(string.charAt(0));
			String str2=hm.get(string.charAt(1));
			String str3=hm.get(string.charAt(2));
			for(int i=0;i<str1.length();i++)
			{
				for(int j=0;j<str2.length();j++)
					for(int k=0;k<str3.length();k++)
					{
						String val="";
						val=Character.toString(str1.charAt(i))+Character.toString(str2.charAt(j))+Character.toString(str3.charAt(k));
						al.add(val);
					}
			}	
			output();
		}
		else if(string.length()==4)
		{
			String str1=hm.get(string.charAt(0));
			String str2=hm.get(string.charAt(1));
			String str3=hm.get(string.charAt(2));
			String str4=hm.get(string.charAt(3));
			for(int i=0;i<str1.length();i++)
			{
				for(int j=0;j<str2.length();j++)
					for(int k=0;k<str3.length();k++)
						for(int m=0;m<str4.length();m++)
						{
							String val="";
							val=Character.toString(str1.charAt(i))+Character.toString(str2.charAt(j))+Character.toString(str3.charAt(k))+Character.toString(str4.charAt(m));
							al.add(val);
						}
			}	
			output();
		}
	}
	private void output()
	{
		System.out.println("Overall combination : "+al.size());
		System.out.println(al);
	}
	private String getString(char temp)
	{
		String value="";
		switch(temp)
		{
			case '2':value="abc";break;
			case '3':value="def";break;
			case '4':value="ghi";break;
			case '5':value="jkl";break;
			case '6':value="mno";break;
			case '7':value="pqrs";break;
			case '8':value="tuv";break;
			case '9':value="wxyz";break;
		}
		return value;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		String digit;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter digits between (2-9) : ");
			digit=sc.next();
			if(digit.length()<5)
				new PhoneletterComb(digit).assignValues();
			else
				throw new Exception("Digit must less than or equal to 4..");
		}	
		catch(Exception e)
		{
			System.out.println("Exception caught : "+e.getMessage());
			e.printStackTrace();
		}
	}
}