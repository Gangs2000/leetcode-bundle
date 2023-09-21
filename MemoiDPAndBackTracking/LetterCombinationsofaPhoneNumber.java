package MemoiDPAndBackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LetterCombinationsofaPhoneNumber {
    Map<Character, String> phoneMap;
    List<String> resultList;
    public LetterCombinationsofaPhoneNumber(){
        resultList=new LinkedList<>();
        phoneMap=new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0)            
            findAllPossibilities(digits, 0, new StringBuilder());
        return resultList;
    }
    public void findAllPossibilities(String digits, int charIndex, StringBuilder stringBuilder){
        if(stringBuilder.length()==digits.length()){            
            resultList.add(stringBuilder.toString());
            return ;
        }        
        if(charIndex>=digits.length())
            return ;        
        String label=phoneMap.get(digits.charAt(charIndex));        
        for(int i=0;i<label.length();i++){
            stringBuilder.append(label.charAt(i));
            findAllPossibilities(digits, charIndex+1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            findAllPossibilities(digits, charIndex+1, stringBuilder);
        }
    }   
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter digit to find out all permutations : ");
            String digits=sc.next();
            System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations(digits));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
