package MaxConfusionAnExam;

import java.util.Scanner;

public class MaxConfusionOfAnExam {
    private static char charNeedstoBeChanged;
    private static void getCharNeedsToBeChanged(String answerKey){
        long countForT=answerKey.chars().mapToObj(letter->(char) letter).filter(letter->letter=='T').count();
        long countForF=answerKey.chars().mapToObj(letter->(char) letter).filter(letter->letter=='F').count();
        charNeedstoBeChanged=(countForT>=countForF)?('F'):('T');
    }   
    //Reason to use String Builder is to replace characters since normal string is immutable we can't update/replace any chars, 
    //In simple terms to perform CRUD operations, Normal won't allow us to do any modifications
    private static int getMaxCountChar(String answerKey, int k){
        StringBuilder string=new StringBuilder(answerKey);        
        for(int i=0;i<string.length();i++){
            if(k==0 || i==string.length())
                break;
            else if(string.charAt(i)==charNeedstoBeChanged){
                if(charNeedstoBeChanged=='T')
                    string.setCharAt(i, 'F');
                else
                    string.setCharAt(i,'T');
                k--;
            }
        }
        return MaxConfusionOfAnExam.iterateStringToGetMaxLength(string);
    }
    private static int iterateStringToGetMaxLength(StringBuilder string){
        int count=1;
        for(int i=0;i<string.length()-1;i++){
            if(string.charAt(i)==string.charAt(i+1))
                count++;
            else
                break;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc;
        int max=0;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the Answer Key for all questions : ");
            String answerKey=sc.next();
            System.out.println("Enter number of times modification to be performed : ");
            int k=sc.nextInt();
            if(k>answerKey.length())
                throw new Exception("K value must be less than or equal to length of the String..");
            MaxConfusionOfAnExam.getCharNeedsToBeChanged(answerKey.toUpperCase());
            for(int i=0;i<answerKey.length();i++){
                if(answerKey.subSequence(i, answerKey.length()).length()>max){
                    int output=MaxConfusionOfAnExam.getMaxCountChar(answerKey.substring(i, answerKey.length()), k);
                    max=(output>max)?(output):(max);            
                }
                else    
                    break;
            }
            System.out.println("Maximizing confusing of an Exam : "+max);
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
