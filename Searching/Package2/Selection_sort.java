package Package2;
public class Selection_sort
{
	private int array[];
	public int i,j,pos=1;
	public Selection_sort(int array[],int length)
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
						swapping(j,pos);
						break;
					}
				}
				j=0;pos=1;
				sorting();
			}
		}
	}
	public void swapping(int pos1,int pos2)
	{
		array[pos1]=array[pos1]+array[pos2];
		array[pos2]=array[pos1]-array[pos2];
		array[pos1]=array[pos1]-array[pos2];
	}
	public int[] output()
	{
		return array;
	}
}