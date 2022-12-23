package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PossibleBiPartition {     
    Map<Integer, List<Integer>> adjacentList;
    int[] colors;
    public PossibleBiPartition(){
        adjacentList=new LinkedHashMap<>();
    }      
    public boolean possibleBipartition(int n, int[][] dislikes) {    
        if(dislikes.length!=0){   
            this.findAdjacencyPath(dislikes);                 
            colors=new int[n+1];
            for(int i=1;i<=n;i++){
                if(colors[i]==0){
                    if(this.breathFirstSearch(i, adjacentList, colors)==false)
                        return false;
                }
            }
        }
        return true;
    }
    public boolean breathFirstSearch(int element, Map<Integer, List<Integer>> adjacentList, int[] colors){   
        List<Integer> queue=new LinkedList<>();
        queue.add(element);
        colors[element]=1;              //1 represents color red, 2 represents color green, 0 means empty
        while(!queue.isEmpty()){
            int poll=queue.get(0);
            if(adjacentList.containsKey(poll)){
                List<Integer> adjacentPaths=adjacentList.get(poll);
                for(int value : adjacentPaths){
                    if(colors[poll]==colors[value])
                        return false;
                    if(colors[value]==0){
                        queue.add(value);
                        colors[value]=3-colors[poll];
                    }
                }
            }
            queue.remove(0);
        }
        return true;
    }
    public void findAdjacencyPath(int[][] dislikes){
        for(int i=0;i<dislikes.length;i++){
            this.template(i, 0, dislikes);
            this.template(i, 1, dislikes);
        }
    }
    public void template(int i, int j, int[][] dislikes){        
        if(adjacentList.containsKey(dislikes[i][j])){
            List<Integer> list=adjacentList.get(dislikes[i][j]);
            list.add(dislikes[i][(j==0)?(1):(0)]);
            adjacentList.put(dislikes[i][j], list);
        }                
        else{
            List<Integer> list=new LinkedList<>();
            list.add(dislikes[i][(j==0)?(1):(0)]);
            adjacentList.put(dislikes[i][j], list);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] dislikes;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of dislikes array : ");
            int length=sc.nextInt();
            dislikes=new int[length][2];
            for(int i=0;i<length;i++){
                dislikes[i][0]=sc.nextInt();
                dislikes[i][1]=sc.nextInt();
            }
            System.out.println(new PossibleBiPartition().possibleBipartition(n, dislikes));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
