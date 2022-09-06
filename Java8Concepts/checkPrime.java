import FunctionalInterface.*;
import java.util.Scanner;
class checkPrime 
{
    public static void main(String[] args)
    {
        Scanner sc;
        int number;
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter a number to find a given number is prime or not : ");
            number=sc.nextInt();
            primeInterface obj=(value)->{
                for(int i=2;i<=(value/2);i++)
                {
                    if((value%i)==0)
                        return false;
                }
                return true;
            };
            if(obj.isNumPrime(number))
                System.out.println("Given "+number+" is prime number..");
            else
                System.out.println("Given "+number+" is not a prime number..");
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
