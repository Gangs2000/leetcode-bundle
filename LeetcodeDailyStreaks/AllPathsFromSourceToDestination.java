package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToDestination {
    List<List<Integer>> output;
    public AllPathsFromSourceToDestination(){
        output=new LinkedList<>();
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list=new LinkedList<>();
        list.add(0);                                                                                //Adding 0 since we have to find all paths from 0 to n-1
        findAllPathsFromSourceToTarget(0, graph, graph.length-1, list);
        return output;        
    }
    public void findAllPathsFromSourceToTarget(int source, int[][] graph, int destination, List<Integer> list){                       
        if(source==destination){                        
            output.add(new LinkedList<>(list));
            return ;
        }
        for(int i=0;i<graph[source].length;i++){
            list.add(graph[source][i]);                
            findAllPathsFromSourceToTarget(graph[source][i], graph, destination, list);                        
            list.remove(list.size()-1);
        }                
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] graph;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of graph array : ");
            int length=sc.nextInt();
            graph=new int[length][];
            for(int i=0;i<length;i++){
                System.out.println("Enter length of column in "+(i+1)+" row : ");
                int colLength=sc.nextInt();
                graph[i]=new int[colLength];
                for(int j=0;j<colLength;j++)
                    graph[i][j]=sc.nextInt();
            }
            System.out.println(new AllPathsFromSourceToDestination().allPathsSourceTarget(graph));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
