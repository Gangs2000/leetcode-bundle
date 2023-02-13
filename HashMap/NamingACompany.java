import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NamingACompany {
    long distinctNameCount=0;
    Map<String, Set<String>> mapper;
    public NamingACompany(){
        mapper=new HashMap<>();
    }
    public long distinctNames(String[] ideas) {
        for(int i=0;i<ideas.length;i++){
            if(mapper.containsKey(String.valueOf(ideas[i].charAt(0)))){
                Set<String> set=mapper.get(String.valueOf(ideas[i].charAt(0)));
                set.add(ideas[i].substring(1));
                mapper.put(String.valueOf(ideas[i].charAt(0)), set);
            }
            else{
                Set<String> set=new HashSet<>();
                set.add(ideas[i].substring(1));
                mapper.put(String.valueOf(ideas[i].charAt(0)), set);
            }
        }        
        this.identifyDistinctNamesFromMapper(mapper);
        return distinctNameCount;
    }
    public void identifyDistinctNamesFromMapper(Map<String, Set<String>> mapper){
        for(Map.Entry<String, Set<String>> entry1 : mapper.entrySet()){
            Set<String> root=entry1.getValue();
            for(Map.Entry<String, Set<String>> entry2 : mapper.entrySet()){
                if(entry1.getKey().equals(entry2.getKey()))
                    continue;        
                else{            
                    int commonDifference=0;
                    Set<String> child=entry2.getValue();                
                    for(String element : child){
                        if(root.contains(element))
                            commonDifference++;
                    }
                    distinctNameCount+=(root.size()-commonDifference)*(child.size()-commonDifference);
                }   
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        String[] ideas;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an ideas array : ");
            int length=sc.nextInt();
            ideas=new String[length];
            for(int i=0;i<length;i++)
                ideas[i]=sc.next();
            System.out.println(new NamingACompany().distinctNames(ideas));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
