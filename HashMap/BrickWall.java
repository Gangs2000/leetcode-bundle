import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BrickWall {
    Map<Integer, Integer> mapper;
    public BrickWall(){
        mapper=new LinkedHashMap<>();
    }
    public int leastBricks(List<List<Integer>> wall) {
        for(int eachRow=0;eachRow<wall.size();eachRow++){
            int prefixSum=0;
            for(int j=0;j<wall.get(eachRow).size()-1;j++){
                prefixSum+=wall.get(eachRow).get(j);
                if(mapper.containsKey(prefixSum))
                    mapper.put(prefixSum, mapper.get(prefixSum)+1);
                else
                    mapper.put(prefixSum, 1);
            }
        }
        return (mapper.size()==0)?(wall.size()):(wall.size()-mapper.values().stream().max(Integer::compareTo).get());
    }
    public static void main(String[] args){
        Scanner sc;
        List<List<Integer>> wall;
        try{
            sc=new Scanner(System.in);
            wall=new LinkedList<>();
            System.out.println("Enter length of list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++){
                List<Integer> eachRow=new LinkedList<>();
                System.out.println("Enter number of elements in each row : ");
                int elementLength=sc.nextInt();
                for(int j=0;j<elementLength;j++)
                    eachRow.add(sc.nextInt());
                wall.add(eachRow);
            }
            System.out.println(new BrickWall().leastBricks(wall));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
