import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {    
    Set<Integer> uniqueSet;
    public RemoveDuplicatesFromSortedArray(){
        uniqueSet=new HashSet<>();
    }
    public int removeDuplicates(int[] nums){
        List<Integer> listNum=Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(Integer number : listNum){
            if(!uniqueSet.contains(number))
                uniqueSet.add(number);
        }   
        return uniqueSet.size();
    }
    public Set<Integer> getUniquSet(){
        return uniqueSet;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray=new RemoveDuplicatesFromSortedArray();
            System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
            List<Integer> mappedList=removeDuplicatesFromSortedArray.getUniquSet().stream().collect(Collectors.toList());
            for(int i=0;i<nums.length;i++)
                nums[i]=(i>mappedList.size()-1)?(-1):(mappedList.get(i));                
            for(Integer number : nums)
                System.out.print(number+" ");
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
