import java.util.Scanner;
class SubarrayDiv
{
    int count=0,pointer1=0;
    private void returnCount(int array[],int d,int pointer2)    //d represents sum which is equal to subarray sum, m represents array should be splited as how many indexes
    {
        if(array.length==pointer2)                              //Stops recursion once pointer2 reaches end of the array
            System.out.println("Subarray divison count is "+count);
        else
        {
            if(getSumofPointers(array,pointer1,pointer2)==d)
                count++;
            pointer1++;pointer2++;
            returnCount(array,d,pointer2);
        }
    }
    private int getSumofPointers(int array[],int pointer1,int pointer2)
    {
        int sum=0;
        for(int i=pointer1;i<=pointer2;i++)
            sum+=array[i];
        return sum;
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc;
        int array[],size=0,d=0,m=0;
        sc=new Scanner(System.in);
        System.out.println("Enter size of an array : ");
        size=sc.nextInt();
        array=new int[size];
        for(int i=0;i<size;i++)
        {
            int value=sc.nextInt();
            if(value<0)
                throw new Exception("Value can't be zero.. Please enter positive number alone..");
            else
                array[i]=value;
        }
        System.out.println("Enter D value : ");
        d=sc.nextInt();
        System.out.println("Enter M value : ");
        m=sc.nextInt();
        new SubarrayDiv().returnCount(array,d,(m-1));
    }
}