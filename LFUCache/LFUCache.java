package LFUCache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LFUCache {
    Map<Integer,Integer> map;
    int capacity=0;
    public LFUCache(int capacity){
        this.capacity=capacity; 
        map=new LinkedHashMap<>(capacity);
    }
    private Map<Integer, Integer> getMap() {
        return map;
    }
    private void setMap(Map<Integer, Integer> map) {
        this.map = map;
    }
    private int get(int key){
        return (map.containsKey(key))?(map.get(key)):(-1);
    }
    private void put(int key,int value){
        if(map.size()>=capacity){
            this.capacityFull();
            map.put(key, value);
        }
        else
            map.put(key, value);
    }
    private void caching(int key,int value){
        if(this.getMap().size()!=1){
            Map<Integer,Integer> tempMap=this.getMap();
            tempMap.remove(key);
            if(value!=-1)
                tempMap.put(key, value);
            this.setMap(tempMap);
        }
    }
    private void capacityFull(){
        Map<Integer,Integer> tempMap=this.getMap();
        int key=tempMap.entrySet().stream().findFirst().get().getKey();
        tempMap.remove(key);
        this.setMap(tempMap);
    }
    public static void main(String[] args){
        Scanner sc;
        List<String> label;
        List<List<Integer>> values;
        List<Integer> output;
        try{
            sc=new Scanner(System.in);
            label=new LinkedList<>();
            values=new LinkedList<>();
            output=new LinkedList<>();
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++){
                System.out.println("Enter label name : ");
                String string=sc.next();
                if(string.equals("LFUCache") || string.equals("get")){
                    label.add(string);
                    System.out.println("Enter list value for get/LFUCache : ");
                    values.add(List.of(sc.nextInt()));
                }
                else{
                    label.add(string);
                    System.out.println("Enter key and value : ");
                    values.add(List.of(sc.nextInt(),sc.nextInt()));
                }
            }
            LFUCache object=new LFUCache(values.get(0).get(0));
            output.add(null);
            for(int i=1;i<label.size();i++){
                if(label.get(i).equals("put")){
                    object.put(values.get(i).get(0), values.get(i).get(1));
                    output.add(null);
                }
                else if(label.get(i).equals("get")){
                    int key=values.get(i).get(0);
                    int value=object.get(key);
                    output.add(object.get(values.get(i).get(0)));
                    object.caching(key,value);
                }
            }
            System.out.println(output);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
