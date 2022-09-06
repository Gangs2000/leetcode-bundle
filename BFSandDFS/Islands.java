import java.util.Scanner;
class Islands
{
    int numOfIslands=0;
    private int countIslands(int grid[][])
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    numOfIslands++;
                    grid[i][j]=2;
                    directions(i,j,grid);
                }
            }
        }
        return numOfIslands;
    }
    private void directions(int i,int j,int grid[][])
    {
        tracking(i,j-1,grid);      //Left 
        tracking(i,j+1,grid);      //Right
        tracking(i-1,j,grid);      //Top
        tracking(i+1,j,grid);      //Bottom
    }
    private void tracking(int x,int y,int grid[][])
    {
        if((x>=0 && x<=grid.length-1) && (y>=0 && y<=(grid[x].length)-1))     //Setting limit to ignore outer bound values ( 0<=x,y<=n )
        {
            if(grid[x][y]==1)
            {
                grid[x][y]=2;
                directions(x,y,grid);    //Recursion to mark all directions as visitedd
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc;
        int row=0,col=0;
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter row and column values : ");
            row=sc.nextInt();
            col=sc.nextInt();
            int grid[][]=new int[row][col];
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                {
                    int value=sc.nextInt();
                    if(value==0 || value==1)
                        grid[i][j]=value;
                    else
                        throw new Exception("Value must be either 0 or 1..");
                }
            }
            System.out.println("Number of Islands : "+new Islands().countIslands(grid));
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}