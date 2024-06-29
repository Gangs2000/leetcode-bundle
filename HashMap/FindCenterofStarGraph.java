import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindCenterofStarGraph {
    int centerOfStarGraph=0, maxFreqTillNow=Integer.MIN_VALUE;
    Map<Integer, Integer> frequencyMapperToFindCenter;
    public FindCenterofStarGraph(){
        frequencyMapperToFindCenter=new HashMap<>();
    }
    public int findCenter(int[][] edges) {
        for(int i=0;i<edges.length;i++){
            this.mapEdgeValues(edges[i][0], edges[i][1]);
            this.mapEdgeValues(edges[i][1], edges[i][0]);
        }
        return centerOfStarGraph;
    }
    private void mapEdgeValues(int key, int value){
        frequencyMapperToFindCenter.putIfAbsent(key, 0);
        frequencyMapperToFindCenter.put(key, frequencyMapperToFindCenter.get(key)+1);
        if(frequencyMapperToFindCenter.get(key)>=maxFreqTillNow){
            maxFreqTillNow=frequencyMapperToFindCenter.get(key);
            centerOfStarGraph=key;
        }
    }
    public static void main(String[] args) {
        Scanner sc;
        int[][] edges;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of an edges array : ");
            int length=sc.nextInt();
            edges=new int[length][2];
            for(int i=0;i<length;i++){
                edges[i][0]=sc.nextInt();
                edges[i][1]=sc.nextInt();
            }
            System.out.println(new FindCenterofStarGraph().findCenter(edges));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
