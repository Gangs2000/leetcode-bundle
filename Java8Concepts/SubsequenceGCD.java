import FunctionalInterface.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class SubsequenceGCD {
    private static int gcdOfNums(int a,int b){
        if(a==0)
            return b;
        return gcdOfNums(b%a,a);
    }
    private static int gcdListNms(List<Integer> list)
    {
        int output=0;
        boolean flag=true;
        for(int i=0;i<list.size();i++){
            if(flag){
                output=gcdOfNums(list.get(0),list.get(1));
                flag=false;
            }
            else
                output=gcdOfNums(output,list.get(i));
        }
        return output;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> list;
        int size,gcdCount=0;
        try{
            sc=new Scanner(System.in);
            list=new ArrayList<Integer>();
            System.out.println("Enter the size of an arraylist : ");
            size=sc.nextInt();
            for(int i=0;i<size;i++){
                int element=sc.nextInt();
                if(!list.contains(element))
                    gcdCount++;
                list.add(element);
            }
            for(int i=0;i<size;i++){
                for(int j=0;j<size-(i+1);j++){
                    for(int k=j+i+1;k<size;k++){
                        int output=0;
                        if(list.subList(j,(j+i+1)).size()==1){
                            BiFunction<Integer,Integer,Integer> obj=SubsequenceGCD::gcdOfNums;
                            output=obj.apply(list.subList(j,(j+i+1)).get(0),list.get(k));
                        }
                        else{
                            Function<List<Integer>,Integer> obj1=SubsequenceGCD::gcdListNms;
                            BiFunction<Integer,Integer,Integer> obj2=SubsequenceGCD::gcdOfNums;
                            output=obj2.apply(obj1.apply(list.subList(j,(j+i+1))),list.get(k));
                        }
                        //Adding element into list if GCD value is not present and incremenet count value by 1
                        if(!list.contains(output)){
                            gcdCount++;
                            list.add(output);
                        }
                    }
                }
            }
            System.out.println("Number of Different Subsequences GCDs "+gcdCount);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
