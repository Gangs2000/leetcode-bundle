import java.util.Scanner;

public class BrokenCalculator {    
    int steps=0;
    public int brokenCalc(int startValue, int target) {        
        if(startValue>target)
            return startValue-target;
        else{
            while(target>startValue){
                if(target%2==0)
                    target=target/2;
                else if(target%2==1)
                    target++;
                steps++;
            }            
        }
        if(target!=startValue)
            steps+=startValue-target;                
        return steps;
    }    
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Start Value and Target Value :");
            int startValue=sc.nextInt();
            int target=sc.nextInt();
            System.out.println(new BrokenCalculator().brokenCalc(startValue, target));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
