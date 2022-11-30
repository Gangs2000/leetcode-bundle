package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class MaximumFrequencyStack {    
    static List<Integer> outputList;
    Stack<Integer> stack;
    Map<Integer, Integer> frequencyMapper;
    public MaximumFrequencyStack(){
        outputList=new LinkedList<>();
        stack=new Stack<>();
        frequencyMapper=new LinkedHashMap<>();
        outputList.add(null);
    }

    public void push(int val) {
        if(frequencyMapper.containsKey(val))    
            frequencyMapper.put(val, frequencyMapper.get(val)+1);
        else
            frequencyMapper.put(val, 1);        
        stack.push(val);
    }
    
    public int pop() {        
        int mostValue=frequencyMapper.entrySet().stream().map(entry->entry.getValue()).max(Integer::compareTo).get();
        return getMostUsedKeyFromList(getListOfKeys(frequencyMapper, mostValue));                             
    }

    public List<Integer> getListOfKeys(Map<Integer, Integer> mapper, int mostValue){
        return frequencyMapper.entrySet().stream().filter(entry->entry.getValue()==mostValue).map(entry->entry.getKey()).collect(Collectors.toList());                
    }

    public int getMostUsedKeyFromList(List<Integer> keyLists){
        int topMostIndex=0;
        for(int i=0;i<keyLists.size();i++){
            int index=stack.lastIndexOf(keyLists.get(i));
            if(index>topMostIndex)
                topMostIndex=stack.lastIndexOf(keyLists.get(i));
        }
        int getKey=stack.get(topMostIndex);        
        frequencyMapper.put(stack.get(topMostIndex), frequencyMapper.get(stack.get(topMostIndex))-1);   
        stack.remove(topMostIndex);
        return getKey;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            MaximumFrequencyStack maximumFrequencyStack=new MaximumFrequencyStack();
            System.out.println("Enter length of the label list : ");
            int length=sc.nextInt();
            for(int i=1;i<length;i++){
                System.out.println("Enter label name to perform operation : ");
                String label=sc.next();
                if(label.equals("push")){
                    maximumFrequencyStack.push(sc.nextInt());
                    outputList.add(null);
                }
                else if(label.equals("pop"))
                   outputList.add(maximumFrequencyStack.pop());
            }
            System.out.println(outputList);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
