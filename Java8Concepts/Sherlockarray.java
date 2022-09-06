import FunctionalInterface.Function;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class Sherlockarray {
    public static void main(String[] args){
        Scanner sc;
        List<Integer> list;
        try{
            sc=new Scanner(System.in);
            list=new ArrayList<Integer>();
            System.out.println("Enter size of an arraylist : ");
            int size=sc.nextInt();
            for(int i=0;i<size;i++)
                list.add(sc.nextInt());
            Function<List<Integer>,String> obj=(element)->{
                List<Integer> temp1,temp2;
                temp1=element.subList(0,(element.size()/2));
                temp2=element.subList((element.size()/2)+1,element.size());
                return (temp1.stream().reduce(0,(a,b)->(a+b))==temp2.stream().reduce(0,(a,b)->(a+b)))?("YES"):("NO");
            };
            System.out.println(obj.apply(list));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
