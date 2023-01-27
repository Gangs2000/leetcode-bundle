import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindClosestNodeToGiven2Nodes {
    int[] distance1, distance2;
    boolean[] visited1, visited2;
    public void breathFirstSearch(int[] edges, int node, int[] distance, boolean[] visited){
        List<Integer> queue=new LinkedList<>();
        visited[node]=true;
        distance[node]=0;
        queue.add(node);
        while(!queue.isEmpty()){
            int front=queue.get(0);            
            int nextNode=edges[front];
            if(nextNode!=-1 && !visited[nextNode]){
                visited[nextNode]=true;
                distance[nextNode]=1+distance[front];
                queue.add(nextNode);
            }
            queue.remove(0);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        distance1=new int[edges.length];
        distance2=new int[edges.length];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        Arrays.fill(distance2, Integer.MAX_VALUE);
        visited1=new boolean[edges.length];
        visited2=new boolean[edges.length];
        Arrays.fill(visited1, false);
        Arrays.fill(visited2, false);
        breathFirstSearch(edges, node1, distance1, visited1);
        breathFirstSearch(edges, node2, distance2, visited2);
        int minimumDistanceNode=-1;
        int minimumDistanceTillNow=Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            int maxDistance=Math.max(distance1[i], distance2[i]);            
            if(minimumDistanceTillNow>maxDistance){
                minimumDistanceTillNow=maxDistance;                
                minimumDistanceNode=i;                
            }
        }
        return minimumDistanceNode;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] edges;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of edges array : ");
            int length=sc.nextInt();
            edges=new int[length];
            for(int i=0;i<length;i++)
                edges[i]=sc.nextInt();
            System.out.println("Enter Node-1 and Node-2 values : ");
            int node1=sc.nextInt();
            int node2=sc.nextInt();
            System.out.println(new FindClosestNodeToGiven2Nodes().closestMeetingNode(edges, node1, node2));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
