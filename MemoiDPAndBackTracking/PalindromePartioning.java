package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartioning {
    List<List<String>> output;
    public PalindromePartioning(){
        output=new LinkedList<>();
    }
    public List<List<String>> partition(String s) {
        partitioning(s, 0, new LinkedList<>());
        return output;
    }
    public void partitioning(String s, int index, List<String> list){
        if(index==s.length()){
            output.add(new LinkedList<>(list));
            return ;
        }
        for(int i=1;i<=s.length();i++){
            if((index+i)<=s.length()){                
                if(s.substring(index, index+i).equals(new StringBuilder(s.substring(index, index+i)).reverse().toString())){
                    list.add(s.substring(index, index+i));
                    partitioning(s, index+i, list);
                    list.remove(list.size()-1);
                }                
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String string=sc.next();
            System.out.println(new PalindromePartioning().partition(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
