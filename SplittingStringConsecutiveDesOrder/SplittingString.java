package SplittingStringConsecutiveDesOrder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SplittingString {
    private static String removeTrailZeroes(String string){
        int index=0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)!='0'){
                index=i;
                break;
            }
        }
        return string.substring(index);
    }
    private static Map<Integer,String> splitByValue(int splitByValue,String string){
        Map<Integer,String> map=new LinkedHashMap<>();
        for(int i=0;i<=string.length()-splitByValue;){
            if(string.charAt(i)!='0')
                map.put(i,string.substring(i, i+splitByValue));
            i=(string.charAt(i)!='0')?(i+splitByValue):(i+1);
        }
        return map;
    }
    private static boolean verifySortingOrderAndDifference(Map<Integer,String> map,String string){
        boolean flag=true;
        List<Integer> list=map.values().stream().map(value->Integer.parseInt(value)).collect(Collectors.toList());
        for(int i=0;i<list.size()-1;i++){
            if(!(list.get(i)>list.get(i+1) && list.get(i)-list.get(i+1)==1)){
                flag=false;
                break;
            }
        }
        int lastKey=map.keySet().stream().max(Integer::compareTo).get();
        return (flag)?((string.length()-map.get(lastKey).length()==lastKey)?(true):(false)):(false);
    }
    public static void main(String[] args){
        Scanner sc;
        String string;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the String to find out consecutive descending order : ");
            string=SplittingString.removeTrailZeroes(sc.next());
            boolean flag=false;
            for(int i=1;i<(string.length()/2)+1;i++){
                Map<Integer,String> map=SplittingString.splitByValue(i,string);
                if(SplittingString.verifySortingOrderAndDifference(map,string)){
                    flag=true;
                    break;
                }
            }
            System.out.println("Given string can be splitted into descending consecutive order : "+flag);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
