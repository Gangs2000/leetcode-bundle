package LeetcodeDailyStreaks;

import java.util.Scanner;

public class StringCompression {
    String compressedString="";
    public int compress(char[] chars) {                        
        int count=1;
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1])
                count++;
            else{
                compressedString+=(count>1)?(String.valueOf(chars[i])+count):(chars[i]);
                count=1;
            }
        }
        compressedString+=(count>1)?(String.valueOf(chars[chars.length-1])+count):(chars[chars.length-1]);
        for(int i=0;i<compressedString.length();i++)
            chars[i]=compressedString.charAt(i);
        return compressedString.length();
    }
    public static void main(String[] args){
        Scanner sc;
        char[] chars;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of chars array : ");
            int length=sc.nextInt();
            chars=new char[length];
            for(int i=0;i<length;i++)
                chars[i]=sc.next().charAt(0);
            System.out.println(new StringCompression().compress(chars));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
