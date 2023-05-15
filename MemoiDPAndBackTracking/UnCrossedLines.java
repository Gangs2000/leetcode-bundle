package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class UnCrossedLines {
    int[][] cache;    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        cache=new int[nums1.length][nums2.length];
        Arrays.stream(cache).forEach(array->Arrays.fill(array, -1));
        return this.findMaxUnCrossedLines(nums1, nums2, 0, 0);
    }
    public int findMaxUnCrossedLines(int[] nums1, int[] nums2, int i, int j){
        if(i>=nums1.length || j>=nums2.length)
            return 0;
        if(cache[i][j]!=-1)
            return cache[i][j];
        if(nums1[i]==nums2[j])
            return 1+findMaxUnCrossedLines(nums1, nums2, i+1, j+1);        
        else
            return cache[i][j]=Math.max(findMaxUnCrossedLines(nums1, nums2, i+1, j), findMaxUnCrossedLines(nums1, nums2, i, j+1));
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
            System.out.println(new UnCrossedLines().maxUncrossedLines(nums1, nums2));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
