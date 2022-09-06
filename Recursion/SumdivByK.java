import java.util.Scanner;
class SumdivByK 
{
    int count=0;
    private void getCount(int array[],int end,int pointer1,int pointer2,int k)
    {
        if(array.length==end)
            System.out.println("SubArray sums divisble by "+k+" is "+count);
        else
        {
            if(array.length==pointer2)
            {
                end++;
                pointer1=0;pointer2=end;
                getCount(array,end,pointer1,pointer2,k);
            }
            else
            {
                checkSubarrayDivByK(array,pointer1,pointer2,k);
                pointer1++;pointer2++;
                getCount(array,end,pointer1,pointer2,k);
            }
        }
    }
    private void checkSubarrayDivByK(int array[],int pointer1,int pointer2,int k)
    {
        int sum=0;
        for(int i=pointer1;i<=pointer2;i++)
            sum+=array[i];
        if(sum%k==0)
            count++;
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc;
        int array[],size=0,k=0;
        sc=new Scanner(System.in);
        System.out.println("Enter size of the array : ");
        size=sc.nextInt();
        if(size<0)
            throw new Exception("Size value can't be negative..");
        else
        {
            array=new int[size];
            for(int i=0;i<size;i++)
            {
                int value=sc.nextInt();
                array[i]=value;
            }
            System.out.println("Enter K value : ");
            k=sc.nextInt();
            new SumdivByK().getCount(array,0,0,0,k);
        }
    }
}
