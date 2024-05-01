import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberofOperationstoMakeArrayXOREqualtoK {
    int xorOfNums=0, diff=0;
    public int minOperations(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
            xorOfNums=xorOfNums^nums[i];
        if(xorOfNums==k)
            return 0;
        String xorAllElements=this.convertDecimalToBinary(xorOfNums);
        String kElement=this.convertDecimalToBinary(k);
        if(xorAllElements.length()>kElement.length())
            kElement=this.appendLeadingZeros(kElement, xorAllElements.length()-kElement.length());
        else if(kElement.length()>xorAllElements.length())
            xorAllElements=this.appendLeadingZeros(xorAllElements, kElement.length()-xorAllElements.length());
        for(int i=0;i<kElement.length();i++){
            if(xorAllElements.charAt(i)!=kElement.charAt(i))
                diff++;
        }
        return diff;
    }
    public String convertDecimalToBinary(int decimal){
        StringBuilder binary=new StringBuilder();
        while (decimal>0) {
            binary.append(decimal%2);
            decimal/=2;
        }
        return binary.reverse().toString();
    }
    public String appendLeadingZeros(String binary, int leadingZeroesToBeAppended){
        char[] leadingZeroes=new char[leadingZeroesToBeAppended];
        Arrays.fill(leadingZeroes, '0');
        return new StringBuilder(String.valueOf(leadingZeroes)).append(binary).toString();
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new MinimumNumberofOperationstoMakeArrayXOREqualtoK().minOperations(nums, k));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
