package LeetcodeDailyStreaks;

import java.util.Scanner;

public class AddMinimumNumberOfRungs {
    int currentPositionAt=0, minRungToBeAdded=0;    
    public int addRungs(int[] rungs, int dist) {
        int rightPointer=0;
        while(rightPointer<rungs.length){
            if(rungs[rightPointer]-currentPositionAt<dist){
                currentPositionAt=rungs[rightPointer];
                rightPointer++;
            }  
            else{                       
                int difference=(rungs[rightPointer]-currentPositionAt);
                int toBeAdded=(difference%dist==0)?((difference/dist)-1):((difference/dist));                
                minRungToBeAdded+=toBeAdded;        
                currentPositionAt=rungs[rightPointer];                     
            }              
        }   
        return minRungToBeAdded;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] rungs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of rungs array : ");
            int length=sc.nextInt();
            rungs=new int[length];
            for(int i=0;i<length;i++)
                rungs[i]=sc.nextInt();
            System.out.println("Enter dist value : ");
            int dist=sc.nextInt();
            System.out.println(new AddMinimumNumberOfRungs().addRungs(rungs, dist));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
