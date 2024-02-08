import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PerfectSquaresBFS {
    List<List<Integer>> queue;
    Set<Integer> visited;
    public PerfectSquaresBFS(){
        queue=new LinkedList<>();
        visited=new HashSet<>();
    }
    public int numSquares(int n) {
        //Adding N value to queue and marking it as visited
        queue.add(Arrays.asList(n, 0));
        visited.add(n);
        while(!queue.isEmpty()){
            int currentValue=queue.get(0).get(0);
            int currentLevel=queue.get(0).get(1);
            for(int i=1;i<=currentValue;i++){
                int newValue=currentValue-(i*i);
                if(newValue>0){
                    if(!visited.contains(newValue)){
                        queue.add(Arrays.asList(newValue, currentLevel+1));
                        visited.add(newValue);
                    }
                }
                else if(newValue==0)
                    return currentLevel+1;
                else
                    break;
            }
            queue.remove(0);
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new PerfectSquaresBFS().numSquares(n));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
