package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SumOfDistancesInTree {
    int output[];
    int breathLevel=0;
    List<Integer> queue,visited;
    public SumOfDistancesInTree(){
        queue=new LinkedList<>();
        visited=new LinkedList<>();
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        output=new int[n];
        for(int i=0;i<n;i++)
            output[i]=this.findBFSForEach(i, edges);          
        return output;
    }
    public int findBFSForEach(int element, int[][] edges){
        int result=0;
        queue.add(element);         
        while(!queue.isEmpty()){            
            this.breathFirstSearch(edges);
            if(!queue.isEmpty())
                result+=queue.size()*breathLevel;                
            else
                break;
        }
        queue.clear(); visited.clear(); breathLevel=0;
        return result;
    }
    public void breathFirstSearch(int[][] edges){
        int start=0, end=queue.size();
        breathLevel++;
        while(start<end){
            int poll=queue.get(0);
            if(!visited.contains(poll)){
                visited.add(poll);
                for(int i=0;i<edges.length;i++){
                    if(edges[i][0]==poll && !visited.contains(edges[i][1]))
                        queue.add(edges[i][1]);
                    if(edges[i][1]==poll && !visited.contains(edges[i][0]))
                        queue.add(edges[i][0]);
                }
            }
            start++; queue.remove(0);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] edges;
        try{    
            sc=new Scanner(System.in);
            System.out.println("Enter N Value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of an edges array : ");
            int length=sc.nextInt();
            edges=new int[length][2];
            for(int i=0;i<length;i++){
                edges[i][0]=sc.nextInt();
                edges[i][1]=sc.nextInt();
            }
            System.out.println(new SumOfDistancesInTree().sumOfDistancesInTree(length, edges));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
