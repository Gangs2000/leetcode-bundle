import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestPalindromeByConcatinating2Words {
    int longestPalindromeLength=0;
    Map<String, Integer> mapper;
    public LongestPalindromeByConcatinating2Words(){
        mapper=new HashMap<>();
    }
    public int longestPalindrome(String[] words) {
        List<String> stringList=Stream.of(words).collect(Collectors.toList());
        for(int i=0;i<stringList.size();i++){
            if(!stringList.get(i).equals("")){
                if(stringList.get(i).charAt(0)!=stringList.get(i).charAt(1)){
                    StringBuilder strBuilder=new StringBuilder(stringList.get(i));                                        
                    if(stringList.contains(strBuilder.reverse().toString())){                                                                
                        longestPalindromeLength+=stringList.get(i).length()*2;                                                 
                        stringList.set(stringList.indexOf(strBuilder.toString()), "");             
                    }                    
                }
                else{
                    if(!mapper.containsKey(stringList.get(i)))
                        mapper.put(stringList.get(i), 2);
                    else    
                        mapper.put(stringList.get(i), mapper.get(stringList.get(i))+2);
                }                
                stringList.set(i,"");  
            }
        }                
        if(mapper.size()!=0)
            longestPalindromeLength+=this.accumulateValuesFromMapper(mapper);
        return longestPalindromeLength;   
    }
    public int accumulateValuesFromMapper(Map<String,Integer> mapper){
        int accumulate=0;        
        List<Integer> values=mapper.values().stream().collect(Collectors.toList());            
        while(this.areAllElementsGreaterThan2(values)){
            for(int i=0;i<values.size();i++){
                if(values.get(i)>2){
                    accumulate+=(values.get(i)/4)*4;
                    values.set(i, values.get(i)-(values.get(i)/4)*4);
                }
            }
        }                      
        return (values.size()==0)?(accumulate):((values.size()==1)?(accumulate+values.get(0)):(accumulate+2));
    }
    public boolean areAllElementsGreaterThan2(List<Integer> values){
        boolean flag=false;
        for(int i=0;i<values.size();i++){
            if(values.get(i)>2){
                flag=true;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] words;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of the words array : ");   
            int length=sc.nextInt();
            words=new String[length]; 
            for(int i=0;i<length;i++)
                words[i]=sc.next();
            System.out.println(new LongestPalindromeByConcatinating2Words().longestPalindrome(words));
        }
        catch(Exception exception){
            System.out.println("Exception occured : "+exception.getMessage());
            exception.printStackTrace();
        }
    }
}
