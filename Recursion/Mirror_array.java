import java.util.Scanner;
class Mirror_array
{
	char[][] array;
	int row,col;
	Mirror_array(char array[][],int row,int col)
	{	
		this.array=array;
		this.row=row;
		this.col=col;
	}
	void mirror(int r,int i,int j)
	{
		if(r==row)
		{
			System.out.println("Mirror Array..");
			for(int a=0;a<row;a++)
			{
				for(int b=0;b<col;b++)
				{
					System.out.print(array[a][b]+" ");
				}
				System.out.println();
			}	
		}
		else if(i==j || i>j)
		{
			r++;i=0;
			j=col-1;
			mirror(r,i,j);	
		}
		else
		{
			char a=array[r][i];
			char b=array[r][j];
			char temp=a;a=b;b=temp;
			array[r][i]=a;
			array[r][j]=b;
			i++;j--;
			mirror(r,i,j);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc;
		char arr[][];
		int row,col;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter number of rows and columns : ");
			row=sc.nextInt();
			col=sc.nextInt();
			arr=new char[row][col];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					arr[i][j]=sc.next().charAt(0);
				}
			}
			System.out.println();
			new Mirror_array(arr,row,col).mirror(0,0,col-1); //(row,pos1,pos2)
		}
		catch(Exception e)
		{
			System.out.println("Exception caught : "+e);
			e.printStackTrace();
		}
	}
}