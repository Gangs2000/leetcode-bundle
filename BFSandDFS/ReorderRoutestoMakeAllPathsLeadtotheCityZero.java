import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    int minimumReorder=0;
    List<List<Integer>> queue;
    Map<Integer, List<List<Integer>>> adjcMap;
    public ReorderRoutestoMakeAllPathsLeadtotheCityZero(){
        adjcMap=new LinkedHashMap<>();
        queue=new LinkedList<>();
    }
    public int minReorder(int n, int[][] connections) {
        this.createAdjacencyList(connections);
        depthFirstSearch(0, -1, adjcMap);
        return minimumReorder;
    }
    public void depthFirstSearch(int child, int parent, Map<Integer, List<List<Integer>>> adjcMap){
        List<List<Integer>> list=adjcMap.get(child);
        for(List<Integer> childLists : list){
            int value=childLists.get(0);
            if(value!=parent){            
                if(childLists.get(1)==1)
                    minimumReorder++;
                depthFirstSearch(value, child, adjcMap);
            }
        }
    }
    public void createAdjacencyList(int[][] connections){
        for(int i=0;i<connections.length;i++){
            int source=connections[i][0];
            int destination=connections[i][1];
            this.template(source, destination, 1);
            this.template(destination, source, 0);            
        }
    }
    public void template(int a, int b, int value){
        if(adjcMap.containsKey(a)){
            List<List<Integer>> list=adjcMap.get(a);
            list.add(List.of(b, value));
            adjcMap.put(a, list);
        }
        else{
            List<List<Integer>> list=new LinkedList<>();
            list.add(List.of(b, value));
            adjcMap.put(a, list);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] connections;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of connections array : ");
            int length=sc.nextInt();
            connections=new int[length][2];
            for(int i=0;i<length;i++){
                connections[i][0]=sc.nextInt();
                connections[i][1]=sc.nextInt();
            }
            System.out.println(new ReorderRoutestoMakeAllPathsLeadtotheCityZero().minReorder(n, connections));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
