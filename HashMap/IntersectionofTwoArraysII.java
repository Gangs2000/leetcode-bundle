import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IntersectionofTwoArraysII {
    List<Integer> resultList;
    Map<Integer, Integer> frequencyMapForNum1, frequencyMapForNum2;
    public IntersectionofTwoArraysII(){
        frequencyMapForNum1=new HashMap<>();
        frequencyMapForNum2=new HashMap<>();
        resultList=new LinkedList<>();
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        for(int i=0;i<nums1.length;i++)
            this.frequencyMapper(nums1[i], frequencyMapForNum1);
        for(int i=0;i<nums2.length;i++)
            this.frequencyMapper(nums2[i], frequencyMapForNum2);
        if(frequencyMapForNum1.size()<=frequencyMapForNum2.size())
            this.findCommonElementWithLeastFrequency(frequencyMapForNum1, frequencyMapForNum2);
        else
            this.findCommonElementWithLeastFrequency(frequencyMapForNum2, frequencyMapForNum1);
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
    private void findCommonElementWithLeastFrequency(Map<Integer, Integer> originalMapper, Map<Integer, Integer> spareMapper){
        for(Map.Entry<Integer, Integer> entry : originalMapper.entrySet()){
            int key=entry.getKey();
            if(spareMapper.containsKey(key)){
                int minimumFrequency=Math.min(originalMapper.get(key), spareMapper.get(key));
                for(int i=0;i<minimumFrequency;i++)
                    resultList.add(key);
            }
        }
    }
    private void frequencyMapper(int key, Map<Integer, Integer> freqMap){
        freqMap.putIfAbsent(key, 0);
        freqMap.put(key, freqMap.get(key)+1);
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] num1, num2;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of num1 and num2 arrays : ");
            int num1Length=sc.nextInt();
            int num2Length=sc.nextInt();
            num1=new int[num1Length];
            for(int i=0;i<num1Length;i++)
                num1[i]=sc.nextInt();
            num2=new int[num2Length];
            for(int i=0;i<num2Length;i++)
                num2[i]=sc.nextInt();

            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
