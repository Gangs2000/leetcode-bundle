import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import FunctionalInterface.Function;

public class ReachingPoints {
    int target1,target2;
    public ReachingPoints(int target1,int target2){
        this.target1=target1;
        this.target2=target2;
    }
    private List<List<Integer>> performOperation(List<List<Integer>> list){
        List<List<Integer>> modifiedList=new LinkedList<>();
        for(int i=0;i<list.size();i++){
            int x=list.get(i).get(0);
            int y=list.get(i).get(1);
            if(x<=target1 && y<=target2 && (x+y)<=target2)
                modifiedList.add(List.of(x,(x+y)));
            if(x<=target1 && y<=target2 && (x+y)<=target1)
                modifiedList.add(List.of((x+y),y));
        }
        return modifiedList;
    }
    public static void main(String[] args){
        Scanner sc;
        List<List<Integer>> list;
        boolean flag=false;
        try{
            sc=new Scanner(System.in);
            list=new LinkedList<>();
            System.out.println("Enter initial values : ");
            list.add(List.of(sc.nextInt(),sc.nextInt()));
            System.out.println("Enter target values : ");
            ReachingPoints object=new ReachingPoints(sc.nextInt(), sc.nextInt());
            while(true){
                Function<List<List<Integer>>,List<List<Integer>>> interObject=object::performOperation;
                list=interObject.apply(list);
                for(int i=0;i<list.size();i++){
                    if(list.get(i).get(0)==object.target1 && list.get(i).get(1)==object.target2){
                        flag=true;
                        break;
                    }
                }
                if(list.size()==0 || flag)
                    break;
            }
            System.out.println("Reaching point possibility is : "+flag);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
