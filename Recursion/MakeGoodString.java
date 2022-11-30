import java.util.Scanner;

public class MakeGoodString {
    private static StringBuilder makeGoodString(StringBuilder strBuilder, int leftPointer, int rightPointer){
        if(leftPointer!=strBuilder.length()-1 && strBuilder.length()!=0 && strBuilder.length()>1){            
            if(Character.isUpperCase(strBuilder.charAt(leftPointer)) && Character.isLowerCase(strBuilder.charAt(rightPointer))){                
                if(Character.toLowerCase(strBuilder.charAt(leftPointer))==strBuilder.charAt(rightPointer)){
                    strBuilder.delete(leftPointer, rightPointer+1);                        
                    makeGoodString(strBuilder, 0, 1);
                }
                else
                    makeGoodString(strBuilder, leftPointer+1, rightPointer+1);
            }
            else if(Character.isLowerCase(strBuilder.charAt(leftPointer)) && Character.isUpperCase(strBuilder.charAt(rightPointer))){                
                if(Character.toLowerCase(strBuilder.charAt(rightPointer))==strBuilder.charAt(leftPointer)){
                    strBuilder.delete(leftPointer, rightPointer+1);                                  
                    makeGoodString(strBuilder, 0, 1);
                }
                else
                    makeGoodString(strBuilder, leftPointer+1, rightPointer+1);
            }     
            else
                makeGoodString(strBuilder, leftPointer+1, rightPointer+1);
        }
        return strBuilder;
    }
    public static void main(String[] args){
        Scanner sc;                
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the String to make it good string : ");
            String badString=sc.nextLine();
            StringBuilder strBuilder=new StringBuilder(badString);
            System.out.println("Good String after removing bad characters "+MakeGoodString.makeGoodString(strBuilder, 0, 1));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
