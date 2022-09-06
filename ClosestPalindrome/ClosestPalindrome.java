import java.util.Scanner;
class ClosestPalindrome
{
    private String closestPalindrome(String number)
    {
        String closest="";
        if(number.length()==1)                                        //If length is equal to 1
            closest=String.valueOf((Integer.parseInt(number))-1);
        else                                                          //If length is greater than 1  
        {   
            String pali1=mirroring((number.length()/2)-1,number);     //All these statements common for odd and even numbers
            String pali2=makePalindrome(number,pali1);
            closest=findClosest(Long.parseLong(number),Long.parseLong(pali1),Long.parseLong(pali2));
        }
        return closest;
    }
    private String mirroring(int end,String number)
    {
        char num[]=number.toCharArray();          //Converting String into Char Array
        for(int i=0;i<=end;i++)
        {
            if(num[i]!=num[(num.length-i)-1])     //If both characters don't match, then replacing it with front pointer value
                num[(num.length-i)-1]=num[i];
        }
        return String.valueOf(num);               //Coverting Char Array into String
    }
    private String makePalindrome(String number,String pali)           //Critical Portion
    {
        String temp="";
        long num=(pali.length()%2==0)?(Long.parseLong(pali.substring(0,(pali.length()/2)))):(Long.parseLong(pali.substring(0,(pali.length()/2)+1)));
        num=(Long.parseLong(number)<Long.parseLong(pali))?(num-1):(num+1);
        temp=(pali.length()%2==0)?(mirroring((pali.length()/2)-1,num+pali.substring((pali.length()/2),pali.length()))):(mirroring((pali.length()/2),num+pali.substring((pali.length()/2)+1,pali.length())));
        return temp;
    }
    private String findClosest(long number,long pali1,long pali2)      //Comparing upper and lower bount palindromes with original value, and return least absolute difference between original and palindrome
    {
        long diff1=(number>pali1)?(number-pali1):(pali1-number);
        long diff2=(number>pali2)?(number-pali2):(pali2-number);
        return (diff1<=diff2)?(Long.toString(pali1)):(Long.toString(pali2));
    }
    public static void main(String[] args)
    {
        Scanner sc;
        String number="";
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter a number to find its closest palindrome : ");
            number=sc.next();
            long num=Long.parseLong(number);                                                              //Will throw an Input Mismatch Exception if value contains any characters
            System.out.println("Closest palindrome of "+num+" is "+new ClosestPalindrome().closestPalindrome(number));
        }
        catch(NumberFormatException e)
        {
            System.out.println("Input Mismatch Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}