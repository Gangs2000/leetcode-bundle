import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MaximalNetworkRank {
    int maxNetworkRank=0;
    Map<Integer, List<Integer>> adjMap;
    public MaximalNetworkRank(){
        adjMap=new HashMap<>();
    }
    public int maximalNetworkRank(int n, int[][] roads) {
        for(int i=0;i<roads.length;i++){
            findAdjacentNodes(roads[i][0], roads[i][1]);
            findAdjacentNodes(roads[i][1], roads[i][0]);
        }        
        findMaxNetworkRank(n, adjMap);
        return maxNetworkRank;
    }
    public void findMaxNetworkRank(int n, Map<Integer, List<Integer>> adjMap){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(adjMap.containsKey(i) && adjMap.containsKey(j)){   
                    int countEdges=adjMap.get(i).size(), commonEdges=0;                                        
                    List<Integer> list=adjMap.get(j);
                    for(int number : list)
                        commonEdges=(number==i)?(commonEdges+1):(commonEdges);
                    maxNetworkRank=Math.max(maxNetworkRank, countEdges+(list.size())-commonEdges);
                }
            }
        }
    }
    public void findAdjacentNodes(int i, int j){     
        List<Integer> list;   
        if(adjMap.containsKey(i))
            list=adjMap.get(i);
        else
            list=new LinkedList<>();            
        list.add(j);
        adjMap.put(i, list);
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
            roads=new int[length][2];
            for(int i=0;i<length;i++){
                roads[i][0]=sc.nextInt();
                roads[i][1]=sc.nextInt();
            }
            System.out.println(new MaximalNetworkRank().maximalNetworkRank(n, roads));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
