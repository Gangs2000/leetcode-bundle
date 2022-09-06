import java.util.Scanner;
class Seven_segmant
{
	int spare[][];
	char[][] display={{' ','_',' '},{'|','_','|'},{'|','_','|'}};
	Seven_segmant(int spare[][],int row,int column)
	{
		this.spare=spare;
		spare=new int[row][column];
	}
	void print()
	{
		for(int i=0;i<(spare.length);i++)
		{
			for(int j=0;j<(spare[i].length);j++)
			{
				if(spare[i][j]==0)
					System.out.print(" ");
				else
					System.out.print(display[i][j]);	
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		int store[][]={};
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number to print :");
		int n=sc.nextInt();
		switch(n)                                                             //Switch for storing values of each number
		{
			case 0 : store=new int[][]{{0,1,0},{1,0,1},{1,1,1}};break;
			case 1 : store=new int[][]{{0,0,0},{0,0,1},{0,0,1}};break;      
			case 2 : store=new int[][]{{0,1,0},{0,1,1},{1,1,0}};break;
			case 3 : store=new int[][]{{0,1,0},{0,1,1},{0,1,1}};break;
  			case 4 : store=new int[][]{{0,0,0},{1,1,1},{0,0,1}};break;
			case 5 : store=new int[][]{{0,1,0},{1,1,0},{0,1,1}};break;
			case 6 : store=new int[][]{{0,0,0},{1,1,0},{1,1,1}};break;
			case 7 : store=new int[][]{{0,1,0},{0,0,1},{0,0,1}};break;
			case 8 : store=new int[][]{{0,1,0},{1,1,1},{1,1,1}};break;
			case 9 : store=new int[][]{{0,1,0},{1,1,1},{0,1,1}};break;
		}
		switch(n)                                                             //Switch for passing values to constructor to print LED segmants
		{
			case 0 : 
			case 1 : 
			case 2 : 
			case 3 : 
			case 4 : 
			case 5 : 
			case 6 : 
			case 7 : 
			case 8 : 
			case 9 : new Seven_segmant(store,store.length,store.length).print();break;
			default : System.out.println("Please enter a number between 0-9..");break;
		}
	}
}