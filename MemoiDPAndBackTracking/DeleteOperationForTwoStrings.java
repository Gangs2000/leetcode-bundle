package MemoiDPAndBackTracking;

import java.util.Scanner;

public class DeleteOperationForTwoStrings {    
    int[][] cache; 
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2))
            return 0;
        else{       
            cache=new int[501][501];                 
            return (word1.length()+word2.length())-(2*findSequence(word1, word2, 0, 0));
        }
    }
    public int findSequence(String text1, String text2, int i, int j){
        if(i>=text1.length() || j>=text2.length())
            return 0;
        if(text1.charAt(i)==text2.charAt(j))
            return 1+findSequence(text1, text2, i+1, j+1);
        if(cache[i][j]!=0)
            return cache[i][j];            
        else
            return cache[i][j]=Math.max(findSequence(text1, text2, i+1, j), findSequence(text1, text2, i, j+1));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter word 1 and word 2 : ");
            String word1=sc.next();
            String word2=sc.next();
            System.out.println(new DeleteOperationForTwoStrings().minDistance(word1, word2));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
