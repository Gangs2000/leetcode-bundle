import java.util.PriorityQueue;
import java.util.Scanner;

public class FindtheDistanceValueBetweenTwoArrays {
    int index=0, count=0;
    PriorityQueue<Integer> priorityQueue;
    public FindtheDistanceValueBetweenTwoArrays(){
        priorityQueue=new PriorityQueue<>();
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        sortArray(arr2);
        for(int i=0;i<arr1.length;i++){
            int start=0, end=arr2.length-1;
            boolean flag=true;
            while(start<=end){
                int middle=start+((end-start)/2);
                if(Math.abs(arr1[i]-arr2[middle])<=d){
                    flag=false;
                    break;
                }
                else{
                    if(arr1[i]-arr2[middle]<0)
                        end=middle-1;
                    else
                        start=middle+1;
                }
            }
            if(flag)
                count++;
        }
        return count;
    }
    public void sortArray(int[] arr2){
        //Sort the second array..
        for(int number : arr2)
            priorityQueue.add(number);
        while(!priorityQueue.isEmpty()){
            arr2[index]=priorityQueue.poll();
            index++;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[] arr1, arr2;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of array1 : ");
            int length1=sc.nextInt();
            arr1=new int[length1];
            for(int i=0;i<length1;i++)
                arr1[i]=sc.nextInt();
            System.out.println("Enter length of array2 : ");
            int length2=sc.nextInt();
            arr2=new int[length2];
            for(int i=0;i<length2;i++)
                arr2[i]=sc.nextInt();
            System.out.println("Enter distance value : ");
            int d=sc.nextInt();
            System.out.println(new FindtheDistanceValueBetweenTwoArrays().findTheDistanceValue(arr1, arr2, d));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
