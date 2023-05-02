package Inheritence;

import java.util.Scanner;

public class ArithOperation implements Addition, Subtraction {

    @Override
    public int addTwoNum(int a, int b) {                
        System.out.println("Adding two numbers : ");
        return a+b;
    }

    @Override
    public int subtraction(int a, int b) {        
        System.out.println("Subtracting two numbers : ");
        return a-b;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArithOperation arithOperation=new ArithOperation();
        boolean flag=true;
        int a,b;
        while(flag){
            System.out.println("Enter 1 to add, 2 to subtract and 3 to stop : ");
            int operation=sc.nextInt();
            if(operation==1){
                System.out.println("Enter two numbers to add : ");
                a=sc.nextInt();
                b=sc.nextInt();
                System.out.println("Addition : "+arithOperation.addTwoNum(a, b));                
            }      
            else if(operation==2){
                System.out.println("Enter two numbers to subtract : ");
                a=sc.nextInt();
                b=sc.nextInt();
                System.out.println("Subtraction : "+arithOperation.subtraction(a, b));
            }
            else
                flag=false;
        }
        sc.close();
    }
    
}
