import java.util.Scanner;
class Rainwater
{
	int array[],trapper=0,startPos=0,endPos=0,a=0,b=0;
	Rainwater(int array[])
	{
		this.array=array;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=0)
			{
				startPos=i;
				break;
			}
		}	
		for(int i=(array.length)-1;i>=0;i--)
		{
			if(array[i]!=0)
			{
				endPos=i;
				break;
			}
		}
	}
	private void getMax(int maxPos1,int maxPos2)
	{
		int pos1=startPos,pos2=endPos;
		a=maxPos1;b=maxPos2;
		for(int i=startPos;i<maxPos1;i++)
		{
			if(array[i]>array[pos1])
				pos1=i;
		}
		for(int i=(maxPos2+1);i<=endPos;i++)
		{
			if(array[i]>array[pos2])
				pos2=i;
		}
		this.calculateTrap(pos1,pos2);
	}
	private void calculateTrap(int getPos1,int getPos2)
	{
		for(int i=getPos1;i<a;i++)
		{
			if(array[i]<array[getPos1])
				trapper+=array[getPos1]-array[i];
		}
		for(int i=(b+1);i<=getPos2;i++)
		{
			if(array[i]<array[getPos2])
				trapper+=array[getPos2]-array[i];
		}
		if(getPos1==startPos && getPos2==endPos)
			System.out.println("Trapping Rain Water : "+trapper);
		else
			getMax(getPos1,getPos2);	
		
	}
	public static void main(String[] args)
	{
		Scanner sc;
		int array[],max=0,length,height;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter the number of elements you want to insert :");
			length=sc.nextInt();
			array=new int[length];
			System.out.print("Enter the height :");
			height=sc.nextInt();
			for(int i=0;i<length;i++)
			{
				System.out.print("Enter "+(i+1)+" element of an array : ");
				int element=sc.nextInt();
				if(element<=height)
				{
					if(element>=array[max])
						max=i;
					array[i]=element;
				}
				else
					throw new Exception("Element height must be less than or equal to "+height);
			}
			new Rainwater(array).getMax(max,max);
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred..");
			e.printStackTrace();
		}
	}
}