import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class NumberofWaystoArriveatDestination {
    Map<Integer, List<Integer>> adjMap;
    Map<List<Integer>, Integer> minutesMap;      
    int[] destArr, waysArr ;
    final int MOD=1000000007;
    public NumberofWaystoArriveatDestination(){
        adjMap=new HashMap<>();
        minutesMap=new HashMap<>();        
    }
    public int countPaths(int n, int[][] roads) {
        destArr=new int[n];
        waysArr=new int[n];
        Arrays.fill(destArr, Integer.MAX_VALUE);
        Arrays.fill(waysArr, 0);
        for(int i=0;i<roads.length;i++){
            int x=roads[i][0];
            int y=roads[i][1];
            adjacencyMap(x, y);
            adjacencyMap(y, x);
            minutesMap.put(List.of(x, y), roads[i][2]);
            minutesMap.put(List.of(y, x), roads[i][2]);
        }
        dijkstrasAlgorithm(0, n-1, destArr, waysArr);
        return waysArr[n-1];
    }
    public void dijkstrasAlgorithm(int start, int end, int[] destArr, int[] waysArr){
        PriorityQueue<List<Integer>> queue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> arg0, List<Integer> arg1) {
                return arg0.get(1).compareTo(arg1.get(1));
            }            
        });
        destArr[start]=0;
        waysArr[start]=1;
        queue.add(List.of(start, 0));        
        while(!queue.isEmpty()){
            List<Integer> list=queue.poll();
            int source=list.get(0);
            int currentMinute=list.get(1);
            if(adjMap.containsKey(source)){
                List<Integer> values=adjMap.get(source);
                for(int destination : values){
                    int minute=minutesMap.get(List.of(source, destination));                        
                    if(destArr[destination]>(currentMinute+minute)){                        
                        destArr[destination]=currentMinute+minute;
                        queue.add(List.of(destination, currentMinute+minute));
                        waysArr[destination]=waysArr[source];
                    }
                    else if(currentMinute+minute==destArr[destination])
                        waysArr[destination]=(waysArr[destination]+waysArr[source])%MOD;
                }
            }            
        }
    }
    public void adjacencyMap(int i, int j){
        adjMap.putIfAbsent(i, new LinkedList<>());
        List<Integer> list=adjMap.get(i);
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
            System.out.println("Enter length roads array : ");
            int length=sc.nextInt();
            roads=new int[length][3];
            for(int i=0;i<length;i++){
                roads[i][0]=sc.nextInt();
                roads[i][1]=sc.nextInt();
                roads[i][2]=sc.nextInt();
            }
            System.out.println(new NumberofWaystoArriveatDestination().countPaths(n, roads));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
