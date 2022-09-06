import java.util.Scanner;
class MinimumXORSum
{
    int minSumOfXOR=Integer.MAX_VALUE,originalArr2[];
    MinimumXORSum(int array2[])                                //Instrad of directing assigning array value to original array like this (this.originalArr2=originalArr2)
    {                                                          //Copy the array values manually which avoids data collition
        originalArr2=new int[array2.length];
        for(int i=0;i<originalArr2.length;i++)
            originalArr2[i]=array2[i];
    }
    private int rearrangement(int array1[],int array2[])       //Rearranging would give minimum result of XOR sum
    {
        findMinXOR(array1,array2);                             //Reason of calling this method before iterating is to check original array sum of XOR may be a minimum value
        for(int i=0;i<(array1.length)-1;i++)
        {
            for(int j=i+1;j<array2.length;j++)
            {
                array2[i]=array2[i]+array2[j];
                array2[j]=array2[i]-array2[j];
                array2[i]=array2[i]-array2[j];
                findMinXOR(array1,array2);
                array2=originalArr2.clone();                   //Critical Portion, it's not a normal swapping - Everytime need to copy original array2 values not last modified array values
            }
        }
        return minSumOfXOR;
    }
    private void findMinXOR(int array1[],int array2[])
    {
        int sum=0;
        for(int i=0;i<array1.length;i++)
            sum+=array1[i]^array2[i];
        if(sum<minSumOfXOR && sum!=0)
            minSumOfXOR=sum;
    }
    public static void main(String[] args)
    {
        Scanner sc;
        int array1[],array2[],size=0;
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter size of an array : ");
            size=sc.nextInt();
            array1=new int[size];
            array2=new int[size];
            for(int i=0;i<size;i++)
                array1[i]=sc.nextInt();
            for(int i=0;i<size;i++)
                array2[i]=sc.nextInt();
            System.out.println("Minimum sum of XOR of two arrays "+new MinimumXORSum(array2).rearrangement(array1,array2));
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}