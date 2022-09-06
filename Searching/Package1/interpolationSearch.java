package Package1;
public class interpolationSearch
{
	private int array[];
	public int i,probe=0,mid=0;
	boolean flag=false;
	public interpolationSearch(int array[],int length)
	{
		this.array=array;
		array=new int[length];
	}
	public boolean searching(int lower,int upper,int element)
	{
		probe=findProbe(lower,upper,element);
		while(true)
		{
			if(element>array[probe])
			{
				lower=probe+1;
				if(array[lower]>element)
					break;
				else
					searching(lower,upper,element);
			}
			else if(element==array[probe])
			{
				flag=true;
				break;
			}
			else if(element<array[probe])
			{
				upper=probe-1;
				if(array[upper]<element)
					break;
				else
					searching(lower,upper,element);
			}	
		}
		return flag;
	}
	public int findProbe(int lp,int up,int get_ele)
	{
		mid=(int)(lp+((up-lp)*(get_ele-array[lp]))/(array[up]-array[lp]));
		return mid;
	}
}