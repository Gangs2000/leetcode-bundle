import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
    Map<String, Integer> countStr;
    List<String> result;
    public RepeatedDNASequence(){
        countStr=new HashMap<>();
        result=new LinkedList<>();
    }
    public List<String> findRepeatedDnaSequences(String s) {        
        result.stream().sorted().collect(Collectors.toList());
        if(s.length()>=10){
            int end=s.length()-10;
            for(int i=0;i<=end;i++){
                String subStr=s.substring(i, i+10);
                if(countStr.containsKey(subStr)){
                    countStr.put(subStr, countStr.get(subStr)+1);
                    if(!result.contains(subStr))
                        result.add(subStr);
                }
                else
                    countStr.put(subStr, 1);
            }
        }        
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter DNA Molecule : ");
            String dnaStr=sc.next().toUpperCase();
            System.out.println(new RepeatedDNASequence().findRepeatedDnaSequences(dnaStr));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
