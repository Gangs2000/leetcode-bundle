import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitIntoBaskets {
    int result=Integer.MIN_VALUE, total=0, rightPointer=0, leftPointer=0;
    Map<Integer, Integer> mapper;
    public FruitIntoBaskets(){
        mapper=new HashMap<>();
    }
    public int totalFruit(int[] fruits) {
        while(rightPointer<fruits.length){
            mapper.put(fruits[rightPointer], mapper.getOrDefault(fruits[rightPointer], 0)+1);
            total++;
            while(mapper.size()>2){
                mapper.put(fruits[leftPointer], mapper.get(fruits[leftPointer])-1);
                total--;
                if(mapper.get(fruits[leftPointer])==0)
                    mapper.remove(fruits[leftPointer]);                    
                leftPointer++;
            }
            result=Math.max(result, total);
            rightPointer++;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] fruits;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of fruits array : ");
            int length=sc.nextInt();
            fruits=new int[length];
            for(int i=0;i<length;i++)
                fruits[i]=sc.nextInt();
            System.out.println(new FruitIntoBaskets().totalFruit(fruits));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
