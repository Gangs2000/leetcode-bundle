import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MinimumScoreOfAPathBetweenCities {
    int minimumDistance=Integer.MAX_VALUE;
    Map<Integer, List<List<Integer>>> adjacencyList;    
    List<Integer> queue;
    public MinimumScoreOfAPathBetweenCities(){
        adjacencyList=new LinkedHashMap<>();
        queue=new LinkedList<>();        
    }
    public int minScore(int n, int[][] roads) {        
        boolean[] visited=new boolean[n+1];
        this.createAdjacencyList(roads);        
        queue.add(1); 
        while(!queue.isEmpty()){
            int src=queue.get(0);
            this.breathFirstSearch(src, adjacencyList, visited);
            queue.remove(0);            
        }
        return minimumDistance;
    }
    public void breathFirstSearch(int source, Map<Integer, List<List<Integer>>> adjacencyList, boolean[] visited){
        List<List<Integer>> values=adjacencyList.get(source);        
        for(List<Integer> list : values){            
            int child=list.get(0);
            int distance=list.get(1);
            minimumDistance=Math.min(minimumDistance, distance);
            if(!visited[child]){                
                visited[child]=true;
                queue.add(child);
            }
        }
    }
    public void createAdjacencyList(int[][] roads){
        for(int i=0;i<roads.length;i++){
            int src=roads[i][0];
            int dest=roads[i][1];
            int distance=roads[i][2];
            if(adjacencyList.containsKey(src)){
                List<List<Integer>> list=adjacencyList.get(src);                
                list.add(List.of(dest, distance));
                adjacencyList.put(src, list);
            }
            else {
                List<List<Integer>> list=new LinkedList<>();
                list.add(List.of(dest, distance));
                adjacencyList.put(src, list);
            }

            if(adjacencyList.containsKey(dest)){
                List<List<Integer>> list=adjacencyList.get(dest);
                list.add(List.of(src, distance));
                adjacencyList.put(dest, list);
            }
            else{
                List<List<Integer>> list=new LinkedList<>();
                list.add(List.of(src, distance));
                adjacencyList.put(dest, list);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] roads;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of roads array : ");
            int length=sc.nextInt();
            roads=new int[length][3];
            for(int i=0;i<length;i++){
                roads[i][0]=sc.nextInt();
                roads[i][1]=sc.nextInt();
                roads[i][2]=sc.nextInt();                
            }
            System.out.println(new MinimumScoreOfAPathBetweenCities().minScore(n, roads));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
