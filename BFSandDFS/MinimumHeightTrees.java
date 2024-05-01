import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MinimumHeightTrees {
    int minimumHeight=Integer.MAX_VALUE;
    Map<Integer, List<Integer>> resultMapper, edgeMapper;
    public MinimumHeightTrees(){
        resultMapper=new HashMap<>();
        edgeMapper=new HashMap<>();
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length==0)
            return Arrays.asList(0);
        //Find Edges of all Nodes
        for(int i=0;i<edges.length;i++){
            this.findEdgesOfAllNodes(edges[i][0], edges[i][1]);
            this.findEdgesOfAllNodes(edges[i][1], edges[i][0]);
        }
        //Find level for each Nodes using Breath First Search
        for(int i=0;i<n;i++){
            int level=this.breathFirstSearch(i);
            minimumHeight=Math.min(minimumHeight, level);
            List<Integer> nodes=(resultMapper.containsKey(level))?(resultMapper.get(level)):(new LinkedList<>());
            nodes.add(i);
            resultMapper.put(level, nodes);
        }
        return resultMapper.get(minimumHeight);
    }
    public void findEdgesOfAllNodes(int key, int value){
        List<Integer> list=(edgeMapper.containsKey(key))?(edgeMapper.get(key)):(new LinkedList<>());
        list.add(value);
        edgeMapper.put(key, list);
    }
    public int breathFirstSearch(int currentNode){
        List<List<Integer>> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        int level=Integer.MIN_VALUE;
        queue.add(Arrays.asList(currentNode, 0));
        visited.add(currentNode);
        while (!queue.isEmpty()) {
            List<Integer> frontNode=queue.get(0);
            if(edgeMapper.containsKey(frontNode.get(0))){
                List<Integer> nextNodeList=edgeMapper.get(frontNode.get(0));
                for(int nextNode : nextNodeList){
                    if(!visited.contains(nextNode)){
                        visited.add(nextNode);
                        queue.add(Arrays.asList(nextNode, frontNode.get(1)+1));
                    }
                }
                level=Math.max(level, frontNode.get(1));
                queue.remove(0);
            }
        }
        return level;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[][] edges;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of edges value : ");
            int length=sc.nextInt();
            edges=new int[length][2];
            for(int i=0;i<length;i++){
                edges[i][0]=sc.nextInt();
                edges[i][1]=sc.nextInt();
            }
            System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
