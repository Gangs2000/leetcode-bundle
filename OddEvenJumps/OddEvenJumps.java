package OddEvenJumps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OddEvenJumps {
    private static boolean jumps(List<Integer> list){
        boolean flag1=true,flag2=true;
        int index=0;
        while(true){
            Map<Integer,Integer> map=new HashMap<>();
            if(flag2){
                for(int i=index+1;i<list.size();i++){
                    if(list.get(index)<=list.get(i) && !map.containsKey(list.get(i)))
                        map.put(list.get(i), i);
                }
            }
            else{
                for(int i=index+1;i<list.size();i++){
                    if(list.get(index)>=list.get(i) && !map.containsKey(list.get(i)))
                        map.put(list.get(i), i);
                }
            }
            //Checking whether index reach at the end of an array if so considering this index as good index..
            int getIndex=OddEvenJumps.getNextIndex(map, flag2);
            if(getIndex==-1 || getIndex==list.size()-1){
                flag1=(getIndex==list.size()-1)?(true):(false);
                break;
            }
            else{
                index=getIndex;
                flag2=(flag2)?(false):(true);
            }
        }
        return flag1;
    }
    private static int getNextIndex(Map<Integer,Integer> map, boolean flag){
        int returnValue=0;
        if(map.size()==0)
            returnValue=-1;
        else if(flag)
            returnValue=map.get(map.keySet().stream().min(Integer::compareTo).get());
        else 
            returnValue=map.get(map.keySet().stream().max(Integer::compareTo).get());
        return returnValue;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> list;
        int count=1;
        try{
            sc=new Scanner(System.in);
            list=new LinkedList<>();
            System.out.println("Enter the length of an array list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                list.add(sc.nextInt());
            for(int i=0;i<length-1;i++){
                if(OddEvenJumps.jumps(list.subList(i, list.size())))
                    count++;
            }
            System.out.println("Total number of good indicies : "+count);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
