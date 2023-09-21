package MemoiDPAndBackTracking;

import java.util.Scanner;

public class SubstringWithLargestVariance {
    int longestVariantCount=0;
    public int largestVariance(String s) {
        for(char i='a';i<='z';i++){            
            for(char j='a';j<='z';j++){
                if(!(s.contains(Character.toString(i)) && s.contains(Character.toString(j))))
                    continue;
                int firstCharCount=0, secondCharCount=0;
                boolean flag=false;
                for(int k=0;k<s.length();k++){
                    if(s.charAt(k)==i)
                        firstCharCount++;
                    if(s.charAt(k)==j)
                        secondCharCount++;
                    if(secondCharCount>0)
                        longestVariantCount=Math.max(longestVariantCount, firstCharCount-secondCharCount);
                    else{
                        if(flag)
                            longestVariantCount=Math.max(longestVariantCount, firstCharCount-1);
                    }
                    if(secondCharCount>firstCharCount){
                        firstCharCount=0;
                        secondCharCount=0;
                        flag=true;
                    }
                }
            }
        }
        return longestVariantCount;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new SubstringWithLargestVariance().largestVariance(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
