package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Scanner;

public class AddBinary {    
    public String addBinary(String a, String b) {
        if(a.length()!=b.length()){
            char[] trailZeros=new char[Math.abs(a.length()-b.length())];          
            Arrays.fill(trailZeros, '0');      
            return (a.length()>b.length())?(this.performAdditon(a, String.valueOf(trailZeros)+b)):(this.performAdditon(String.valueOf(trailZeros)+a, b));            
        }        
        return this.performAdditon(a, b);        
    }
    public String performAdditon(String a, String b){
        String result="";
        int reminder=0;
        for(int i=a.length()-1;i>=0;i--){
            int addValuesWithReminder=Integer.valueOf(String.valueOf(a.charAt(i)))+Integer.valueOf(String.valueOf(b.charAt(i)))+reminder;
            if(addValuesWithReminder==0 || addValuesWithReminder==1){
                result+=String.valueOf(Integer.valueOf(addValuesWithReminder));
                reminder=0;
            }
            else if(addValuesWithReminder==2){
                result+='0';
                reminder=1;
            }   
            else if(addValuesWithReminder==3){
                result+='1';
                reminder=1;
            }                
        }
        if(reminder==1)
            result+=reminder;
        return new StringBuilder(result).reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter A and B binary values : ");
            String a=sc.next();
            String b=sc.next();
            System.out.println(new AddBinary().addBinary(a, b));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

