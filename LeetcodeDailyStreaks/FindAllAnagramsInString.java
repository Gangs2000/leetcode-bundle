package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInString {
    List<Integer> result;
    public FindAllAnagramsInString(){
        result=new LinkedList<>();
    }
    public List<Integer> findAnagrams(String s, String p) {
        //Sort P chars in ascending order and store it again in P
        char[] arr=p.toCharArray();
        Arrays.sort(arr);
        p=String.valueOf(arr);   
        int limit=s.length()-(p.length())+1;     
        for(int i=0;i<limit;i++){
            char[] getSubChars=s.substring(i, i+p.length()).toCharArray(); 
            Arrays.sort(getSubChars);
            if(String.valueOf(getSubChars).equals(p))
                result.add(i);           
        } 
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S and P values : ");
            String s=sc.next();
            String p=sc.next();
            System.out.println(new FindAllAnagramsInString().findAnagrams(s, p));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
