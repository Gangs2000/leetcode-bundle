import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumNumberofArrowstoBurstBalloons {
    int currentMinimum=Integer.MAX_VALUE, minimumBurst=1;
    Comparator<int[]> comparator=new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0]==o2[0])
                return 0;
            return (o1[0]<o2[0])?(-1):(1);
        }
    };
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, comparator);
        currentMinimum=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=points[i-1][1])
                currentMinimum=Math.min(currentMinimum, points[i][1]);
            if(!(points[i][0]<=currentMinimum) || (points[i][0]>points[i-1][1])){
                minimumBurst++;
                currentMinimum=points[i][1];
            }
        }
        return minimumBurst;
    }
    public static void main(String[] args) {
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
            System.out.println(new MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(points));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
