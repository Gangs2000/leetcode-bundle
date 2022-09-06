import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import FunctionalInterface.Function;

public class SkyLineProblem {
    private static List<List<Integer>> skyLine(List<List<Integer>> list){
        List<List<Integer>> output=new ArrayList<>();
        //Starting point
        output.add(List.of(list.get(0).get(0),list.get(0).get(2)));
        //Middle points
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).get(1)<list.get(i+1).get(0)){
                output.add(List.of(list.get(i).get(1),0));
                output.add(List.of(list.get(i+1).get(0),list.get(i+1).get(2)));
            }
            else if(list.get(i).get(1)>list.get(i+1).get(0) && list.get(i).get(2)<list.get(i+1).get(2))
                output.add(List.of(list.get(i+1).get(0),list.get(i+1).get(2)));
            else if(list.get(i).get(1)>list.get(i+1).get(0) && list.get(i).get(2)>list.get(i+1).get(2))
                output.add(List.of(list.get(i).get(1),list.get(i+1).get(2)));
        }
        //Ending point
        output.add(List.of(list.get(list.size()-1).get(1),0));
        return output;
    }
    public static void main(String[] args){
        Scanner sc;
        List<List<Integer>> buildings;
        try{
            sc=new Scanner(System.in);
            buildings=new ArrayList<>();
            System.out.println("Enter length of list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++){
                List<Integer> subList=new ArrayList<>();
                System.out.println("Enter X1 Value : ");
                int x1=sc.nextInt();
                System.out.println("Enter X2 Value : ");
                int x2=sc.nextInt();
                System.out.println("Enter Y Value : ");
                int y=sc.nextInt();
                subList.add(x1); subList.add(x2); subList.add(y);
                buildings.add(subList);
            }
            Function<List<List<Integer>>,List<List<Integer>>> skyLine=SkyLineProblem::skyLine;
            System.out.println(skyLine.apply(buildings));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
