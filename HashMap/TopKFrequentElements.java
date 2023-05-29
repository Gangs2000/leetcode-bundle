import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TopKFrequentElements {
    int[] freqElement;
    int index=0;
    Map<Integer, Integer> treeMap;
    public TopKFrequentElements(){
        treeMap=new TreeMap<>();
    }
    public int[] topKFrequent(int[] nums, int k) {        
        freqElement=new int[k];
        this.getFrequencyOfElement(nums);               
        treeMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(entry->extracted(k, entry));        
        return freqElement;
    }
    private void extracted(int k, Map.Entry<Integer, Integer> entry) {
        if(index!=k){
            freqElement[index]=entry.getKey();
            index++;        
        }
    }
    private void getFrequencyOfElement(int[] nums){
        for(int number : nums){
            treeMap.putIfAbsent(number, 0);
            treeMap.put(number, treeMap.get(number)+1);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new TopKFrequentElements().topKFrequent(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
