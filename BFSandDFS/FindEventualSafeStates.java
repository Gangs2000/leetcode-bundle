import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindEventualSafeStates {
    boolean[] visitedNodes, cycleDetection;   
    List<Integer> resulList;
    public FindEventualSafeStates(){
        resulList=new LinkedList<>();
    } 
    public List<Integer> eventualSafeNodes(int[][] graph) {
        visitedNodes=new boolean[graph.length];
        cycleDetection=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visitedNodes[i])
                isCycleFormedByGraph(i, graph, visitedNodes, cycleDetection);            
        }
        for(int i=0;i<graph.length;i++){
            if(!cycleDetection[i])
                resulList.add(i);
        }            
        return resulList;
    }
    public boolean isCycleFormedByGraph(int node, int[][] graph, boolean[] visitedNodes, boolean[] cycleDetection){
        visitedNodes[node]=true;
        cycleDetection[node]=true;
        for(int child : graph[node]){
            if(!visitedNodes[child] && isCycleFormedByGraph(child, graph, visitedNodes, cycleDetection))
                return true;
            else if(cycleDetection[child])
                return true;
        }        
        cycleDetection[node]=false;
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] graphs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of graphs array : ");
            int outerLength=sc.nextInt();
            graphs=new int[outerLength][];
            for(int i=0;i<outerLength;i++){
                System.out.println("Enter length of "+i+" index array : ");
                int innerLength=sc.nextInt();
                int[] subArray=new int[innerLength];
                for(int j=0;j<innerLength;j++)
                    subArray[j]=sc.nextInt();
                graphs[i]=subArray;
            }
            System.out.println(new FindEventualSafeStates().eventualSafeNodes(graphs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
