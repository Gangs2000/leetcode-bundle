package Package;
public class Sort
{
	int arr[],i,j;
	public Sort(int arr[])
	{
		this.arr=arr;
	}
	protected void sort()
	{
		for(i=0;i<arr.length;i++)
		{
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					arr[i]=arr[i]+arr[j];
					arr[j]=arr[i]-arr[j];
					arr[i]=arr[i]-arr[j];
				}
			}
		}	
	}
	protected void show()
	{
		System.out.println("Ascending order elements...");
		for(i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
}