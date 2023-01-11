import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumTimetoCollectAllApples {
    Map<Integer, List<Integer>> adj;
    public MinimumTimetoCollectAllApples(){
        adj=new LinkedHashMap<>();
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for(int i=0;i<edges.length;i++){
            if(adj.containsKey(edges[i][0])){
                List<Integer> list=adj.get(edges[i][0]);
                list.add(edges[i][1]);
                adj.put(edges[i][0], list);
            }
            else{
                List<Integer> list=new LinkedList<>();
                list.add(edges[i][1]);
                adj.put(edges[i][0], list);
            }

            if(adj.containsKey(edges[i][1])){
                List<Integer> list=adj.get(edges[i][1]);
                list.add(edges[i][0]);
                adj.put(edges[i][1], list);
            }
            else{
                List<Integer> list=new LinkedList<>();
                list.add(edges[i][0]);
                adj.put(edges[i][1], list);
            }
        }        
        return depthFirstSearch(adj, 0, -1, hasApple);
    }
    public int depthFirstSearch(Map<Integer, List<Integer>> adj, int currentNode, int parentNode, List<Boolean> hasApples){
        int time=0;
        for(Integer child : adj.get(currentNode)){
            if(currentNode==parentNode)
                continue;
            int valueFromChild=depthFirstSearch(adj, child, currentNode, hasApples);
            if(valueFromChild>0 || hasApples.get(child))
                time+=valueFromChild+2;
        }
        return time;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Boolean> hasApples;
        int[][] edges; 
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter nodes value : ");
            int nodes=sc.nextInt();            
            System.out.println("Enter length of edges of array : ");
            int edgesLength=sc.nextInt();
            edges=new int[edgesLength][2];
            for(int i=0;i<edges.length;i++){
                edges[i][0]=sc.nextInt();
                edges[i][1]=sc.nextInt();
            }
            hasApples=new LinkedList<>();
            System.out.println("Enter apples array value : ");
            for(int i=0;i<nodes;i++)
                hasApples.add(sc.nextBoolean());
            System.out.println(new MinimumTimetoCollectAllApples().minTime(nodes, edges, hasApples));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
