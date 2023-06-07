import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DetonatetheMaximumBombs {
    Map<Integer, List<Integer>> adjMap;
    Set<Integer> visited;
    List<Integer> queue;
    public DetonatetheMaximumBombs(){
        adjMap=new HashMap<>();
        queue=new LinkedList<>();
        visited=new HashSet<>();
    }
    public int maximumDetonation(int[][] bombs) {
        for(int i=0;i<bombs.length;i++){
            for(int j=0;j<bombs.length;j++){
                if(i==j)
                    continue;
                long x1=bombs[i][0];
                long y1=bombs[i][1];
                long radius=bombs[i][2];
                long x2=bombs[j][0];
                long y2=bombs[j][1];                
                long distance=((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
                if((long) (radius*radius)>=distance){
                    adjMap.putIfAbsent(i, new LinkedList<>());
                    List<Integer> list=adjMap.get(i);
                    list.add(j);
                    adjMap.put(i, list);
                }
            }
        }        
        int result=0;        
        for(int i=0;i<bombs.length;i++){
            result=Math.max(result, bfs(i, visited, adjMap));
            visited.clear();
        }
        return result;
    }
    public int bfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> adjMap){               
        visited.add(node); 
        queue.add(node);
        while(!queue.isEmpty()){                        
            int getNode=queue.get(0);
            if(adjMap.containsKey(getNode)){
                List<Integer> list=adjMap.get(getNode);
                for(int bomb : list){
                    if(!visited.contains(bomb)){
                        visited.add(bomb);
                        queue.add(bomb);                        
                    }
                }
            }
            queue.remove(0);
        }            
        return visited.size();
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] bombs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of bombs : ");
            int bombCount=sc.nextInt();
            bombs=new int[bombCount][3];
            for(int i=0;i<bombCount;i++){
                bombs[i][0]=sc.nextInt();
                bombs[i][1]=sc.nextInt();
                bombs[i][2]=sc.nextInt();
            }
            System.out.println(new DetonatetheMaximumBombs().maximumDetonation(bombs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

