import java.util.Scanner;
import java.util.HashMap;
class Isomorphic
{
	HashMap<Character,Character> hm;
	String string1,string2;
	boolean flag=true;
	Isomorphic(String string1,String string2)
	{
		hm=new HashMap<Character,Character>();
		this.string1=string1;
		this.string2=string2;
	}
	private String checkString()
	{
		for(int i=0;i<=(string1.length()-1);i++)
		{
			if(isContain(string1.charAt(i)))
			{
				if(hm.get(string1.charAt(i))!=string2.charAt(i)){
					flag=false;
					break;
				}
			}
			else if(!hm.containsValue(string2.charAt(i)))
				hm.put(string1.charAt(i),string2.charAt(i));  
            else{
                if(hm.containsKey(string1.charAt(i)) && hm.get(string1.charAt(i))==string2.charAt(i))
                    hm.put(string1.charAt(i),string2.charAt(i));
                else{
                    flag=false;
                    break;
                }
            }				
		}		
		String output=(flag)?("Both Strings are Isomorphic.."):("Both Strings are not Isomorphic..");
		return output;
	}
	private boolean isContain(char temp)
	{
		boolean val=(hm.containsKey(temp))?(true):(false);
		return val;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		String str1,str2,ans;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter two Strings.. : ");
			str1=sc.nextLine().toLowerCase();
			str2=sc.nextLine().toLowerCase();
			if(str1.length()==str2.length())
				ans=new Isomorphic(str1,str2).checkString();
			else
				throw new Exception("Both String length must be same..");
			System.out.println();
			System.out.println(ans);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught : "+e.getMessage());
			e.printStackTrace();
		}
	}
}