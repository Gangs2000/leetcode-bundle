package LeetcodeDailyStreaks;
import java.util.Arrays;
import java.util.Scanner;

public class AverageSalaryExcludingtheMinimumandMaximum {
    double totalSalary=0;    
    public double average(int[] salary) {
        Arrays.sort(salary);
        for(int i=1;i<salary.length-1;i++)
            totalSalary+=salary[i];       
        String formatedValue=(String.format("%.5f", totalSalary/(salary.length-2)));
        return Double.valueOf(formatedValue);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] salary;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of salary array : ");
            int length=sc.nextInt();
            salary=new int[length];
            for(int i=0;i<length;i++)
                salary[i]=sc.nextInt();
            System.out.println(new AverageSalaryExcludingtheMinimumandMaximum().average(salary));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
