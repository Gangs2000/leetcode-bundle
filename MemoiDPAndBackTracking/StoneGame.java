package MemoiDPAndBackTracking;

import java.util.Scanner;

public class StoneGame {    
    int aliceScore=0, bobScore=0, leftPointer=0, righPointer=0;
    boolean aliceTurn=true;
    public boolean stoneGame(int[] piles) {
        leftPointer=0; righPointer=piles.length-1;
        while(leftPointer!=righPointer){                       
            if(aliceTurn)
                aliceScore+=pickOptimally(leftPointer, righPointer, piles);
            else
                bobScore+=pickOptimally(leftPointer, righPointer, piles);
            aliceTurn=(aliceTurn)?(false):(true);            
        }        
        return aliceScore>bobScore;
    }
    public int pickOptimally(int left, int right, int[] piles){
        int difference=(right-left)+1, valueToBeReturned=0;        
        if(difference>3 && (piles[left+1]!=piles[right-1])){
            if(piles[left+1]<piles[right-1]){
                valueToBeReturned=piles[left];
                leftPointer++;                
            }
            else{
                valueToBeReturned=piles[right];
                righPointer--;
            }               
        }
        else{
            if(piles[left]<piles[right]){
                valueToBeReturned=piles[right];
                righPointer--; 
            }   
            else{
                valueToBeReturned=piles[left];
                leftPointer++;
            }         
        }                               
        return valueToBeReturned;
    }
    public static void main(String[] args){        
        Scanner sc;
        int[] piles;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of piles array : ");
            int length=sc.nextInt();
            piles=new int[length];
            for(int i=0;i<length;i++)
                piles[i]=sc.nextInt();
            System.out.println(new StoneGame().stoneGame(piles));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
