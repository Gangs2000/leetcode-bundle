import java.util.ArrayList;
import java.util.Scanner;
class EliminationGame
{
    boolean flag=true;
    int output;
    ArrayList<Integer> al;
    ArrayList<Integer> spare;
    EliminationGame(int number)
    {
        al=new ArrayList<Integer>();
        spare=new ArrayList<Integer>();
        for(int i=1;i<=number;i++)
            al.add(i);
    }
    private int eliminateNum()
    {
        if(al.size()==1)
            output=al.get(0);
        else if(al.size()>1)
        {
            for(int i=0;i<al.size();i++)
            {
                if(i%2==1 && flag==true)
                    spare.add(al.get(i));
                else if(i%2==0 && flag==false)
                    spare.add(al.get(i));
            }
            al=(ArrayList) spare.clone();
            spare.clear();
            flag=(flag)?(false):(true);
            eliminateNum(); 
        }
        return output;
    }
    public static void main(String[] args)
    {
        Scanner sc;
        int number;
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter the number to find out elimination number : ");
            number=sc.nextInt();
            System.out.println("Remaining number after eliminating all numbers from list : "+new EliminationGame(number).eliminateNum());
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}