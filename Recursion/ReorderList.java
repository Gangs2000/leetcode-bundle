import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReorderList {
    List<Integer> numbers,reorderedList;
    public ReorderList(List<Integer> numbers){
        this.numbers=numbers;
        reorderedList=new LinkedList<>();
    }
    private List<Integer> reOrderList(boolean flag){
        if(numbers.size()!=0) {             
            if(flag){
                reorderedList.add(numbers.get(0));                      //If true fetching 0-th index value and removing it from list after adding it to reorder list
                numbers.remove(0);
                flag=false;
            }
            else {
                reorderedList.add(numbers.get(numbers.size()-1));       //If false fetching n-1 th index value and removing it from list after adding it to reorder list
                numbers.remove(numbers.size()-1);
                flag=true;
            }
            this.reOrderList(flag);
        }
        return reorderedList;
    }
    public static void main(String[] srgs){
        Scanner sc;
        List<Integer> numbers;
        try{
            sc=new Scanner(System.in);
            numbers=new LinkedList<>();
            System.out.println("Enter the length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                numbers.add(sc.nextInt());
            System.out.println("Reordered list : "+new ReorderList(numbers).reOrderList(true));
        }
        catch(Exception e){
            System.out.println("Exception has been thrown : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
