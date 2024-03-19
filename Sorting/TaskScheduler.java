import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskScheduler {
    int totalTime=0;
    PriorityQueue<Integer> priorityQueue, temPriorityQueue;
    Map<Character, Integer> freqMapper;
    Comparator<Integer> comparator;
    public TaskScheduler(){
        comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        freqMapper=new HashMap<>();
        priorityQueue=new PriorityQueue<>(comparator);
        temPriorityQueue=new PriorityQueue<>(comparator);
    }
    public int leastInterval(char[] tasks, int n) {
        this.findFrequencyOfChars(tasks);
        while(!priorityQueue.isEmpty()){
            for(int i=1;i<=n+1;i++){
                if(!priorityQueue.isEmpty()){
                    int frequency=priorityQueue.poll();
                    frequency--;
                    temPriorityQueue.add(frequency);
                }
            }
            for(int number : temPriorityQueue){
                if(number>0)
                    priorityQueue.add(number);
            }
            totalTime=(priorityQueue.isEmpty())?(totalTime+temPriorityQueue.size()):(totalTime+(n+1));
            temPriorityQueue.clear();
        }
        return totalTime;
    }
    public void findFrequencyOfChars(char[] tasks){
        for(char character : tasks){
            freqMapper.putIfAbsent(character, 0);
            freqMapper.put(character, freqMapper.get(character)+1);
        }
        for(Map.Entry<Character, Integer> entry : freqMapper.entrySet())
            priorityQueue.add((int) entry.getValue());
    }
    public static void main(String[] args){
        Scanner sc;
        char[] tasks;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of tasks array : ");
            int length=sc.nextInt();
            tasks=new char[length];
            for(int i=0;i<length;i++)
                tasks[i]=sc.next().toUpperCase().charAt(0);
            System.out.println("Enter Cooling time value : ");
            int n=sc.nextInt();
            System.out.println(new TaskScheduler().leastInterval(tasks, n));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
