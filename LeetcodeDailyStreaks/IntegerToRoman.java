package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegerToRoman {
    Map<String,Integer> mapper;
    String romanValue="",key="";
    int value=0;
    public IntegerToRoman(){
        mapper=new LinkedHashMap<>();
        mapper.put("I",1);
        mapper.put("V",5);
        mapper.put("X",10);
        mapper.put("L",50);
        mapper.put("C",100);
        mapper.put("D",500);
        mapper.put("M",1000);
    }
    public String intToRoman(int num) {
        if(num!=0){
            if(String.valueOf(num).charAt(0)=='9' || String.valueOf(num).charAt(0)=='4'){
                int minus=0;
                if(String.valueOf(num).length()==3){
                    romanValue+=(String.valueOf(num).charAt(0)=='9')?("CM"):("CD");
                    minus=(String.valueOf(num).charAt(0)=='9')?(900):(400);                    
                }
                else if(String.valueOf(num).length()==2){
                    romanValue+=(String.valueOf(num).charAt(0)=='9')?("XC"):("XL");
                    minus=(String.valueOf(num).charAt(0)=='9')?(90):(40);                    
                }   
                else if(String.valueOf(num).length()==1){
                    romanValue+=(String.valueOf(num).charAt(0)=='9')?("IX"):("IV");
                    minus=(String.valueOf(num).charAt(0)=='9')?(9):(4);                    
                }  
                num-=minus;     
            }            
            else{                
                this.getKeyAndValue(num);                   //Calling method to get key and value whose value is lower than current number
                romanValue+=key;                
                num-=value;                
                key=""; value=0;                      
            }
            this.intToRoman(num);                           //Recursive function call
        }
        return romanValue;
    }
    public void getKeyAndValue(int num){
        for(Map.Entry<String,Integer> entry : mapper.entrySet()){
            if(entry.getValue()<=num){
                key=entry.getKey();
                value=entry.getValue();
            }
            else
                break;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter an Integer to find its Roman Value : ");
            int number=sc.nextInt();
            System.out.println(new IntegerToRoman().intToRoman(number));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
