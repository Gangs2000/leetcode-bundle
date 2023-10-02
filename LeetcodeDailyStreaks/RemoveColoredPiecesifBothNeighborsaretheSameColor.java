package LeetcodeDailyStreaks;

import java.util.Scanner;

public class RemoveColoredPiecesifBothNeighborsaretheSameColor {
    public boolean winnerOfGame(String colors) {
        if(colors.length()<3)
            return false;
        int subStrA=0, subStrB=0;
        for(int i=2;i<colors.length();i++){
            if(colors.charAt(i)=='A' && colors.charAt(i-1)=='A' && colors.charAt(i-2)=='A')
                subStrA++;
            else if(colors.charAt(i)=='B' && colors.charAt(i-1)=='B' && colors.charAt(i-2)=='B')
                subStrB++;
        }
        return subStrA>subStrB;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String colors : ");
            String colors=sc.next();
            System.out.println(new RemoveColoredPiecesifBothNeighborsaretheSameColor().winnerOfGame(colors));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
