import java.util.Scanner;
class ReciprocalStr
{
    String reciStr="";
    byte upper=65,lower=97;                                                    //Upper case value begins at 65 and Lower case value begins at 97
    private String reciprocalString(String string)
    {
        for(int i=0;i<string.length();i++)
        {
            if(string.charAt(i)==' ')                                          //Adding space
                reciStr+=' ';
            else if(Character.isLowerCase(string.charAt(i)))                   //Adding reciprocal lower case alpha
                reciStr+=(char) ((lower+25)-((byte) string.charAt(i)-lower));         
            else                                                               //Adding reciprocal upper case alpha
                reciStr+=(char) ((upper+25)-((byte) string.charAt(i)-upper));
        }
        return reciStr;
    }
    public static void main(String[] args)
    {
        Scanner sc;
        String string="";
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter the string to find reciprocal String : ");
            string=sc.nextLine();
            System.out.println("Reciprocal of given string is "+new ReciprocalStr().reciprocalString(string));
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}