import java.util.Scanner;
import java.util.function.Function;

public class NumberofSeniorCitizens {
    int seniorCitizenCount=0;
    public int countSeniors(String[] details) {
        for(String detail : details){
            int age=Integer.parseInt(detail.substring(11, 13));
            if(age>60)
                seniorCitizenCount++;
        }
        return seniorCitizenCount;
    }
    public static void main(String[] args) {
        Scanner sc;
        String[] details;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of details array : ");
            int length=sc.nextInt();
            details=new String[length];
            for(int i=0;i<length;i++)
                details[i]=sc.useDelimiter("\n").nextLine();
            Function<String[], Integer> function = (detailsArr) -> new NumberofSeniorCitizens().countSeniors(detailsArr);
            System.out.println(function.apply(details));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
