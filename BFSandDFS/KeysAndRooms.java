import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class KeysAndRooms {
    List<Integer> queue,visited;
    public KeysAndRooms(){
        queue=new LinkedList<>();
        visited=new LinkedList<>();
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited.add(0);                                                         //Adding 0 to queue
        rooms.get(0).stream().forEach(element->queue.add(element));
        while(queue.size()!=0){
            checkIsElementVisited(queue.get(0), rooms);
            if(queue.size()!=0)
                queue.remove(0);
        }
        return rooms.size()==visited.size();   
    }
    public void checkIsElementVisited(int queueElement, List<List<Integer>> rooms){
        if(!visited.contains(queueElement)){
            visited.add(queueElement);
            rooms.get(queueElement).stream().forEach(element->queue.add(element));
        }
    }
    public static void main(String[] args){
        Scanner sc;
        List<List<Integer>> listOfLists;
        try{
            sc=new Scanner(System.in);            
            listOfLists=new LinkedList<>();
            System.out.println("Enter length of list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++){
                List<Integer> list=new LinkedList<>();
                System.out.println("Enter length of "+(i+1)+" list : ");
                int len=sc.nextInt();
                for(int j=0;j<len;j++)
                    list.add(sc.nextInt());
                listOfLists.add(list);                
            }
            System.out.println(new KeysAndRooms().canVisitAllRooms(listOfLists));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
