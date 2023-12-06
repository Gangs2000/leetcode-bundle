package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CountofMatchesinTournament {
    int noOfMatches=0;
    public int numberOfMatches(int n) {
        while(n!=1){
            if(n%2==0){
                noOfMatches+=(n/2);
                n/=2;
            }
            else{
                noOfMatches+=((n-1)/2);
                n=((n-1)/2)+1;
            }
        }
        return noOfMatches;        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new CountofMatchesinTournament().numberOfMatches(n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
