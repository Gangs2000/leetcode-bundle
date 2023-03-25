import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountUnreachablePairsofNodesinanUndirectedGraph {
    private long totalUnReachableNodes=0;    
    List<Integer> queue;
    Map<Integer, List<Integer>> adjMap;
    boolean[] visited;
    public CountUnreachablePairsofNodesinanUndirectedGraph(){
        queue=new LinkedList<>();
        adjMap=new LinkedHashMap<>();
    }
    public long countPairs(int n, int[][] edges) {
        visited=new boolean[n+1];        
        Arrays.fill(visited, false);
        this.createAdjacentList(edges);  
        long reminingNodes=n;      
        for(int i=0;i<n;i++){
            long getNodeCount=0;
            if(!visited[i]) {         
                visited[i]=true;       
                getNodeCount=this.breathFirstSearch(i, visited);
                totalUnReachableNodes+=getNodeCount*(reminingNodes-getNodeCount);                
                reminingNodes-=getNodeCount;                
            }
        }
        return totalUnReachableNodes;        
    }
    public long breathFirstSearch(int node, boolean[] visited){
        long countNodes=1;
        queue.add(node);        
        while(!queue.isEmpty()){
            int front=queue.get(0);            
            if(adjMap.containsKey(front)){
                List<Integer> childNodes=adjMap.get(front);
                for(int childNode : childNodes){
                    if(!visited[childNode]){
                        visited[childNode]=true;
                        queue.add(childNode);
                        countNodes++;
                    }
                }
            }
            queue.remove(0);
        }
        return countNodes;   
    }
    public void createAdjacentList(int[][] edges){
        for(int i=0;i<edges.length;i++){
            this.template(edges[i][0], edges[i][1]);
            this.template(edges[i][1], edges[i][0]);
        }
    }
    public void template(int a, int b){
        List<Integer> list;
        if(adjMap.containsKey(a))
            list=adjMap.get(a);            
        else
            list=new LinkedList<>();
        list.add(b);
        adjMap.put(a, list);
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] edges;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of edges array : ");
            int length=sc.nextInt();
            edges=new int[length][2];
            for(int i=0;i<length;i++){
                edges[i][0]=sc.nextInt();
                edges[i][1]=sc.nextInt();
            }
            System.out.println(new CountUnreachablePairsofNodesinanUndirectedGraph().countPairs(n, edges));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
