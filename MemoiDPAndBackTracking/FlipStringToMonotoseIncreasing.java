package MemoiDPAndBackTracking;

import java.util.Scanner;

public class FlipStringToMonotoseIncreasing {    
    int[][] cache;  
    public int minFlipsMonoIncr(String s) {
        cache=new int[s.length()+1][2];  
        if(s.length()==1)
            return 0;                
        return flipChars(s, 0, 0);
    }   
    public int flipChars(String string, int currentIndex, int prevIndex){
        if(currentIndex>=string.length())
            return 0;
        if(cache[currentIndex][prevIndex]!=0)
            return cache[currentIndex][prevIndex];
        int flip=Integer.MAX_VALUE;
        int noFlip=Integer.MAX_VALUE;
        if(string.charAt(currentIndex)=='0'){
            if(prevIndex==0){
                flip=1+flipChars(string, currentIndex+1, 1);
                noFlip=flipChars(string, currentIndex+1, 0);
            }
            else if(prevIndex==1)
                flip=1+flipChars(string, currentIndex+1, 1);
        }
        else if(string.charAt(currentIndex)=='1'){
            if(prevIndex==0){
                flip=1+flipChars(string, currentIndex+1, 0);
                noFlip=flipChars(string, currentIndex+1, 1);
            }
            else if(prevIndex==1)
                noFlip=flipChars(string, currentIndex+1, 1);
        }
        return cache[currentIndex][prevIndex]=Math.min(flip, noFlip);
    }
    public static void main(String[] args){
        Scanner sc;
        try{    
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new FlipStringToMonotoseIncreasing().minFlipsMonoIncr(s));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
