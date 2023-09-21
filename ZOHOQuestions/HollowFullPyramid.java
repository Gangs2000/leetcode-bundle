package ZOHOQuestions;

import java.util.Scanner;

public class HollowFullPyramid {
    public void printHollowFullPyramid(int n){              
        for(int i=1;i<=n;i++){
            for(int space=1;space<=n-i;space++)
                System.out.print(" ");
            byte byteValue=65;              
            for(int j=1;j<=i;j++){                    
                if(i!=n){         
                    if(j==1 || j==i)
                        System.out.print((char) byteValue+" ");
                    else
                        System.out.print("  ");         
                    byteValue++;    
                }
                else if(i==n){
                    System.out.print((char) byteValue+" ");
                    byteValue++;
                }
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
            new HollowFullPyramid().printHollowFullPyramid(n);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
