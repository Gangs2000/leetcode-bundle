import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ContainsDuplicate {
    static List<Integer> listOfNums;
    static int indexDiff,valueDiff=0;
    static boolean flag=false;
    private static boolean containsDuplicate(int i, int j){
        if(i!=j && Math.abs(i-j)<=indexDiff && Math.abs(listOfNums.get(i)-listOfNums.get(j))<=valueDiff)
            flag=true;
        else{
            if(i!=listOfNums.size()-2){ 
                if(j==listOfNums.size()-1)                    
                    containsDuplicate(i+1, i+2);               //Recursive function call - This function will keep calling till size()-1                
                else
                    containsDuplicate(i, j+1);                 //Recursive function call - This function will keep calling till size()-2
            }
        }
        return flag;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            listOfNums=new LinkedList<>();           
            System.out.println("Enter Index and Value difference : ");            
            indexDiff=sc.nextInt();
            valueDiff=sc.nextInt();
            System.out.println("Enter the length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                listOfNums.add(sc.nextInt());
            System.out.println(ContainsDuplicate.containsDuplicate(0, 1));       //Calling method with initial index values            
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
