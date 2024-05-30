import java.util.Scanner;

public class CountTripletsThatCanFormTwoArraysofEqualXOR {
    int[] prefixXor;
    public int countTriplets(int[] arr) {
        prefixXor=new int[arr.length+1];
        prefixXor[0]=0;
        for(int i=1;i<prefixXor.length;i++)
            prefixXor[i]=prefixXor[i-1]^arr[i-1];
        return this.findTriplet(prefixXor);
    }
    private int findTriplet(int[] prefixXor){
        int leftPointer=0,tripletCount=0;
        while (leftPointer<prefixXor.length) {
            int rightPointer=leftPointer+1;
            while (rightPointer<prefixXor.length) {
                if(prefixXor[leftPointer]==prefixXor[rightPointer])
                    tripletCount+=(rightPointer-leftPointer)-1;
                rightPointer++;
            }
            leftPointer++;
        }
        return tripletCount;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter arr length : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new CountTripletsThatCanFormTwoArraysofEqualXOR().countTriplets(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
