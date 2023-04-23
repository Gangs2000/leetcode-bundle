import java.util.Scanner;
import java.util.Stack;

public class DecodedStringAtIndex {
    Stack<String> stack;
    public DecodedStringAtIndex(){
        stack=new Stack<>();
        stack.push("");
    }
    public String decodeAtIndex(String s, int k) {
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                String poppedStr=stack.pop();
                int count=Integer.valueOf(String.valueOf(s.charAt(i)));
                String temp=poppedStr;
                for(int iteration=0;iteration<count-1;iteration++)
                    temp+=poppedStr;
                stack.push(temp);                               
            }
            else                
                stack.push(stack.pop()+s.charAt(i));
        }
        return String.valueOf(stack.peek().toString().charAt(k-1));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next().toLowerCase();
            System.out.println("Enter Index value to be retrieved after decoding it : ");
            int k=sc.nextInt();
            System.out.println(new DecodedStringAtIndex().decodeAtIndex(s, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
