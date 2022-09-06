import java.util.Scanner;
class LambaExp 
{
    public static void main(String[] args)
    {
        Scanner sc;
        int id;
        String name;
        try
        {
            sc=new Scanner(System.in).useDelimiter("\n");
            System.out.println("Enter ID and Name : ");
            id=sc.nextInt();
            name=sc.next();
            Runnable r1=()->{
                System.out.println("ID : "+id+" "+" NAME : "+name);
            };
            new Thread(r1).start();
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}   
