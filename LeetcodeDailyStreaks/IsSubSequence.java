package LeetcodeDailyStreaks;

import java.util.Scanner;

public class IsSubSequence {       
    int indexPointer=Integer.MIN_VALUE;
    public boolean isSubsequence(String s, String t) {                                         
        if(s.length()==0 || s.equals(t))
            return true;
        else if(s.length()>t.length())
            return false;
        else{                                   
            for(int i=0;i<s.length();i++){
                int index=(indexPointer==Integer.MIN_VALUE)?(t.indexOf(s.charAt(i))):(indexPointer+t.indexOf(s.charAt(i)));                   
                if(index==-1)
                    return false;                                                                     
                else{
                    if(indexPointer<=index){                                                                       
                        indexPointer=Math.max(indexPointer, index+1);
                        t=t.substring(t.indexOf(s.charAt(i))+1);                        
                    }
                    else
                        return false;
                }                                                
            }            
            return true;
        }        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String S and T to check whetehr S is subsequence of T : ");
            String s=sc.next();
            String t=sc.next();
            System.out.println(new IsSubSequence().isSubsequence(s, t));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}