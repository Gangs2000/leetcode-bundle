package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SecondLargestDigitInStr {
    List<Character> list;
    public SecondLargestDigitInStr(){
        list=new LinkedList<>();
    }
    public int secondHighest(String s) {
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                if(!list.contains(s.charAt(i)))
                    list.add(s.charAt(i));
            }
        }        
        if(list.size()==1 || list.size()==0)
            return -1;
        return Integer.valueOf(list.stream().sorted().skip(list.size()-2).findFirst().get().toString()); 
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter value of String : ");
            String string=sc.next();
            System.out.println(new SecondLargestDigitInStr().secondHighest(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
