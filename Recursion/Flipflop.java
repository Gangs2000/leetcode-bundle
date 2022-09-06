import java.util.Scanner;
class Flipflop
{
	int array[][],row,col;
	Flipflop(int array[][],int row,int col)
	{
		this.array=array;
		this.row=row;
		this.col=col;
	}
	void swapper(int i,int j)
	{
		if(i==row)
		{
			System.out.println("Flip flopped array..");
			for(int a=0;a<row;a++)
			{
				for(int b=0;b<col;b++)
					System.out.print(array[a][b]+" ");
				System.out.println();
			}
		}
		else if(j==col)
		{
			i++;j=0;
			swapper(i,j);
		}	
		else
		{
			array[i][j]=(array[i][j]==0)?(1):(0);
			j++;
			swapper(i,j);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc;
		int arr[][],row,col;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter number of rows and columns : ");
			row=sc.nextInt();
			col=sc.nextInt();
			if(row%2==0 || col%2==0)
				throw new Exception("Enter row/column value in odd numbers..");
			else
			{	
				arr=new int[row][col];
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<col;j++)
					{
						arr[i][j]=sc.nextInt();
						if(arr[i][j]!=1 && arr[i][j]!=0)
							throw new Exception("Enter 0 or 1 value..");
					}
				}
				System.out.println();
				new Flipflop(arr,row,col).swapper(0,0);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured : "+e);
			e.printStackTrace();
		}
	}
}