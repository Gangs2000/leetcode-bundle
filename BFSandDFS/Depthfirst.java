import java.util.Scanner;
import java.util.ArrayList;
class Depthfirst
{
	char array[][],stack[];
	ArrayList<Character> visited;
	int maxNodes,top=0;
	Depthfirst(char array[][],int rows,int maxNodes)
	{
		this.array=array;
		stack=new char[rows];
		visited=new ArrayList<Character>();
		this.maxNodes=maxNodes;	
	}
	private void tracking()
	{
		if(visited.size()==0 && top==0)
		{
			stack[top]=array[0][0];
			visited.add(array[0][0]);
			tracking();
		}
		else if(visited.size()==maxNodes && top==0)
		{
			System.out.println();
			System.out.println("Output sequence...");
			for(int out=0;out<visited.size();out++)
				System.out.print(visited.get(out)+" ");
		}
		else
		{
			checkChildNodes(stack[top]);
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
						top++;
						stack[top]=array[i][j];
						visited.add(array[i][j]);
						break;	
					}
					else if(j==(array[i].length)-1)
					{
						top--;
						break;
					}
				}
			}
		}
		if(flag)
			top--;
	}
	private boolean isVisited(char val)
	{
		boolean flag=(visited.contains(val))?(true):(false);
		return flag;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		char tracker[][];
		int rows,nodes;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter number of Nodes :");
			nodes=sc.nextInt();
			System.out.println("Enter number of rows :");
			rows=sc.nextInt();
			tracker=new char[rows][];
			for(int i=0;i<tracker.length;i++)
			{
				System.out.println("Enter number of columns in "+(i+1)+" row :");
				int columns=sc.nextInt();	
				tracker[i]=new char[columns];
				for(int j=0;j<tracker[i].length;j++)
				{
					System.out.println("Enter "+(j+1)+" element :");
					tracker[i][j]=sc.next().charAt(0);
				}
			}
			new Depthfirst(tracker,rows,nodes).tracking();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured :"+e);
			e.printStackTrace();
		}
	}
}