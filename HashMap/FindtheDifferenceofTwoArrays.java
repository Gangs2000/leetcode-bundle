import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindtheDifferenceofTwoArrays {
    Map<Integer, Integer> map;
    List<List<Integer>> resultList;
    public FindtheDifferenceofTwoArrays(){
        map=new HashMap<>();
        resultList=new LinkedList<>();
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        this.countElements(nums2);        
        resultList.add(this.checkIfExists(nums1));
        map.clear();
        this.countElements(nums1);        
        resultList.add(this.checkIfExists(nums2));
        return resultList;
    }
    public void countElements(int[] array){
        for(int i=0;i<array.length;i++){
            map.putIfAbsent(array[i], 0);
            map.put(array[i], map.get(array[i])+1);
        }
    }
    public List<Integer> checkIfExists(int[] array){
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i]) && !list.contains(array[i]))
                list.add(array[i]);
        }            
        return list;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums1, nums2;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums1 array : ");
            int length1=sc.nextInt();
            nums1=new int[length1];
            for(int i=0;i<length1;i++)
                nums1[i]=sc.nextInt();
            System.out.println("Enter length of nums2 array : ");
            int length2=sc.nextInt();
            nums2=new int[length2];
            for(int i=0;i<length2;i++)
                nums2[i]=sc.nextInt();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
