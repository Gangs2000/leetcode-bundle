package ZOHOQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindPattern {
    List<Integer> queue;
    int count=0;
    public FindPattern(){
        queue=new LinkedList<>();
    }
    public int returnNumber(int n){
        switch(n){
            case 1 : return 3;
            case 2 : return 4;
        }
        //Initialize queue value
        queue.add(3); queue.add(4);
        count=count+2;
        while(true){  
            queue.add((queue.get(0)*10)+3);
            count++;
            if(n==count)
                return queue.get(queue.size()-1);
            queue.add((queue.get(0)*10)+4);
            count++;
            if(n==count)
                return queue.get(queue.size()-1);
            queue.remove(0);            
        }        
    }    
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value to return : ");
            int n=sc.nextInt();
            System.out.println(new FindPattern().returnNumber(n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
