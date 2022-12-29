package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    int[] result;    
    int currentTime=0, index=0, resultIndex=0;    
    PriorityQueue<List<Integer>> priorityQueue;
    public SingleThreadedCPU(){        
        priorityQueue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                if(list1.get(0)==list2.get(0))
                    return list1.get(1).compareTo(list2.get(1));
                return list1.get(0).compareTo(list2.get(0));
            }            
        });
    }
    public int[] getOrder(int[][] tasks) {
        int[][] sortedTasks=new int[tasks.length][3];
        for(int i=0;i<tasks.length;i++){
            sortedTasks[i][0]=tasks[i][0];
            sortedTasks[i][1]=tasks[i][1];
            sortedTasks[i][2]=i;
        }
        result=new int[sortedTasks.length];               
        Arrays.sort(sortedTasks, new Comparator<>() {
            @Override
            public int compare(int [] a, int [] b) {                
                return (a[0] != b[0])?(a[0]-b[0]):(a[1]-b[1]);
            }
        });
        while(index<sortedTasks.length || !priorityQueue.isEmpty()){
            if(priorityQueue.isEmpty() && currentTime<sortedTasks[index][0])
                currentTime=sortedTasks[index][0];
            while(index<sortedTasks.length && sortedTasks[index][0]<=currentTime){
                priorityQueue.add(List.of(sortedTasks[index][1], sortedTasks[index][2]));
                index++;
            }
            List<Integer> polledList=priorityQueue.poll();
            currentTime+=polledList.get(0);
            result[resultIndex]=polledList.get(1);
            resultIndex++;
        }        
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] tasks;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of Tasks array : ");
            int length=sc.nextInt();
            tasks=new int[length][2];
            for(int i=0;i<length;i++){
                tasks[i][0]=sc.nextInt();
                tasks[i][1]=sc.nextInt();
            }
            System.out.println(new SingleThreadedCPU().getOrder(tasks));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
