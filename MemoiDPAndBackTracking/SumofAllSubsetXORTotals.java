import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SumofAllSubsetXORTotals {
    int totalXORSum=0;
    public int subsetXORSum(int[] nums) {
        this.combinationsOfAllSubSets(0, nums, new LinkedList<>());
        return totalXORSum;
    }
    private void combinationsOfAllSubSets(int index, int[] nums, List<Integer> list){
        if(index==nums.length){
            if(list.size()>0)
                totalXORSum=(list.size()==1)?(totalXORSum+list.get(0)):(totalXORSum+this.xorOfAllElementsInList(list));
            return ;
        }
        //Take elements on current index
        list.add(nums[index]);
        this.combinationsOfAllSubSets(index+1, nums, list);
        list.remove(list.size()-1);
        //Don't take elements on current index
        this.combinationsOfAllSubSets(index+1, nums, list);
    }
    private int xorOfAllElementsInList(List<Integer> list){
        return list.stream().reduce((a,b)->(a^b)).get();
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
            System.out.println(new SumofAllSubsetXORTotals().subsetXORSum(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
