package LeetcodeDailyStreaks;

import java.util.List;
import java.util.Scanner;

public class UglyNumber {
    List<Integer> factorNums;
    boolean flag=false,isDividedBy;
    public UglyNumber(){
        factorNums=List.of(2,3,5);
    }
    public boolean isUgly(int n) {
        isDividedBy=true;
        if(n<=0)
            flag=false;
        else{            
            for(int i=0;i<factorNums.size();i++){
                if(n%factorNums.get(i)==0){
                    n=n/factorNums.get(i);       
                    isDividedBy=false;             
                    break;
                }                
            }        
        }                
        if(n==1)
            flag=true;
        else if(isDividedBy)
            flag=false;
        else 
            isUgly(n);        
        return flag;   
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a number to find whether it's ugly or not : ");
            int number=sc.nextInt();
            System.out.println(new UglyNumber().isUgly(number));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
