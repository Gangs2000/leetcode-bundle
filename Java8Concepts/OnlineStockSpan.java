import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import FunctionalInterface.Function;

public class OnlineStockSpan {    
    static List<List<Integer>> prices;
    static List<Integer> outputList;
    static List<String> labels;
    static int counter=0;
    public OnlineStockSpan(){
        labels=new LinkedList<>();
        prices=new LinkedList<>();            
        outputList=new LinkedList<>();    
    }    
    public int next(int price){
        int countDays=1;
        if(outputList.size()!=1){
            int counter=this.returnCounterValue();
            List<List<Integer>> prices=this.returnPrices();            
            for(int i=counter-1;i>=1;i--){
                if(price>=prices.get(i).get(0))
                    countDays++;
                else
                    break;
            }            
        }
        return countDays;
    }   
    public int returnCounterValue(){
        return counter;
    } 
    public List<List<Integer>> returnPrices(){
        return prices;
    }
    public static void main(String[] args){        
        Scanner sc;        
        OnlineStockSpan onlineStockSpan;
        Function<Integer, Integer> functionalObject;
        try{
            sc=new Scanner(System.in);
            onlineStockSpan=new OnlineStockSpan();
            functionalObject=onlineStockSpan::next;
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            System.out.println("Enter labels one by one : ");
            for(int i=0;i<length;i++)
                labels.add(sc.next());
            System.out.println("Enter price value one by one : ");
            prices.add(new LinkedList<>());
            for(int i=1;i<length;i++)
                prices.add(List.of(sc.nextInt()));
            for(int i=0;i<labels.size();i++){
                if(labels.get(i).equals("StockSpanner")){                        
                    outputList.add(null);                    
                    counter++;         
                }
                else if(labels.get(i).equals("next")){                    
                    outputList.add(functionalObject.apply(prices.get(i).get(0)));
                    counter++;
                }
            }
            System.out.println(outputList);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
