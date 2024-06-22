import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountNumberofNiceSubarrays {
    int countOfNiceSubArr=0, oddCount=0;
    Map<Integer, Integer> freqCountMap;
    public CountNumberofNiceSubarrays(){
        freqCountMap=new HashMap<>();
        freqCountMap.put(0, 1);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
                oddCount++;
            if(freqCountMap.containsKey(oddCount-k))
                countOfNiceSubArr+=freqCountMap.get(oddCount-k);
            freqCountMap.putIfAbsent(oddCount, 0);
            freqCountMap.put(oddCount, freqCountMap.get(oddCount)+1);
        }
        return countOfNiceSubArr;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new CountNumberofNiceSubarrays().numberOfSubarrays(nums, k));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
