import java.util.PriorityQueue;
import java.util.Scanner;

public class SortVowelsinaString {
    PriorityQueue<Character> charPq;
    PriorityQueue<Integer> intPq;
    StringBuilder resultString;
    public SortVowelsinaString(){
        charPq=new PriorityQueue<>();
        intPq=new PriorityQueue<>();
    }
    public String sortVowels(String s) {
        for(int i=0;i<s.length();i++){
            char currentChar=s.charAt(i);
            if(currentChar=='A' || currentChar=='E' || currentChar=='I' || currentChar=='O' || currentChar=='U' || 
            currentChar=='a' || currentChar=='e' || currentChar=='i' || currentChar=='o' || currentChar=='u'){
                charPq.add(currentChar);
                intPq.add(i);
            }
        }    
        resultString=new StringBuilder(s);
        while(!charPq.isEmpty()){
            char currentChar=charPq.poll();
            int index=intPq.poll();
            resultString.setCharAt(index, currentChar);
        }
        return resultString.toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String string=sc.next();
            System.out.println(new SortVowelsinaString().sortVowels(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
