package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MinimumNumberofVerticestoReachAllNodes {
    Set<Integer> result, incomingEdges;
    public MinimumNumberofVerticestoReachAllNodes(){
        result=new HashSet<>();
        incomingEdges=new HashSet<>();
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        for(int i=0;i<edges.size();i++){
            int edge=edges.get(i).get(0);
            int incomingEdge=edges.get(i).get(1);            
            incomingEdges.add(incomingEdge);
            if(result.contains(incomingEdge))
                result.remove((Integer) incomingEdge);
            if(!result.contains(edge) && !incomingEdges.contains(edge))                
                result.add(edge);
        }
        return new LinkedList<>(result);
    }
    public static void main(String[] args){
        Scanner sc;  
        List<List<Integer>> edges;      
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of edges list : ");
            int length=sc.nextInt();
            edges=new LinkedList<>();
            for(int i=0;i<length;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                edges.add(List.of(a,b));
            }
            System.out.println(new MinimumNumberofVerticestoReachAllNodes().findSmallestSetOfVertices(n, edges));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
