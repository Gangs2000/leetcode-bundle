package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RemoveDigitFromNumberToMaxResult {
    List<String> listOfStr;
    public RemoveDigitFromNumberToMaxResult(){
        listOfStr=new LinkedList<>();
    }
    public String removeDigit(String number, char digit) {        
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)==digit){
                StringBuilder tempBuilder=new StringBuilder(number);
                tempBuilder.deleteCharAt(i);
                listOfStr.add(tempBuilder.toString());
            }
        }
        return listOfStr.stream().sorted().skip(listOfStr.size()-1).findFirst().get();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number and digit value : ");
            String number=sc.next();
            String digit=sc.next();
            System.out.println(new RemoveDigitFromNumberToMaxResult().removeDigit(number, digit.charAt(0)));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
