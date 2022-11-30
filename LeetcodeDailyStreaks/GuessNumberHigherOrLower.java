package LeetcodeDailyStreaks;

interface checkCondition{
    static int guess(int number,int pick){
        int value=0;
        if(number>pick)
            value=-1;
        else if(number<pick)
            value=1;
        else if(number==pick)
            value=0;
        return value;
    }
}

public class GuessNumberHigherOrLower implements checkCondition{
    int guessedNumber=0; 
    public int guessNumber(int n) {
        long startPointer=1, endPointer=n;
        int pick=6789000;        
        while(startPointer<=endPointer){
            long midPoint=(startPointer+endPointer)/2;                  
            int apiResponse=checkCondition.guess((int) midPoint,pick);                        
            if(apiResponse==1)
                startPointer=(int) midPoint+1;          
            else if(apiResponse==-1)
                endPointer=(int) midPoint-1;
            else if(apiResponse==0){
                guessedNumber=(int) midPoint;
                break;
            }             
        }
        return guessedNumber;
    }

    public static void main(String[] args){
        System.out.println(new GuessNumberHigherOrLower().guessNumber(423423423));
    }
}

