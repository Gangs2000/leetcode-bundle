import java.util.Scanner;

public class ThreeConsecutiveOdds {
    int oddCount=0;
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int number : arr){
            oddCount=(number%2==0)?(0):(oddCount+1);
            if(oddCount==3)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new ThreeConsecutiveOdds().threeConsecutiveOdds(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
