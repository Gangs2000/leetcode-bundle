import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MostPopularVideoCreator {
    Map<String, Integer> creatorMapper;
    Map<String, List<Object>> idMapper;
    PriorityQueue<List<Object>> priorityQueue;
    List<List<String>> resultList;
    public MostPopularVideoCreator(){
        creatorMapper=new HashMap<>();
        idMapper=new HashMap<>();
        priorityQueue=new PriorityQueue<>(new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                return Integer.valueOf((int) o2.get(1)).compareTo((int) o1.get(1));
            }
        });
        resultList=new LinkedList<>();
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        //Map creators with most views
        for(int i=0;i<creators.length;i++){
            if(!creatorMapper.containsKey(creators[i])){
                creatorMapper.put(creators[i], views[i]);
                idMapper.put(creators[i], Arrays.asList(ids[i], Integer.MAX_VALUE));
                priorityQueue.add(Arrays.asList(creators[i], views[i]));
            }
            else{
                int currentView=creatorMapper.get(creators[i]);
                String currentId=(String) idMapper.get(creators[i]).get(0);
                int currentValue=(int) idMapper.get(creators[i]).get(1);
                priorityQueue.remove(Arrays.asList(creators[i], currentView));
                if(currentView==views[i]){
                    creatorMapper.put(creators[i], currentView+views[i]);
                    priorityQueue.add(Arrays.asList(creators[i], currentView+views[i]));
                    if(ids[i].compareTo(currentId)>=currentValue)
                        idMapper.put(creators[i], Arrays.asList(ids[i], ids[i].compareTo(currentId)));
                }
                else if(views[i]>currentView){
                    creatorMapper.put(creators[i], views[i]);
                    idMapper.put(creators[i], Arrays.asList(ids[i], Integer.MAX_VALUE));
                    priorityQueue.add(Arrays.asList(creators[i], views[i]));
                }
            }
        }
        while(!priorityQueue.isEmpty()){
            List<Object> list=priorityQueue.poll();
            String creator=(String) list.get(0);
            int view=(int) list.get(1);
            resultList.add(Arrays.asList(creator, (String) idMapper.get(creator).get(0)));
            if(!(!priorityQueue.isEmpty() && (int) priorityQueue.peek().get(1)==view))
                break;
        }
        return resultList;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] creators, ids;
        int[] views;
        try{
            sc=new Scanner(System.in);
            creators=new String[]{"alice","bob","alice","chris"};
            views=new int[]{5,10,5,4};
            ids=new String[]{"one","two","three","four"};
            System.out.println(new MostPopularVideoCreator().mostPopularCreator(creators, ids, views));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}