package LeetcodeDailyStreaks;

import java.util.Scanner;

public class InterleavingString {
    int sIndex=0, tIndex=0, index=0;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        if(s3.length()==0 && (s1.length()!=0 || s2.length()!=0))
            return false;
        if(s1.length()==0 && s2.length()==0 && s3.length()==0)
            return true;        
        while(sIndex<s1.length() && tIndex<s2.length()){
            char character=s3.charAt(index);
            if(s1.charAt(sIndex)==s2.charAt(tIndex)){
                if(sIndex!=s1.length()-1 && s1.charAt(sIndex+1)==s3.charAt(index+1))                    
                    sIndex++;
                else if(tIndex!=s2.length()-1 && s2.charAt(tIndex+1)==s3.charAt(index+1))
                    tIndex++;
                else if(sIndex==s1.length()-1 || tIndex==s2.length()-1){
                    if(s1.charAt(sIndex)==s3.charAt(index))
                        sIndex++;
                    else if(s2.charAt(tIndex)==s3.charAt(index))
                        tIndex++;
                    else
                        return false;
                }
                else
                    return false;
            }
            else{
                if(s1.charAt(sIndex)==character)
                    sIndex++;
                else if(s2.charAt(tIndex)==character)
                    tIndex++;
                else
                    return false;
            }
            index++;            
        }        
        return (index==s3.length()-1);
    }    
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S1 and S2 values : ");
            String s1=sc.useDelimiter("\n").next();
            String s2=sc.useDelimiter("\n").next();
            System.out.println("Enter S3 value : ");
            String s3=sc.useDelimiter("\n").next();
            System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
