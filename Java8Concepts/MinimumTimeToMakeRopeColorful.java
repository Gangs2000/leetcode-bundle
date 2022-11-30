import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import FunctionalInterface.BiFunction;

public class MinimumTimeToMakeRopeColorful {
    private static int returnMinimumTimeNeededToMakeColorfulRope(StringBuilder stringBuilder, List<Integer> neededTime){
        int minimumTime=0;
        for(int i=0;i<stringBuilder.length()-1;i++){
            if(stringBuilder.charAt(i)==stringBuilder.charAt(i+1)){
                if(neededTime.get(i)<neededTime.get(i+1)){
                    minimumTime+=neededTime.get(i);
                    stringBuilder.deleteCharAt(i);
                    neededTime.remove(i);
                }
                else{
                    minimumTime+=neededTime.get(i+1);
                    stringBuilder.deleteCharAt(i+1);
                    neededTime.remove(i+1);
                }
            }
        }
        return minimumTime;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> neededTime;
        String balloons;
        try{
            sc=new Scanner(System.in);
            neededTime=new LinkedList<>();
            System.out.println("Enter colors : ");
            balloons=sc.nextLine();
            StringBuilder stringBuilder=new StringBuilder(balloons);
            for(int i=0;i<balloons.length();i++)
                neededTime.add(sc.nextInt());
            BiFunction<StringBuilder, List<Integer>, Integer> object=MinimumTimeToMakeRopeColorful::returnMinimumTimeNeededToMakeColorfulRope;
            System.out.println("Minimum time required to make the rope colorful "+object.apply(stringBuilder, neededTime));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
