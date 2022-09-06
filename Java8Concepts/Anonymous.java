import java.util.Scanner;
class Anonymous extends Thread
{
    int id;
    String name;
    Anonymous(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public static void main(String[] args)
    {
        int id;
        String name;
        Scanner sc;
        try
        {
            sc=new Scanner(System.in).useDelimiter("\n");
            System.out.println("Enter ID and name to be printed...");
            id=sc.nextInt();
            name=sc.next();
            new Anonymous(id,name){
                public void run()
                {
                    System.out.println(id+" "+name);
                }
            }.start();
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}