import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import FunctionalInterface.Function;

class ProjectionOf3d{
    public static long topView(List<List<Integer>> list){
        long top=0;
        for(int i=0;i<list.size();i++)
            top+=list.get(i).stream().filter(element->element!=0).count();
        return top;
    }
    public static long frontView(List<List<Integer>> list){
        long front=0;
        for(int i=0;i<list.size();i++)
            front+=list.get(i).stream().max(Integer::compareTo).get();
        return front;
    }
    public static long sideView(List<List<Integer>> list){
        long side=0;
        for(int i=0;i<list.size();i++){
            List<Integer> subList=new ArrayList<>();
            for(int j=0;j<list.size();j++)
                subList.add(list.get(j).get(i));
            side+=subList.stream().max(Integer::compareTo).get();
        }
        return side;
    }
    public static void main(String[] args){
        List<List<Integer>> mainList;
        Scanner sc;
        long numOfBlocks=0;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            mainList=new ArrayList<>();
            for(int i=0;i<n;i++){
                List<Integer> subList=new ArrayList<>();
                for(int j=0;j<n;j++){
                    int value=sc.nextInt();
                    if(value>=0 && value<=50)
                        subList.add(value);
                    else
                        throw new Exception("Values must be fallen in the range of 0-50..");
                }
                mainList.add(subList);
            }
            Function<List<List<Integer>>,Long> topView=ProjectionOf3d::topView;
            numOfBlocks+=topView.apply(mainList);
            Function<List<List<Integer>>,Long> frontView=ProjectionOf3d::frontView;
            numOfBlocks+=frontView.apply(mainList);
            Function<List<List<Integer>>,Long> sideView=ProjectionOf3d::sideView;
            numOfBlocks+=sideView.apply(mainList);
            System.out.println("Total area of all three projections TOP, FRONT and SIDE Views : "+numOfBlocks);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}