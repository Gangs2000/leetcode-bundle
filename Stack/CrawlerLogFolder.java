package Stack;

import java.util.Scanner;
import java.util.Stack;

public class CrawlerLogFolder {
    Stack<String> stack;
    public CrawlerLogFolder(){
        stack=new Stack<>();
    }
    public int minOperations(String[] logs) {
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../")){
                if(stack.size()!=0)
                    stack.pop();
            }
            else if(!logs[i].equals("./"))
                stack.push(logs[i]);
        }
        return stack.size();
    }
    public static void main(String[] args){
        Scanner sc;
        String[] logs;
        try{    
            sc=new Scanner(System.in);
            System.out.println("Enter length of logs array : ");
            int length=sc.nextInt();
            logs=new String[length];
            for(int i=0;i<length;i++)
                logs[i]=sc.useDelimiter("\n").next();
            System.out.println(new CrawlerLogFolder().minOperations(logs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
