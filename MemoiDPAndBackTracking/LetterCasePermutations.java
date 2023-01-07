package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LetterCasePermutations {
    List<String> output;
    public List<String> letterCasePermutation(String s) {
        output=new LinkedList<>();
        findAllPermutations(0, s, new StringBuilder());
        return output;
    }
    public void findAllPermutations(int index, String s, StringBuilder stringBuilder){
        if(index==s.length()){
            output.add(stringBuilder.toString());
            return ;
        }
        if(Character.isDigit(s.charAt(index))){
            stringBuilder.append(s.charAt(index));
            findAllPermutations(index+1, s, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);            
        }
        else{
            stringBuilder.append(s.charAt(index));
            findAllPermutations(index+1, s, stringBuilder);
            boolean flag1=Character.isUpperCase(stringBuilder.charAt(stringBuilder.length()-1));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            if(flag1)
                stringBuilder.append(Character.toLowerCase(s.charAt(index)));
            else
                stringBuilder.append(Character.toUpperCase(s.charAt(index)));
            findAllPermutations(index+1, s, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value to find out permutations : ");
            String str=sc.next();
            System.out.println(new LetterCasePermutations().letterCasePermutation(str));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
