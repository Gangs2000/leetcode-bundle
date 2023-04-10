import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OptimalPartitionOfString {
    List<Character> list;
    int optimalPartition=1;
    public OptimalPartitionOfString(){
        list=new LinkedList<>();
    }
    public int partitionString(String s) {        
        for(int i=0;i<s.length();i++){
            if(list.contains(s.charAt(i))){
                optimalPartition++;
                list.clear();
                list.add(s.charAt(i));                
            }
            else
                list.add(s.charAt(i));            
        }        
        return optimalPartition;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new OptimalPartitionOfString().partitionString(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
