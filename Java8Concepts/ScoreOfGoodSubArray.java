import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import FunctionalInterface.Function;

public class ScoreOfGoodSubArray {
    private static int subArrayScore(List<Integer> list){             
        return list.stream().min(Integer::compareTo).get();
    }
    public static void main(String[] srgs){
        Scanner sc;
        List<Integer> listOfIntergers;
        int maxScore=0;        
        try{
            sc=new Scanner(System.in);
            listOfIntergers=new LinkedList<>();
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                listOfIntergers.add(sc.nextInt());
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            for(int i=0;i<=k;i++){                                                              //Setting outer loop (i) to bound till K value
                for(int j=k;j<listOfIntergers.size();j++){                                      //Setting inner loop (j) to start from K value since condition is i<=k<=j
                    Function<List<Integer>,Integer> object=ScoreOfGoodSubArray::subArrayScore;
                    if(listOfIntergers.subList(i, j).size()!=0){                        
                        int currentScore=object.apply(listOfIntergers.subList(i, j+1))*(j-i+1);                                        
                        if(currentScore>maxScore)
                            maxScore=currentScore;
                    }
                }
            }
            System.out.println("Maximum score of good subarray is "+maxScore);
        }
        catch(Exception e){
            System.out.println("Exception occured "+e.getMessage());
            e.printStackTrace();
        }
    }
}
