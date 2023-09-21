import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TheKWeakestRowsinaMatrix {
    int[] resultArray;
    int index=0;
    PriorityQueue<List<Integer>> priorityQueue;
    public TheKWeakestRowsinaMatrix(){
        priorityQueue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> arg0, List<Integer> arg1) {
                if(arg0.get(0)==arg1.get(0))
                    return arg0.get(1).compareTo(arg1.get(1));
                return arg0.get(0).compareTo(arg1.get(0));
            }            
        });
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        resultArray=new int[k];
        for(int i=0;i<mat.length;i++){
            int[] currentArray=mat[i];
            if(currentArray[currentArray.length-1]!=1)
                priorityQueue.add(List.of(this.doBinarySearch(currentArray), i));
            else
                priorityQueue.add(List.of(currentArray.length, i));                
        }
        while(index<k)
            resultArray[index++]=priorityQueue.poll().get(1);
        return resultArray;
    }
    public int doBinarySearch(int[] array){
        int pivot=0,start=0, end=array.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]==1 && array[mid+1]==1)
                start=mid+1;
            else if(array[mid]==0)
                end=mid-1;       
            else{
                pivot=mid+1;
                break;
            }                 
        }                
        return pivot;
    }
    
    public static void main(String[] args){
        Scanner sc;
        int[][] matrix;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter rows and columns value : ");
            int rows=sc.nextInt();
            int columns=sc.nextInt();
            matrix=new int[rows][columns];
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new TheKWeakestRowsinaMatrix().kWeakestRows(matrix, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
