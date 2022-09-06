package Package1;
public class Bubble_sort
{
	private int array[];
	public int i,j,count=0;
	public Bubble_sort(int array[],int length)
	{
		this.array=array;
		array=new int[length];
	}
	public void sorting()
	{
		for(i=0;i<(array.length)-1;i++)
		{
			if(array[i]>array[i+1])
			{
				array[i]=array[i]+array[i+1];
				array[i+1]=array[i]-array[i+1];
				array[i]=array[i]-array[i+1];
			}
		}
		validation();
	}
	public void validation()
	{
		for(j=0;j<(array.length)-1;j++)
		{
			if(array[j]<array[j+1])
				count++;
			else
				break;
		}
		if(count!=(array.length)-1)
		{
			count=0;
			sorting();
		}
	}
	public int[] output()
	{
		return array;
	}
}