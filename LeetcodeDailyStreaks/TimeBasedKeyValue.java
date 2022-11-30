package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TimeBasedKeyValue {
    static Map<String, Map<String, List<Integer>>> mapper;
    static List<String> outputList;
    public TimeBasedKeyValue(){
        mapper=new LinkedHashMap<>();
        outputList=new LinkedList<>();
        outputList.add(null);
    }

    public void set(String key, String value, int timestamp) {
        if(mapper.containsKey(key)){
            Map<String, List<Integer>> valueMap=mapper.get(key);    
            if(valueMap.containsKey(value)){
                List<Integer> timeStampList=valueMap.get(value);      
                timeStampList.set(1, timestamp);          
                valueMap.put(value, timeStampList);
            }
            else{
                if(mapper.size()==0){
                    List<Integer> timeStampList=setTimeStampList(timestamp);
                    valueMap.put(value, timeStampList);                
                }
                else{
                    int counter=0;
                    Map<String, List<Integer>> valueMapper=mapper.get(key);
                    for(Map.Entry<String, List<Integer>> entry : valueMapper.entrySet()){
                        if(counter==mapper.size()-1){
                            List<Integer> timeStampList=entry.getValue();
                            timeStampList.set(1, timestamp-1);
                            valueMapper.put(value, timeStampList);
                            mapper.put(key, valueMapper);
                            break;
                        }   
                        else
                            counter++;                         
                    }       
                    List<Integer> timeStampList=setTimeStampList(timestamp);
                    valueMap.put(value, timeStampList);                        
                }
            }
            mapper.put(key, valueMap);                                         
        }
        else{
            Map<String, List<Integer>> valueMap=new LinkedHashMap<>();
            List<Integer> timeStampList=new LinkedList<>();
            timeStampList.add(timestamp);
            timeStampList.add(Integer.MAX_VALUE);
            valueMap.put(value, timeStampList);
            mapper.put(key, valueMap);
        }                                       
    }
    
    public String get(String key, int timestamp) {
        String getString="";
        Map<String, List<Integer>> valueMap=mapper.get(key);        
        for(Map.Entry<String, List<Integer>> entry : valueMap.entrySet()){
            List<Integer> timeStampList=entry.getValue();
            if(timeStampList.get(0)<=timestamp && timeStampList.get(1)>=timestamp)    
                getString=entry.getKey();
        }
        return getString;
    }

    public List<Integer> setTimeStampList(int timestamp){
        List<Integer> timeStampList=new LinkedList<>();
        timeStampList.add(timestamp);
        timeStampList.add(Integer.MAX_VALUE);
        return timeStampList;        
    }
    public static void main(String[] args){
        Scanner sc;
        List<String> labels;
        try{
            sc=new Scanner(System.in);
            TimeBasedKeyValue timeBasedKeyValue=new TimeBasedKeyValue();
            labels=new LinkedList<>();
            System.out.println("Enter length of the label list : ");
            int length=sc.nextInt();
            labels.add("TimeMap");
            for(int i=1;i<length;i++){
                String label=sc.next();
                labels.add(label);
                if(label.toLowerCase().equals("set")){
                    System.out.println("Enter key, value and timestamp to set in map : ");
                    timeBasedKeyValue.set(sc.next(), sc.next(), sc.nextInt());
                    outputList.add(null);
                }
                else if(label.toLowerCase().equals("get")){
                    System.out.println("Enter key and timestamp to get value : ");
                    outputList.add(timeBasedKeyValue.get(sc.next(), sc.nextInt()));
                }
            }
            System.out.println(outputList);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
