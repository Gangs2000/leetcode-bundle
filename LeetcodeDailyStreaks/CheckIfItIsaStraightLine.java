package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CheckIfItIsaStraightLine {    
    public boolean checkStraightLine(int[][] coordinates) {        
        if(coordinates.length>2){
            for(int i=0;i<coordinates.length-2;i++){
                int x0=coordinates[i][0];
                int y0=coordinates[i][1];
                int x1=coordinates[i+1][0];
                int y1=coordinates[i+1][1];
                int x2=coordinates[i+2][0];
                int y2=coordinates[i+2][1];
                if((y0-y1)*(x1-x2)!=(y1-y2)*(x0-x1))
                    return false;                                    
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] coordinates;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of co-ordinates array : ");
            int length=sc.nextInt();
            coordinates=new int[length][2];
            for(int i=0;i<length;i++){
                coordinates[i][0]=sc.nextInt();
                coordinates[i][1]=sc.nextInt();
            }
            System.out.println(new CheckIfItIsaStraightLine().checkStraightLine(coordinates));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
