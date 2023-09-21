import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReorganizeString {    
    StringBuilder stringBuilder;
    PriorityQueue<List<Object>> priorityQueue, sparePriorityQueue;
    List<Object> list;
    Map<Character, Integer> map;
    Comparator<List<Object>> comparator;
    public ReorganizeString(){
        map=new HashMap<>();
        stringBuilder=new StringBuilder();
        sparePriorityQueue=new PriorityQueue<>();
        comparator=new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> l1, List<Object> l2) {                
                //Sort it based on the biggest byte value if frequency of character is same for both characters
                if(Integer.valueOf((int) l2.get(1))==(Integer.valueOf((int) l1.get(1))))
                    return Byte.valueOf((byte) (char) l2.get(0)).compareTo(Byte.valueOf((byte) (char) l1.get(0)));
                //If not sort it based on highest count frequency
                return Integer.valueOf((int) l2.get(1)).compareTo(Integer.valueOf((int) l1.get(1)));
            }            
        };
        priorityQueue=new PriorityQueue<>(comparator);
        sparePriorityQueue=new PriorityQueue<>(comparator);
    }
    public String reorganizeString(String s) {
        //Finding occurrence of each character
        findCharOccurence(s);
        //Adding map elements into priority queue
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            List<Object> list=new LinkedList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            priorityQueue.add(list);
        }        
        while(!priorityQueue.isEmpty()){                        
            while(!priorityQueue.isEmpty()){
                list=priorityQueue.poll();                             
                if(stringBuilder.length()==0 || (((char) list.get(0)!=stringBuilder.charAt(stringBuilder.length()-1)) && ((int) list.get(1)!=0))){
                    stringBuilder.append(list.get(0));
                    list.set(1, (int) list.get(1)-1);                    
                    priorityQueue.add(list);
                    break;
                }
                else if((int) list.get(1)!=0)
                    sparePriorityQueue.add(list);
            }  
            //If original queue is empty and current string result is not equal to original string then it means that rearrangement is not possible                                  
            if(priorityQueue.isEmpty() && stringBuilder.length()!=s.length())
                return "";
            //Moving all list values from spare queue to original queue
            while(!sparePriorityQueue.isEmpty())
                priorityQueue.add(sparePriorityQueue.poll());
        }
        return stringBuilder.toString();
    }    
    public void findCharOccurence(String s){
        for(int i=0;i<s.length();i++){
            map.putIfAbsent(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new ReorganizeString().reorganizeString(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
