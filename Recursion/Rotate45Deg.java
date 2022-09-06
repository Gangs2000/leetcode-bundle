import java.util.Scanner;
class Rotate45Deg
{
	int arr[][];
	Rotate45Deg(int arr[][])
	{
		this.arr=arr; //Initializing two dimentional array
	}
	void rotate_row(int mid,int col)
	{
		if(col<mid || col>mid)
			swapper1(mid,col);
		else if(col==mid)
		{
			col=col+1;
			rotate_row(mid,col);
		}
	}
	void rotate_column(int row,int mid)
	{
		if(row<mid || row>mid)
			swapper2(row,mid);
		else if(row==mid)
		{
			row=row+1;
			rotate_column(row,mid);
		}
	}
	void swapper1(int mid,int col)
	{
		arr[mid][col]=arr[mid][col]+arr[(mid-col)+mid][col];
		arr[(mid-col)+mid][col]=arr[mid][col]-arr[(mid-col)+mid][col];
		arr[mid][col]=arr[mid][col]-arr[(mid-col)+mid][col];
		if(col!=(arr.length)-1)
		{
			col=col+1;mid=mid;
			rotate_row(mid,col);
		}
	}
	void swapper2(int row,int mid)
	{
		arr[row][mid]=arr[row][mid]+arr[row][row];
		arr[row][row]=arr[row][mid]-arr[row][row];
		arr[row][mid]=arr[row][mid]-arr[row][row];
		if(row!=(arr.length)-1)
		{
			row=row+1;
			rotate_column(row,mid);
		}	
	}
	void show()
	{
		System.out.println("Rotatated row 45 deg anti clockwise..");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		int array[][];
		Rotate45Deg obj;
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter number of rows and columns ( Make sure both values are Odd ) : ");
			int row=sc.nextInt();
			int col=sc.nextInt();
			if(row%2==0 || col%2==0)
				throw new Exception("You have provided even values..");
			array=new int[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
					array[i][j]=sc.nextInt();              //Assining values to each row and column
			}
			obj=new Rotate45Deg(array);
			obj.rotate_row(row/2,0);
			obj.rotate_column(0,col/2);
			obj.show();
		}
		catch(Exception e)
		{
			System.out.println("Exception caught : "+e);
			e.printStackTrace();
		}	
	}
}