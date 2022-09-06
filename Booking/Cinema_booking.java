import java.util.Scanner;
class Cinema_booking
{
	int rows,col,reserved[][],count=0,allot=0;
	Cinema_booking(int rows,int reserved[][])
	{
		this.rows=rows;
		col=10;
		this.reserved=reserved;
	}
	private int allocationSeat()
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=2;j<col;)
			{
				if(isReserved((i+1),j))
				{
					count++;
					setBack(count);	
					j++;
				}
				else
				{
					count=0;
					j=(j%2==0)?(j+2):(j+1);	
				}
			}
			count=0;
		}
		return allot;
	}
	private boolean isReserved(int a,int b)
	{
		boolean flag=true;
		for(int k=0;k<reserved.length;k++)
		{
			if(reserved[k][0]==a && reserved[k][1]==b)
				flag=false;
		}
		return flag;
	}
	private void setBack(int val)
	{
		if(val==4)
		{
			allot+=val/4;
			count=0;
		}
	}
	public static void main(String[] args)
	{
		int row,n,array[][];
		Scanner sc;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter value of N : ");
			n=sc.nextInt();
			System.out.println("Enter number of rows want to insert into reserved array :");
			row=sc.nextInt();
			array=new int[row][2];
			for(int i=0;i<row;i++)
			{
				System.out.println("Enter "+(i+1)+" row value");
				for(int j=0;j<array[i].length;j++)
				{
					int element=sc.nextInt();
					if(j==0 && element<=n || (j==1 && element<=10))
						array[i][j]=element;
					else
						throw new Exception("Invalid data entry...");
				}
			}
			System.out.println("Total possibilities :"+new Cinema_booking(n,array).allocationSeat());
		}
		catch(Exception e)
		{
			System.out.println("Exception caught :"+e.getMessage());
			e.printStackTrace();
		}
	}
}