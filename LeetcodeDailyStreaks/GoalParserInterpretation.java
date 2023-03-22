package LeetcodeDailyStreaks;

import java.util.Scanner;

public class GoalParserInterpretation {
    String parser="";        
    public String interpret(String command) {        
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='(' && command.charAt(i+1)==')')
                parser+='o';
            else if(command.charAt(i)=='(' && command.charAt(i+2)==')')
                parser+="al";            
            else if(command.charAt(i)!='(' && command.charAt(i)!=')')
                parser+=command.charAt(i);            
        }        
        return parser;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to parse the Goal : ");
            String command=sc.next();                        
            System.out.println(new GoalParserInterpretation().interpret(command));            
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
