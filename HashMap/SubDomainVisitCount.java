import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {
    List<String> result;
    Map<String, Integer> countVisitedDomains;
    public SubDomainVisitCount(){
        result=new LinkedList<>();
        countVisitedDomains=new HashMap<>();
    }
    public List<String> subdomainVisits(String[] cpdomains) {        
        for(int i=0;i<cpdomains.length;i++){
            String[] splitSpace=cpdomains[i].split(" ");            
            char[] chars=splitSpace[1].toCharArray();
            List<Integer> dotIndicies=new LinkedList<>();
            for(int check=0;check<chars.length;check++){
                if(chars[check]=='.')
                    dotIndicies.add(check);
            }
            this.mappingVisitedDomains(splitSpace[1], Integer.valueOf(splitSpace[0]));
            dotIndicies.stream().forEach(index->{
                String subString=splitSpace[1].substring(index+1);
                this.mappingVisitedDomains(subString, Integer.valueOf(splitSpace[0]));
            });            
        }
        for(Map.Entry<String, Integer> entry : countVisitedDomains.entrySet())
            result.add(entry.getValue()+" "+entry.getKey());
        return result;        
    }
    public void mappingVisitedDomains(String subDomain, int count){
        if(countVisitedDomains.containsKey(subDomain))
            countVisitedDomains.put(subDomain, countVisitedDomains.get(subDomain)+count);
        else
            countVisitedDomains.put(subDomain, count);
    }
    public static void main(String[] args){
        Scanner sc;
        String[] cpdomains;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of cpdomains array : ");
            int length=sc.nextInt();
            cpdomains=new String[length];
            for(int i=0;i<length;i++)
                cpdomains[i]=sc.useDelimiter("\n").next();
            System.out.println(new SubDomainVisitCount().subdomainVisits(cpdomains));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
