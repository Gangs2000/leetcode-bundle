import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FurthestBuildingYouCanReach {
    PriorityQueue<Integer> bricksUsed;
    public FurthestBuildingYouCanReach(){
        bricksUsed=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        for(int i=0;i<heights.length-1;i++){
            if(heights[i+1]>heights[i]){
                int difference=heights[i+1]-heights[i];
                if(bricks>=difference){
                    bricks-=difference;
                    bricksUsed.add(difference);
                }
                else if(ladders>0){
                    if(!bricksUsed.isEmpty()){
                        int maxPastBricks=bricksUsed.peek();
                        if(difference<maxPastBricks){
                            bricksUsed.poll();
                            bricks+=maxPastBricks;
                            bricks-=difference;
                            bricksUsed.add(difference);
                        }
                    }
                    ladders--;
                }
                else
                    return i;
            }
        }
       return heights.length-1;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] buildings;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of buildings array : ");
            int length=sc.nextInt();
            buildings=new int[length];
            for(int i=0;i<length;i++)
                buildings[i]=sc.nextInt();
            System.out.println("Enter bricks and ladders count : ");
            int bricks=sc.nextInt();
            int ladders=sc.nextInt();
            System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(buildings, bricks, ladders));
            sc.close();
        } 
        catch (Exception e) {
           System.out.println("Exception occurred : "+e.getMessage());
           e.printStackTrace();
        }
    }
}