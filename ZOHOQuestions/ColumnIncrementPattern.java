package ZOHOQuestions;

import java.util.Scanner;

public class ColumnIncrementPattern{
    int prev=0;
    public void printPatter1(int n){
        for(int i=1;i<=n;i++){                      
            for(int j=1;j<=i;j++){       
                prev=(j==1)?(i):(prev+n-j+1);                
                System.out.print(prev+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){        
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            new ColumnIncrementPattern().printPatter1(n);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}