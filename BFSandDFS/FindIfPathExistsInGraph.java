import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindIfPathExistsInGraph {
    List<Integer> queue, visitedNode;    
    public FindIfPathExistsInGraph(){
        queue=new LinkedList<>();
        visitedNode=new LinkedList<>();
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
        else{
            visitedNode.add(source);
            for(int i=0;i<edges.length;i++){
                if(edges[i][0]==source || edges[i][1]==source)
                    queue.add((edges[i][0]==source)?(edges[i][1]):(edges[i][0]));
            }
            while(queue.size()!=0){
                int element=queue.get(0);
                if(element==destination)
                    return true;
                breathFirstSearch(element, edges);
                if(queue.size()!=0)
                    queue.remove(0);
            }
        }
        return false;
    }
    public void breathFirstSearch(int element, int[][] edges){
        if(!visitedNode.contains(element)){
            visitedNode.add(element);
            for(int i=0;i<edges.length;i++){
                if(edges[i][0]==element && !(visitedNode.contains(edges[i][1])))
                    queue.add(edges[i][1]);
                if(edges[i][1]==element && !(visitedNode.contains(edges[i][0])))
                    queue.add(edges[i][0]);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] grid;
        int source, destination;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of grid : ");
            int length=sc.nextInt();
            grid=new int[length][];
            for(int i=0;i<length;i++){
                grid[i][0]=sc.nextInt();
                grid[i][1]=sc.nextInt();
            }
            System.out.println("Enter source and destination : ");
            source=sc.nextInt(); destination=sc.nextInt();
            System.out.println(new FindIfPathExistsInGraph().validPath(length, grid, source, destination));
        }
        catch(Exception e){
            System.out.println("Exception occured : ");
            e.printStackTrace();
        }
    }    
}
