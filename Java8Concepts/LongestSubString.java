import java.util.Scanner;
import FunctionalInterface.Function;

public class LongestSubString {
    private static int subStringLength(String string){
        int count=1;
        for(int i=0;i<string.length()-1;i++){
            if((byte) string.charAt(i)==((byte) string.charAt(i+1))-1)          //Comparing wheather next byte value is addition of one of previous byte value
                count++;
            else
                break;
        }        
        return count;
    }
    public static void main(String[] args){
        Scanner sc;        
        int longestStrLength=0;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the String to find longest substring length : ");
            String string=sc.next();
            for(int i=0;i<string.length()-1;i++){                
                for(int j=i+1;j<string.length();j++){
                    Function<String,Integer> object=LongestSubString::subStringLength;
                    int getMaxLength=object.apply(string.substring(i, (j+1)));                    
                    if(getMaxLength>longestStrLength)                            //Checking current count value is greater than local variable count value
                        longestStrLength=getMaxLength;
                    if(string.substring(i, (j+1)).length()!=getMaxLength)        //If the count length is not equal the current substring length then break inner loop to reduce time complexity               
                        break;
                }                              

            }
            System.out.println("Longest Substring length is "+longestStrLength);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
