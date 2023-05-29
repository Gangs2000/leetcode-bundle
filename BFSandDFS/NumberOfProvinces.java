import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NumberOfProvinces {
    Map<Integer, List<Integer>> connections;
    List<Integer> queue;
    boolean[] visited;
    public NumberOfProvinces(){
        connections=new HashMap<>();
        queue=new LinkedList<>();
    }
    public int findCircleNum(int[][] isConnected) {       
        visited=new boolean[isConnected.length];
        Arrays.fill(visited, false); 
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){                
                if(i==j && isConnected[i][j]==1){     
                    if(connections.containsKey(i))
                        connections.put(i, connections.get(i));
                    else
                        connections.put(i, new LinkedList<>());
                }
                if(i==j)
                    continue;
                if(isConnected[i][j]==1){             
                    findConnections(i,j);                
                    findConnections(j,i);
                }
            }
        }                     
        return breathFirstSearch(connections);        
    }
    public int breathFirstSearch(Map<Integer, List<Integer>> connections){
        int countUnVisited=0;
        for(int key : connections.keySet()){
            if(!visited[key]){
                visited[key]=true;
                countUnVisited++;
                queue.add(key);
                while(!queue.isEmpty()){      
                    int fetchFirst=queue.get(0);              
                    List<Integer> list=connections.get(fetchFirst);
                    for(int city : list){
                        if(!visited[city]){
                            visited[city]=true;
                            queue.add(city);
                        }
                    }
                    queue.remove(0);
                }
            }
        }        
        return countUnVisited;
    }
    public void findConnections(int key, int value){
        if(connections.containsKey(key)){
            List<Integer> list=connections.get(key);
            if(!list.contains(value))
                list.add(value);
            connections.put(key, list);
        }
        else {
            List<Integer> list=new LinkedList<>();
            list.add(value);
            connections.put(key, list);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] cities;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of cities : ");
            int n=sc.nextInt();
            cities=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    cities[i][j]=sc.nextInt();
                }
            }
            System.out.println(new NumberOfProvinces().findCircleNum(cities));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
