import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CheapestFlightsWithInKStops {
    Map<Integer, List<List<Integer>>> adjacentMap;
    List<List<Integer>> queue;    
    int[] costArray;
    public CheapestFlightsWithInKStops(){
        adjacentMap=new LinkedHashMap<>();
        queue=new LinkedList<>();
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int steps=-1;
        costArray=new int[n];
        Arrays.fill(costArray, Integer.MAX_VALUE);
        for(int i=0;i<flights.length;i++){
            if(adjacentMap.containsKey(flights[i][0])){
                List<List<Integer>> list=adjacentMap.get(flights[i][0]);
                list.add(List.of(flights[i][1], flights[i][2]));
                adjacentMap.put(flights[i][0], list);
            }
            else{
                List<List<Integer>> list=new LinkedList<>();
                list.add(List.of(flights[i][1], flights[i][2]));
                adjacentMap.put(flights[i][0], list);
            }
        }
        //BFS queue starts here
        queue.add(List.of(src, 0));
        costArray[src]=0;
        while(!queue.isEmpty() && steps<k){
            int queueSize=queue.size();
            while(queueSize!=0){
                int node=queue.get(0).get(0);
                int cost=queue.get(0).get(1);                                    
                if(adjacentMap.containsKey(node)){                        
                    List<List<Integer>> list=adjacentMap.get(node);                                                
                    for(int i=0;i<list.size();i++){
                        int currentNode=list.get(i).get(0);
                        int currentCost=list.get(i).get(1);
                        if(costArray[currentNode]>cost+currentCost){
                            costArray[currentNode]=cost+currentCost;
                            queue.add(List.of(currentNode, cost+currentCost));
                        }
                    }                                 
                }  
                queue.remove(0); 
                queueSize--;
            }
            steps++;        
        }        
        return (costArray[dst]==Integer.MAX_VALUE)?(-1):(costArray[dst]);        
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] flights;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of Nodes : ");
            int n=sc.nextInt();
            System.out.println("Enter length of flights array : ");
            int length=sc.nextInt();
            flights=new int[length][3];
            for(int i=0;i<length;i++){
                flights[i][0]=sc.nextInt();
                flights[i][1]=sc.nextInt();
                flights[i][2]=sc.nextInt();                
            }
            System.out.println("Enter source, destination and K value : ");
            int source=sc.nextInt();
            int destination=sc.nextInt();
            int k=sc.nextInt();
            System.out.println(new CheapestFlightsWithInKStops().findCheapestPrice(n, flights, source, destination, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
