import java.util.Scanner;
import java.util.ArrayList;
class MaxProd
{
    int maxProd=1;
    private int returnMaxProd(ArrayList<Integer> al,int k)
    {
        int min=Integer.MAX_VALUE;                              //Keeping it as MAX VALUE to find out minimum value in arraylist
        int position=0;
        for(int i=0;i<al.size();i++)                            //Iteration to find out minimum value and its index
        {
            if(al.get(i)<min)
            {
                min=al.get(i);
                position=i;
            }
        }
        al.remove(position);                                    //Once index and value fetched, Removed minimum value from arraylist
        al.add(position,(min+k));                               //Add new elements into arraylist which is minimum+k at specified index 
        for(int i=0;i<al.size();i++)
        {
            if(al.get(i)!=0)
                maxProd*=al.get(i);                             //Once added now finding product of an arraylist, which must be maximum product
        }                             
        return maxProd;                                         //Returning max prod value after incrementing K times
    }
    public static void main(String[] args)
    {
        Scanner sc;
        int size=0,k=0;
        ArrayList<Integer> al;
        try
        {
            sc=new Scanner(System.in);
            al=new ArrayList<Integer>();
            System.out.println("Enter the size of an array : ");
            size=sc.nextInt();
            if(size<0)
                throw new Exception("Size can't be negative value..");
            for(int i=0;i<size;i++)
            {
                int value=sc.nextInt();
                if(value<0)
                    throw new Exception("Value can't be negative..");
                else    
                    al.add(value);
            }
            System.out.println("Enter increment value : ");
            k=sc.nextInt();
            System.out.println("Maximum product after K increment is "+new MaxProd().returnMaxProd(al,k));
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}