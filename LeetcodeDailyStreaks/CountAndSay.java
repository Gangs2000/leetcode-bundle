package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CountAndSay {
    String string="";
    public String countAndSay(int n){
        if(n!=0){                        
            if(string.length()==0 || string.length()==1){
                string=(string.length()>=1)?("11"):("1");
                countAndSay(n-1);
            }
            else{
                String newString="";                
                int countChar=1;                
                for(int i=0;i<string.length()-1;i++){
                    if(string.charAt(i)==string.charAt(i+1))
                        countChar++;                        
                    else{                                           
                        newString+=countChar;                                                
                        newString+=string.charAt(i);
                        countChar=1;
                    }                    
                }                
                if(countChar==1 || countChar>1){                    
                    newString+=countChar;
                    newString+=string.charAt(string.length()-1);
                }
                string=newString;
                countAndSay(n-1);
            }
        }
        return string;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter how many times to count and say : ");            
            int count=sc.nextInt();
            System.out.println(new CountAndSay().countAndSay(count));            
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
