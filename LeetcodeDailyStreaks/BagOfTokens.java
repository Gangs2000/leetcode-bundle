package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BagOfTokens {
    int score=0;    
    boolean sortForFirstOnly=true;
    List<Integer> tokenList;
    public BagOfTokens(){
        tokenList=new LinkedList<>();
    }
    public int bagOfTokens(int[] tokens, int power){
        //Sorting.. This condition will work first time only to sort token array
        if(sortForFirstOnly){
            sortForFirstOnly=false;                        
            tokenList=IntStream.of(tokens).boxed().sorted().collect(Collectors.toCollection(LinkedList::new));            
        }        
        if(tokenList.size()!=0)
            this.checkCondition(power);            
        return score;
    }    
    public void checkCondition(int power){
        //Core Logic
        if(tokenList.get(0)<=power){
            score++;
            power-=tokenList.get(0);
            tokenList.remove(0);                                                  
        }
        else if(score>0 && tokenList.size()!=1){
            score--;
            power+=tokenList.get(tokenList.size()-1);
            tokenList.remove(tokenList.size()-1);                                                
        }
        bagOfTokens(tokenList.stream().mapToInt(element->(int) element).toArray(), power);  
    }
    public static void main(String[] args){
        Scanner sc;
        int[] tokens;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a length of token array : ");
            int length=sc.nextInt();
            tokens=new int[length];
            for(int i=0;i<length;i++)
                tokens[i]=sc.nextInt();
            System.out.println("Enter power value : ");
            int power=sc.nextInt();
            System.out.println(new BagOfTokens().bagOfTokens(tokens, power));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
