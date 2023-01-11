package LeetcodeDailyStreaks;

import java.util.Scanner;

public class StringWithoutAAAorBBB {
    String result="";
    public String strWithout3a3b(int a, int b) {
        while(a!=0 || b!=0){       
            int findMax=Math.max(a,b);           
            if(result.length()==0){       
                result+=(findMax>=2)?((findMax==a)?("aa"):("bb")):((findMax==a)?("a"):("b"));
                if(findMax>=2){                    
                    if(findMax==a)
                        a=a-2;
                    else
                        b=b-2;
                }      
                else{                    
                    if(findMax==a)
                        a--;
                    else
                        b--;
                }         
            }
            else{                
                if(result.charAt(result.length()-1)=='a'){     
                    result+=(findMax==a)?("b"):((b>=2)?("bb"):("b"));
                    b=(findMax==a)?(b-1):((b>=2)?(b-2):(b-1));                    
                }
                else{
                    result+=(findMax==b)?("a"):((a>=2)?("aa"):("a"));
                    a=(findMax==b)?(a-1):((a>=2)?(a-2):(a-1));                          
                }   
            }            
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter A and B values : ");
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(new StringWithoutAAAorBBB().strWithout3a3b(a, b));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
