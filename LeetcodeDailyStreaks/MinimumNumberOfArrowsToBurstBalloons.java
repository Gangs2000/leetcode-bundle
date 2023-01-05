package LeetcodeDailyStreaks;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    int minimumCount=1;
    List<Integer> prev, curr;    
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> comparator=new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {                
                if(a[0]==b[0])
                    return 0;
                return (a[0]<b[0])?(-1):(1);
            }            
        };
        Arrays.sort(points, comparator);
        prev=List.of(points[0][0], points[0][1]);
        for(int i=1;i<points.length;i++){
            curr=List.of(points[i][0], points[i][1]);
            if(curr.get(0)>prev.get(1)){
                prev=curr;              
                minimumCount++; 
            }  
            else    
                prev=List.of(Math.max(prev.get(0), curr.get(0)), Math.min(prev.get(1), curr.get(1)));                         
        }
        return minimumCount;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] points;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of points array : ");
            int length=sc.nextInt();
            points=new int[length][2];
            for(int i=0;i<length;i++){
                points[i][0]=sc.nextInt();
                points[i][1]=sc.nextInt();
            }
            System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
