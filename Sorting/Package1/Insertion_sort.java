package Package1;
public class Insertion_sort
{
	private int array[];
	public int i,j,k,temp,pos=1;
	public Insertion_sort(int array[],int length)
	{
		this.array=array;
		array=new int[length];
	}
	public void sorting() 
	{
		for(i=0;i<(array.length)-1;i++)
		{
			if(array[i]<array[pos])
				pos++;
			else if(i==array.length)
				break;
			else if(array[i]>array[pos])
			{
				for(j=0;j<pos;j++)
				{
					if(array[j]>array[pos])
					{
						insertion(j,pos);
						break;
					}
				}
				j=0;pos=1;
				sorting();
			}
		}
	}
	public void insertion(int start,int end)
	{
		temp=array[end];
		for(k=(end-1);k>=start;k--)
			array[k+1]=array[k];
		array[start]=temp;
	}
	public int[] output()
	{
		return array;
	}
}