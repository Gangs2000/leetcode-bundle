package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CheckIfTwoStringArrayEquivalent {
    String concatArray1="",concatArray2="";
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        for(int i=0;i<word1.length;i++)
            concatArray1+=word1[i];
        for(int i=0;i<word2.length;i++)
            concatArray2+=word2[i];
        return concatArray1.equals(concatArray2);
    }
    public static void main(String[] args){
        Scanner sc;
        String[] word1,word2;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of word1 array : ");
            int wlength1=sc.nextInt();
            word1=new String[wlength1];
            for(int i=0;i<wlength1;i++)
                word1[i]=sc.useDelimiter("\n").next();
            System.out.println("Enter length of word2 array : ");
            int wlength2=sc.nextInt();
            word2=new String[wlength2];
            for(int i=0;i<wlength2;i++)
                word2[i]=sc.useDelimiter("\n").next();
            System.out.println(new CheckIfTwoStringArrayEquivalent().arrayStringsAreEqual(word1, word2));
        }
        catch(Exception e){
            System.out.println("Exception occuted : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
