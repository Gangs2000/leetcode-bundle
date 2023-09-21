package ZOHOQuestions;

import java.util.Scanner;

public class SnakePattern {
    public void printPattern2(int n){
        int number=1, start=n, end=(n*2)-1;
        for(int i=0;i<n;i++){      
            start--; end--;                  
            //To print left space..
            for(int space=0;space<start;space++)
                System.out.print("  ");
            //To print middle elements
            for(int j=start;j<=end;j++){                
                System.out.print(number+"  ");                                
                number+=(i%2==0)?(1):(-1);                
            }
            //Adding (n+1) (n-1) at the end of iteration for next round
            number+=(i%2==0)?(n-1):(n+1);             
            //To print right space            
            for(int space=end;space<(n*2)-2;space++)                
                System.out.print(" ");                 
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            new SnakePattern().printPattern2(n);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}