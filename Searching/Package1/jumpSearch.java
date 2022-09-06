package Package1;
public class jumpSearch
{
	private int[] array;
	public int i,j,jump=0;
	boolean caught;
	public jumpSearch(int array[],int length)
	{
		this.array=array;
		array=new int[length];
		jump=(int)Math.sqrt(length);
	}
	public boolean findElement(int element)
	{
		for(i=0;i<=(array.length)-1;)
		{
			if(element>array[i])
				i=i+jump;
			else if(element==array[i])
			{
				caught=true;
				break;
			}	
			else if(element<array[i])
			{
				caught=linearSearch(i,element);
				break;
			}
		}
		if(i>=array.length)
			caught=linearSearch(((array.length)-1),element);
		return caught;
	}
	public boolean linearSearch(int pos,int element)
	{
		boolean flag=false;
		for(j=pos;j>pos-jump;j--)
		{
			if(array[j]==element)
			{
				flag=true;
				break;	
			}
		}
		return flag;
	}
}