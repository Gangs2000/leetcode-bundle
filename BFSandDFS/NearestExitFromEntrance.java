import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NearestExitFromEntrance {
    int steps,value;         
    Map<List<Integer>, Integer> queue;
    boolean flag=false;
    public NearestExitFromEntrance(){
        steps=Integer.MAX_VALUE;
        queue=new LinkedHashMap<>();               
    }
    public int nearestExit(char[][] maze, int[] entrance) {        
        queue.put(List.of(entrance[0], entrance[1]),0);                                                   //Adding initial entrance to queue        
        while(queue.size()!=0){                                          
            List<Integer> list=queue.entrySet().stream().findFirst().get().getKey();                       
            maze[list.get(0)][list.get(1)]='+'; value=queue.get(list)+1; 
            directions(list.get(0), list.get(1), maze);   
            queue.remove(list);                                           
            if(flag)
                break;                                                                                 
        }                 
        return (steps>0 && steps!=Integer.MAX_VALUE)?(steps):(-1);        
    }    
    public void directions(int i, int j, char[][] maze){
        checkConditions(i, j-1, maze);                                    //Left
        checkConditions(i, j+1, maze);                                    //Right
        checkConditions(i-1, j, maze);                                    //Top
        checkConditions(i+1, j, maze);                                    //Bottom                
    }
    public void checkConditions(int i, int j, char[][] maze){                
        if((!flag) && (i>=0 & i<=maze.length-1 && j>=0 && j<=maze[i].length-1) && (maze[i][j]=='.')){                        
            maze[i][j]='+';                                                                                 //Marking it as visited
            if(i==0 || j==0 || i==maze.length-1 || j==maze[i].length-1){
                steps=Math.min(steps, value);                                                               //Finding Min value between current and previous value                    
                flag=true;
            }
            else
                queue.put(List.of(i,j), value);                                                                 
        }
    }
    public static void main(String[] args){
        Scanner sc;
        char[][] maze; int[] entrance;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter maze row and column value : ");
            int row=sc.nextInt();
            int column=sc.nextInt();
            maze=new char[row][column];
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    maze[i][j]=sc.next().charAt(0);
                }
            }
            entrance=new int[2];
            System.out.println("Enter maze entrance values : ");
            entrance[0]=sc.nextInt(); entrance[1]=sc.nextInt();
            System.out.println(new NearestExitFromEntrance().nearestExit(maze, entrance));
        }        
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
