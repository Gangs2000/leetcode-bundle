import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindTheJudgeTown {
    Map<Integer, List<Integer>> mapper;
    public FindTheJudgeTown(){
        mapper=new LinkedHashMap<>();
    }
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0)
            return 1;
        for(int i=0;i<trust.length;i++){
            if(mapper.containsKey(trust[i][1])){
                List<Integer> tempList=mapper.get(trust[i][1]);
                tempList.add(trust[i][0]);
                mapper.put(trust[i][1], tempList);
            }
            else{
                List<Integer> list=new LinkedList<>();
                list.add(trust[i][0]);
                mapper.put(trust[i][1], list);
            }
        }        
        for(Map.Entry<Integer, List<Integer>> entry : mapper.entrySet()){            
            if(entry.getValue().size()==n-1 && !isCurrentKeyJudge(entry.getValue(), entry.getKey()))
                return entry.getKey();
        }
        return -1;
    }
    public boolean isCurrentKeyJudge(List<Integer> list, int key){
        for(int element : list){
            if(mapper.containsKey(element)){
                if(mapper.get(element).contains(key))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] trust;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter length of trust array : ");
            int length=sc.nextInt();
            trust=new int[length][2];
            for(int i=0;i<length;i++){
                trust[i][0]=sc.nextInt();
                trust[i][1]=sc.nextInt();
            }
            System.out.println(new FindTheJudgeTown().findJudge(n, trust));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
