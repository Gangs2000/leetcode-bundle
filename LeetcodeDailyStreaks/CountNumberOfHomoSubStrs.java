package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CountNumberOfHomoSubStrs {
    int totalHomoCount=0;
    public int countHomogenous(String s) {
        int pairCount=1, start=0, end=s.length()-1;
        while(start<end){
            if(s.charAt(start)==s.charAt(start+1))
                pairCount++;
            else{     
                this.template(pairCount);
                pairCount=1;            
            }
            start++;
        }    
        this.template(pairCount);
        return totalHomoCount;        
    }
    public void template(int pairCount){
        if(pairCount!=1)
            this.decreaseTillLastValue(pairCount);       
        else
            totalHomoCount++;                
    }
    public void decreaseTillLastValue(int value){
        while(value!=0){
            int mod=(int)1e9+7;          
            totalHomoCount=totalHomoCount+value;            
            totalHomoCount%=mod;
            value--;           
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new CountNumberOfHomoSubStrs().countHomogenous(s));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
