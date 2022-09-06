import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
class MissAndRepeat
{
    int missing=0;
    private int missingValue(ArrayList<Integer> al)
    {
        Collections.sort(al);
        for(int i=1;i<=al.size();i++)
        {
            if(!al.contains(i))
            {
                missing=i;
                break;
            }
        }
        return missing;
    }
    public static void main(String[] args)
    {
        Scanner sc;
        ArrayList<Integer> al;
        int size,repeating=0;
        try
        {
            sc=new Scanner(System.in);
            al=new ArrayList<Integer>();
            System.out.println("Enter size of an array : ");
            size=sc.nextInt();
            for(int i=0;i<size;i++)
            {
                int value=sc.nextInt();
                if(value>=1 && value<=size)
                {
                    if(al.contains(value))
                    {
                        al.add(value);
                        repeating=value;
                    }
                    else
                        al.add(value);
                }
                else    
                    throw new Exception("Value must be fallen between "+0+" - "+size);
            }
            System.out.println("Missing value : "+new MissAndRepeat().missingValue(al)+" Repeating value : "+repeating);
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}