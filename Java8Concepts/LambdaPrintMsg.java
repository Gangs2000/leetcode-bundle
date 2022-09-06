import java.util.Scanner;
import FunctionalInterface.*;
class LambdaPrintMsg
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        String str;
        System.out.println("Enter string name : ");
        str=sc.next();
        printMessage obj=(value)->{
            return ("Hello!, "+value);
        };
        System.out.println(obj.printString(str));
        sc.close();
    }
}
