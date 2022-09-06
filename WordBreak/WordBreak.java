import java.util.Scanner;
import java.util.HashMap;
class WordBreak
{
	String string;
	HashMap<String,Integer> hm;
	int maxVal=0,start=0,actLen=0;
	WordBreak(String arr[],String string)
	{
		this.string=string;
		hm=new HashMap<String,Integer>();
		for(int i=0;i<arr.length;i++)
			hm.put(arr[i],arr[i].length());
		this.maxValue();
	}
	private void maxValue()
	{
		for(int val:hm.values())
		{
			if(val>maxVal)
				maxVal=val;
		}
	}
	private int breakWord()
	{
		for(int i=start;i<string.length();)
		{
			if((string.length()-start)>=maxVal)
			{
				int j=start+maxVal;
				while(j>(i+1))
				{
					if(isContainkey(string.substring(i,j)))
					{
						start=j;
						actLen+=start-actLen;
						i=start;
						break;
					}
					else
						j--;
				}
				if(j==(i+1))
					break;
			}
			else
			{
				if(isContainkey(string.substring(i,string.length())))
				{
					actLen+=(string.length())-actLen;
					break;
				}
				else
					break;
			}
		}
		return actLen;
	}
	private boolean isContainkey(String str)
	{
		boolean flag=(hm.containsKey(str))?(true):(false);
		return flag;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		String str,dict[];
		int length;
		try
		{
			sc=new Scanner(System.in);
			System.out.print("Enter the String : ");
			str=sc.next().toLowerCase();
			System.out.print("Enter the length of dictionary : ");
			length=sc.nextInt();
			dict=new String[length];
			for(int i=0;i<length;i++)
			{
				System.out.print("Enter "+(i+1)+" element of the dictionay : ");
				dict[i]=sc.next().toLowerCase();
			}
			if(new WordBreak(dict,str).breakWord()==str.length())
				System.out.println("Given String "+str+" can be broken..");
			else
				System.out.println("Given String "+str+" cannot be broken..");
		}
		catch(Exception e)
		{
			System.out.println("Exception caught "+e.getMessage());
			e.printStackTrace();
		}
	}
}