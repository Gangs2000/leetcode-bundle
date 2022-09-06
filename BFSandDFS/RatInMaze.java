import java.util.Scanner;
class RatInMaze
{
    boolean flag=true,goal=true;
    private void solvedMaze(int maze[][])
    {
        maze[0][0]=2;                                                     //Initialize starting point
        directions(0,0,maze);
        if(goal)                                                          //If goal value is true even after executing algotithm which means no path found to destination
            System.out.println("No path has been found to destionation..");
    }
    private void directions(int i,int j,int maze[][])                     //Top and Right directions are enough since every will be always either right or bottom
    {
        tracking(i+1,j,maze);      //Bottom direction
        tracking(i,j+1,maze);      //Right direction
    }
    private void tracking(int i,int j,int maze[][])
    {
        if((i>=0 && i<maze.length) && (j>=0 && j<maze.length))             //Setting array limit bound.. Condition checking for outer bound of an array
        {
            if(maze[i][j]==1)
            {
                maze[i][j]=2;
                if(i==maze.length-1 && j==maze.length-1)
                {
                    goal=false;                                            //Changing goal value as false since it found desitnation
                    maze=setallonestozero(maze);                           //Calling method to change all 1 as 0
                    System.out.println();
                    printSolvedMaze(maze);                                 //Calling method to print solved maze
                }
                else              
                {
                    int val1=i,val2=j;                                     //Storing value to change it as 0 if no adjacent values found
                    directions(i,j,maze);
                    if(flag)
                        maze[val1][val2]=0;                                //Setting current pointer as 0
                }
            }
        }
    }
    private int[][] setallonestozero(int maze[][])
    {
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[i].length;j++)
            {
                if(maze[i][j]==1)
                    maze[i][j]=0;                                        //Changing all 1's to 0 after executing algorithm
                else if(maze[i][j]==2)
                    maze[i][j]=1;
            }
        }
        return maze;
    }
    private void printSolvedMaze(int maze[][])
    {
        System.out.println("Rat has been reached it's destination...");
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[i].length;j++)
            {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int maze[][],size=0;
        Scanner sc;
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter the size of an maze : ");
            size=sc.nextInt();
            maze=new int[size][size];
            for(int i=0;i<size;i++)
                for(int j=0;j<size;j++)
                    maze[i][j]=sc.nextInt();
            new RatInMaze().solvedMaze(maze);    
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}