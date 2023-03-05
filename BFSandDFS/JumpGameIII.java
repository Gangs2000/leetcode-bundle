import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class JumpGameIII {
    boolean reachedZero=false;
    List<Integer> queue;
    Set<Integer> visited;
    public JumpGameIII(){
        queue=new LinkedList<>();
        visited=new HashSet<>();
    }
    public boolean canReach(int[] arr, int start) {
        queue.add(start);        
        while(!queue.isEmpty()){
            int index=queue.get(0);      
            if(arr[index]==0)
                return true;      
            if(!visited.contains(index)){                
                visited.add(index);
                this.breathFirstSearch(arr);                 
            }     
            queue.remove(0);            
        }
        return reachedZero;
    }
    public void breathFirstSearch(int[] arr){
        int index=queue.get(0);
        if(index-arr[index]>=0)
            queue.add(index-arr[index]);
        if(index+arr[index]<=arr.length-1)
            queue.add(index+arr[index]);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter Starting index value : ");
            int start=sc.nextInt();
            System.out.println(new JumpGameIII().canReach(nums, start));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
