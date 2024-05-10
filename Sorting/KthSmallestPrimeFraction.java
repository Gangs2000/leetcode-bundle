import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestPrimeFraction {
    int[] result;
    PriorityQueue<List<Object>> priorityQueue;
    public KthSmallestPrimeFraction(){
        result=new int[2];
        priorityQueue=new PriorityQueue<>(new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                return Float.valueOf((float) o1.get(0)).compareTo(Float.valueOf((float) o2.get(0)));
            }
        });
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        this.putFractionsIntoHeap(arr);
        while (k-->0 && !priorityQueue.isEmpty()){
            List<Object> peekList=priorityQueue.poll();
            if(k==0){
                result[0]=(int) peekList.get(1);
                result[1]=(int) peekList.get(2);
            }
        }
        return result;
    }
    private void putFractionsIntoHeap(int[] arr){
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++)
                priorityQueue.add(Arrays.asList((float) arr[i]/arr[j], arr[i], arr[j]));
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] arr;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of arr : ");
            int length=sc.nextInt();
            arr=new int[length];
            for(int i=0;i<length;i++)
                arr[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new KthSmallestPrimeFraction().kthSmallestPrimeFraction(arr, k));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
