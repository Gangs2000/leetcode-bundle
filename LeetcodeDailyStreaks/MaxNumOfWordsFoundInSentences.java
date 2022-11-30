package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MaxNumOfWordsFoundInSentences {
    int maxSentenceCount=0;
    public int mostWordsFound(String[] sentences) {
        for(int i=0;i<sentences.length;i++){
            int currentLength=sentences[i].split(" ").length;
            if(currentLength>maxSentenceCount)
                maxSentenceCount=currentLength;
        }
        return maxSentenceCount;        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a length of an array : ");
            int length=sc.nextInt();
            String[] sentences=new String[length];
            for(int i=0;i<length;i++)
                sentences[i]=sc.useDelimiter("\\n").next();  
            System.out.println(new MaxNumOfWordsFoundInSentences().mostWordsFound(sentences));          
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
