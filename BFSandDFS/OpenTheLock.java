import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class OpenTheLock {
    List<String> queue;
    Set<String> visited, deadEndSet;
    int level=0;
    public OpenTheLock(){
        queue=new LinkedList<>();
        visited=new HashSet<>();
    }
    public int openLock(String[] deadends, String target) {
        deadEndSet=new HashSet<>(Arrays.asList(deadends));
        queue.add("0000");
        visited.add("0000");
        while(!queue.isEmpty()){
            int start=0, end=queue.size();
            while(start<end){
                String currentString=queue.get(0);
                if(deadEndSet.contains(currentString)){
                    start++;
                    queue.remove(0);
                    continue;
                }
                if(currentString.equals(target))
                    return level;
                List<String> addValidCombinations=this.findValidCombos(currentString);
                for(String string : addValidCombinations){
                    if(!visited.contains(string)){
                        queue.add(string);
                        visited.add(string);
                    }
                }
                queue.remove(0);
                start++;
            }
            level++;
        }
        return -1;
    }
    public List<String> findValidCombos(String string){
        List<String> validList=new LinkedList<>();
        for(int i=0;i<string.length();i++){
            StringBuilder builder=new StringBuilder(string);
            builder.setCharAt(i, (char) ((string.charAt(i)=='9')?('0'):(string.charAt(i)+1)));
            validList.add(builder.toString());
            builder.setCharAt(i, (char) ((string.charAt(i)=='0')?('9'):(string.charAt(i)-1)));
            validList.add(builder.toString());
        }
        return validList;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] deadEnds;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of deadends array : ");
            int length=sc.nextInt();
            deadEnds=new String[length];
            for(int i=0;i<length;i++)
                deadEnds[i]=sc.useDelimiter("\r").next();
            System.out.println("Enter target string : ");
            String target=sc.useDelimiter("\r").next();
            System.out.println(new OpenTheLock().openLock(deadEnds, target));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
