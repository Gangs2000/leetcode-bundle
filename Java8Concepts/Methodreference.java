import java.util.Scanner;

import FunctionalInterface.*;
class Methodreference 
{
    private static String changeCasetoUpper(String string)
    {
        return string.toUpperCase();
    }
    private String getSubString(String string)
    {
        return string.substring(0,4);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        String msg;
        System.out.println("Enter a String to convert it to Uppercase : ");
        msg=sc.next();
        System.out.println("Original message : "+msg);
        printMessage obj1=Methodreference::changeCasetoUpper;                                   //Static Reference to method
        System.out.println("Message after converting it into uppercase : "+obj1.printString(msg));
        printMessage obj2=new Methodreference()::getSubString;                                  //Instance reference to method
        System.out.println("Substring (0,4) of given string is : "+obj2.printString(msg));
        sc.close();
    }
}
