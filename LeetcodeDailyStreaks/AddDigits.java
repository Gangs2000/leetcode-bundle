package LeetcodeDailyStreaks;

import java.util.Scanner;

public class AddDigits {  
    int finalOutput=0;  
    public int addDigits(int num) {     
        finalOutput=0;   
        while(num>0){
            finalOutput+=(num%10);
            num/=10;
        }                   
        if(finalOutput>10)
            addDigits(finalOutput);   
        return finalOutput;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a number to add digits : ");
            int number=sc.nextInt();
            System.out.println(new AddDigits().addDigits(number));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
