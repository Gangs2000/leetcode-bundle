import java.util.Scanner;
import java.util.ArrayList;
class Breathfirst
{
	char queue[],array[][];
	int maxNodes,pointer=-1;
	ArrayList<Character> visited;
	Breathfirst(char array[][],int maxNodes,int queue_row)
	{
		this.array=array;
		visited=new ArrayList<Character>();
		this.maxNodes=maxNodes;
		queue=new char[queue_row];
	}
	private void tracking()
	{
		if(visited.size()==0 && pointer==-1)
		{
			pointer++;
			queue[pointer]=array[0][0];
			visited.add(array[0][0]);
			tracking();
		}
		else if(visited.size()==maxNodes && pointer==-1)
		{
			System.out.println();
			System.out.println("Output sequence...");
			for(int out=0;out<visited.size();out++)
				System.out.print(visited.get(out)+" ");
		}
		else
		{
			checkChildNodes(queue[0]);
			tracking();
		}
	}
	private void checkChildNodes(char value)
	{
		boolean flag=true;
		for(int i=0;i<array.length;i++)
		{
			if(array[i][0]==value && isVisited(array[i][0]))
			{
				flag=false;
				for(int j=1;j<array[i].length;j++)
				{
					if(!isVisited(array[i][j]))
					{
						pointer++;
						queue[pointer]=array[i][j];
						visited.add(array[i][j]);
					}
				}
				arrayAdjustment(pointer);
			}
		}
		if(flag)
		{
			visited.add(queue[0]);
			arrayAdjustment(pointer);
		}
	}
	private boolean isVisited(char val)
	{
		boolean flag=(visited.contains(val))?(true):(false);
		return flag;
	}
	private void arrayAdjustment(int cursor)
	{
		for(int k=1;k<=cursor;k++)
			queue[k-1]=queue[k];
		pointer=(cursor-1);
	}
	public static void main(String[] args)
	{
		Scanner sc;
		char tracker[][]; //Jagged array
		int nodes,rows;              
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter the number of NODES :");
			nodes=sc.nextInt();
			System.out.println("Enter number of rows :");
			rows=sc.nextInt();
			tracker=new char[rows][];
			for(int i=0;i<tracker.length;i++)
			{
				System.out.println("Enter number of columns in "+(i+1)+" row : ");
				int columns=sc.nextInt();
				tracker[i]=new char[columns];
				for(int j=0;j<tracker[i].length;j++)
				{	
					System.out.println("Enter an element :");
					tracker[i][j]=sc.next().charAt(0);
				}
			}
			new Breathfirst(tracker,nodes,rows).tracking();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured :");
			e.printStackTrace();
		}
	}
}