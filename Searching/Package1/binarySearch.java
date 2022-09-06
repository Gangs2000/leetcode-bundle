package Package1;
public class binarySearch
{
	private int array[];
	public int i,mid;
	boolean flag=false;
	public binarySearch(int array[],int length)
	{
		this.array=array;
		array=new int[length];
	}
	public boolean binary_search(int element)
	{
		mid=((array.length)/2);
		while(true)
		{
			if(array[mid]<element)
			{
				for(i=mid;i<array.length;i++)
				{
					if(array[i]==element)
						flag=true;
				}
				break;
			}
			else
			{
				for(i=0;i<=mid;i++)
				{
					if(array[i]==element)
						flag=true;
				}
				break;
			}
		}
		return flag;
	}
}