package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MaximizetheConfusionofanExam {    
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(template(answerKey, 'F', k), template(answerKey, 'T', k));
    }
    public int template(String answerKey, char character, int k){
        int leftPointer=0, rightPointer=0, currentCount=0, maxCount=0;
        while(rightPointer<answerKey.length()){
            if(answerKey.charAt(rightPointer++)==character)
                currentCount++;
            while(currentCount>k)
                currentCount-=(answerKey.charAt(leftPointer++)==character)?(1):(0);
            maxCount=Math.max(maxCount, (rightPointer-leftPointer));
        }        
        return maxCount;
    }
    public static void main(String[] args){
        Scanner sc;
        try{    
            sc=new Scanner(System.in);
            System.out.println("Enter AnswerKey String : ");
            String answerKey=sc.next();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new MaximizetheConfusionofanExam().maxConsecutiveAnswers(answerKey, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

