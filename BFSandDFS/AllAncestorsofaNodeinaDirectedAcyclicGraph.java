import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AllAncestorsofaNodeinaDirectedAcyclicGraph {
    List<List<Integer>> resultList;
    Map<Integer, List<Integer>> adjacentMapper;
    Set<Integer> visited;
    public AllAncestorsofaNodeinaDirectedAcyclicGraph(){
        resultList=new LinkedList<>();
        adjacentMapper=new HashMap<>();
        visited=new HashSet<>();
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        this.findAdjacentOfEdge(edges);
        for(int node=0;node<n;node++){
            if(adjacentMapper.containsKey(node)){
                visited.add(node);
                resultList.add(this.breathFirstSearch(new LinkedList<>(adjacentMapper.get(node))));
            }
            else
                resultList.add(new LinkedList<>());
            //Reset Visited Set for each iteration
            visited.clear();
        }
        return resultList;
    }
    public void findAdjacentOfEdge(int[][] edges){
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0], v=edges[i][1];
            List<Integer> list=(adjacentMapper.containsKey(v)?(adjacentMapper.get(v)):(new LinkedList<>()));
            list.add(u);
            adjacentMapper.put(v, list);
        }
    }
    public List<Integer> breathFirstSearch(List<Integer> queue){
        Set<Integer> result=new TreeSet<>();
        result.addAll(queue);
        while(!queue.isEmpty()){
            int currentNode=queue.get(0);
            result.add(currentNode);
            if(!visited.contains(currentNode)){
                if(adjacentMapper.containsKey(currentNode)){
                    for(int adjacentValues : adjacentMapper.get(currentNode)){
                        if(!visited.contains(adjacentValues))
                            queue.add(adjacentValues);
                    }
                }
                else
                    queue.add(currentNode);
                visited.add(currentNode);
            }
            queue.remove(0);
        }
        return new LinkedList<>(result);
    }
    public static void main(String[] args) {
        Scanner sc;
        int[][] edgeList;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of an edgeList array : ");
            int length=sc.nextInt();
            edgeList=new int[length][2];
            for(int i=0;i<length;i++){
                edgeList[i][0]=sc.nextInt();
                edgeList[i][1]=sc.nextInt();
            }
            System.out.println(new AllAncestorsofaNodeinaDirectedAcyclicGraph().getAncestors(n, edgeList));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
