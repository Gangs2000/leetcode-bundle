package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CamelCaseMatching {
    List<Boolean> resultList;
    public CamelCaseMatching(){
        resultList=new LinkedList<>();
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        for(int i=0;i<queries.length;i++)
            resultList.add(this.checkIfQueryIsValid(queries[i], pattern));
        return resultList;    
    }
    public boolean checkIfQueryIsValid(String query, String pattern){
        int queryIndex=0, patternIndex=0;
        while(patternIndex<pattern.length()){
            boolean isUpperCase=Character.isUpperCase(pattern.charAt(patternIndex));            
            while(queryIndex<query.length()){
                if(isUpperCase){                    
                    if(Character.isUpperCase(query.charAt(queryIndex)) && query.charAt(queryIndex)!=pattern.charAt(patternIndex))                     
                        return false;
                    if(Character.isUpperCase(query.charAt(queryIndex)) && query.charAt(queryIndex)==pattern.charAt(patternIndex))                               
                        break;
                }
                else{                    
                    if(Character.isUpperCase(query.charAt(queryIndex)))
                        return false;
                    if(Character.isLowerCase(query.charAt(queryIndex)) && query.charAt(queryIndex)==pattern.charAt(patternIndex))                        
                        break;
                }   
                queryIndex++;
            }            
            patternIndex++; queryIndex++;
        }           
        if(queryIndex>query.length())
            return false;
        else
            return query.substring(queryIndex).matches((".*[A-Z].*"))?(false):(true);            
    }
    public static void main(String[] args){
        Scanner sc;
        String[] queries;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of queries array : ");
            int length=sc.nextInt();
            queries=new String[length];
            for(int i=0;i<length;i++)
                queries[i]=sc.next();
            System.out.println("Enter Pattern value : ");
            String pattern=sc.next();
            System.out.println(new CamelCaseMatching().camelMatch(queries, pattern));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
