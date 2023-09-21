package ZOHOQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PascalPattern {
    List<Long> list, tempList;
    public PascalPattern(){
        list=new LinkedList<>();
        tempList=new LinkedList<>();
    }
    public void printPascalPattern(int n){
        //List Method
        for(int i=0;i<n;i++){            
            //Print spaces..
            for(int space=0;space<n-i-1;space++)
                System.out.print(" ");
            //Check if it is a first row
            if(i==0){
                tempList.add((long) 1);
                System.out.print(1+" ");
            }
            //Check if it is a second row
            else if(i==1){
                tempList.add((long) 1);
                tempList.add((long) 1);
                System.out.print(1+" "+1+" ");
            }
            else{                
                tempList.add((long) 1);
                System.out.print(1+" ");
                for(int j=1;j<=i-1;j++){
                    tempList.add((long) list.get(j-1)+list.get(j));
                    System.out.print(list.get(j-1)+list.get(j)+" ");
                }
                tempList.add((long) 1);
                System.out.print(1+" ");                                
            }               
            list.clear(); list.addAll(tempList); tempList.clear();           
            System.out.println();
        }

        //Using factorial process
        for(int i=0;i<n;i++){
            //Print spaces
            for(int space=0;space<n-i-1;space++)
                System.out.print(" ");
            for(int j=0;j<=i;j++)
                System.out.print(factorial((long) i)/((factorial(((long) i- (long) j))*factorial((long) j)))+" ");
            System.out.println();
        }
    }
    public long factorial(long number){
        if(number==0)
            return 1;
        return number*factorial(number-1);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value to print pascal triangle : ");
            int n=sc.nextInt();
            new PascalPattern().printPascalPattern(n);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
