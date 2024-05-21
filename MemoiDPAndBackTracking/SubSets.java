import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SubSets {
    List<List<Integer>> resultList;
    public SubSets(){
        resultList=new LinkedList<>();
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.findAllCombinationsUsingBackTracking(0, nums, new LinkedList<>());
        return resultList;
    }
    private void findAllCombinationsUsingBackTracking(int index, int[] nums, List<Integer> list){
        if(index==nums.length){
            if(!resultList.contains(list))
                resultList.add(new LinkedList<>(list));
            return ;
        }
        list.add(nums[index]);
        this.findAllCombinationsUsingBackTracking(index+1, nums, list);
        list.remove(list.size()-1);
        this.findAllCombinationsUsingBackTracking(index+1, nums, list);
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
            System.out.println(new SubSets().subsets(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
