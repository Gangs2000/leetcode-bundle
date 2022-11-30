package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ValidPalindrome {    
    String filteredString="";
    public boolean isPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                filteredString+=s.charAt(i);
        }      
        return (filteredString.length()==0 || filteredString.length()==1)?(true):(this.checkCharacters(filteredString.toLowerCase()));           
    }
    public boolean checkCharacters(String string){        
        boolean flag=true;
        for(int i=0;i<(string.length()/2);i++){
            if(string.charAt(i)!=string.charAt(string.length()-i-1)){                
                flag=false;
                break;
            }                            
        }
        return flag;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to check whether it is palindrome or not : ");
            String string=sc.nextLine();
            System.out.println(new ValidPalindrome().isPalindrome(string));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
