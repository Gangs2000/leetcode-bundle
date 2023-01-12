import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SortThePeople {
    String[] tallToShort;
    Map<Integer, String> map;
    public String[] sortPeople(String[] names, int[] heights) {        
        tallToShort=new String[names.length];        
        map=new LinkedHashMap<>();                
        for(int i=0;i<heights.length;i++)
            map.put(heights[i], names[i]);
        for(int i=0;i<heights.length;i++){
            for(int j=i+1;j<heights.length;j++){
                if(heights[i]<heights[j]){
                    heights[i]=heights[i]+heights[j];
                    heights[j]=heights[i]-heights[j];
                    heights[i]=heights[i]-heights[j];
                }
            }
        }
        for(int i=0;i<heights.length;i++)
            tallToShort[i]=map.get(heights[i]);
        return tallToShort;
    }
    public static void main(String[] args){        
        Scanner sc;
        int[] heights;
        String[] names;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of heights array : ");
            int length=sc.nextInt();
            heights=new int[length];
            names=new String[length];
            for(int i=0;i<length;i++){
                heights[i]=sc.nextInt();
                names[i]=sc.next();
            }
            System.out.println(new SortThePeople().sortPeople(names, heights));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
