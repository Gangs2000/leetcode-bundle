package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberOfNodesInSubTreeWithSameLabels {
    int[] result;
    Map<Character, Integer> mapper;
    Map<Integer, List<Integer>> adjacentMap;
    public NumberOfNodesInSubTreeWithSameLabels(){
        mapper=new LinkedHashMap<>();
        adjacentMap=new LinkedHashMap<>();
        //Initializing all characters with count 0
        for(char letter='a'; letter<='z'; letter++)
            mapper.put(letter, 0);
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        result=new int[n];
        for(int i=0;i<edges.length;i++){
            if(adjacentMap.containsKey(edges[i][0])){
                List<Integer> tempList=adjacentMap.get(edges[i][0]);
                tempList.add(edges[i][1]);
                adjacentMap.put(edges[i][0], tempList);
            }
            else{
                List<Integer> list=new LinkedList<>();
                list.add(edges[i][1]);
                adjacentMap.put(edges[i][0], list);
            }       
            
            if(adjacentMap.containsKey(edges[i][1])){
                List<Integer> tempList=adjacentMap.get(edges[i][1]);
                tempList.add(edges[i][0]);
                adjacentMap.put(edges[i][1], tempList);
            }
            else{
                List<Integer> list=new LinkedList<>();
                list.add(edges[i][0]);
                adjacentMap.put(edges[i][1], list);
            }
        }
        depthFirstSearch(adjacentMap, mapper, 0, -1, labels);
        return result;
    }
    public void depthFirstSearch(Map<Integer, List<Integer>> adjacentMap, Map<Character, Integer> mapper, int current, int parent, String labels){
        char label=labels.charAt(current);
        int beforeVisiting=mapper.get(label);
        mapper.put(label, mapper.get(label)+1);
        for(int child : adjacentMap.get(current)){
            if(child==parent)
                continue;
            depthFirstSearch(adjacentMap, mapper, child, current, labels);
        }
        int afterVisiting=mapper.get(label);
        result[current]=afterVisiting-beforeVisiting;
    }
    public static void main(String[] args){
        Scanner sc;        
        int[][] edges;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of nodes value : ");
            int nodes=sc.nextInt();
            System.out.println("Enter length of edges count : ");
            int length=sc.nextInt();
            edges=new int[length][2];
            for(int i=0;i<length;i++){
                edges[i][0]=sc.nextInt();
                edges[i][1]=sc.nextInt();
            }
            System.out.println("Enter label : ");
            String labels=sc.next();
            System.out.println(new NumberOfNodesInSubTreeWithSameLabels().countSubTrees(nodes, edges, labels));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
