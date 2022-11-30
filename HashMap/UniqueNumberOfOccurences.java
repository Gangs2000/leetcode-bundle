import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueNumberOfOccurences {
    Map<Integer, Integer> mapper;
    public UniqueNumberOfOccurences(){
        mapper=new LinkedHashMap<>();
    }
    public boolean uniqueOccurrences(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(mapper.containsKey(arr[i]))
                mapper.put(arr[i], mapper.get(arr[i])+1);
            else
                mapper.put(arr[i], 1);
        }
        return mapper.values().stream().distinct().count()==mapper.size();
    }
    public static void main(String[] args){
        Scanner sc;
        int[] arr;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            arr=new int[length];
            for(int i=0;i<length;i++)
                arr[i]=sc.nextInt();
            System.out.println(new UniqueNumberOfOccurences().uniqueOccurrences(arr));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
