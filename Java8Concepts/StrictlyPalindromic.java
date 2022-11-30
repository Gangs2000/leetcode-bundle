import java.util.Scanner;
import FunctionalInterface.BiFunction;

public class StrictlyPalindromic {
    private static boolean convertNumberToBaseValue(int number, int base){
        String reverseStr="";
        while(number>0){
            reverseStr+=number%base;
            number/=base;
        }                                            
        return (new StringBuffer(reverseStr).equals(new StringBuffer(reverseStr).reverse()))?(true):(false);
    }    
    public static void main(String[] args){
        Scanner sc;  
        boolean flag=true;      
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the number to identify whether it is strictly palindromic : ");
            int number=sc.nextInt();
            for(int i=2;i<=number-2;i++){
                BiFunction<Integer, Integer, Boolean> object=StrictlyPalindromic::convertNumberToBaseValue;
                if(!object.apply(number,i)){
                    flag=false;
                    break;
                }
            }
            if(flag)
                System.out.println("Given number "+number+" is strictly palindromic..");
            else
            System.out.println("Given number "+number+" is not strictly palindromic..");
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
