package ExceptionHandling;

import java.util.Scanner;

class CustomException extends Exception{
    public CustomException(String str){
        super(str);
    }
    public static String ageValidation(int age) throws CustomException{
        if(age<18)
            throw new CustomException("Age must be greater than 18..");
        else
            return "Age is validated";
    }        
}

public class AgeValidator {    
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter your age : ");
            int age=sc.nextInt();
            System.out.println(CustomException.ageValidation(age));
            sc.close();
        }
        catch(CustomException customException){            
            customException.printStackTrace();
        }        
    }
}
