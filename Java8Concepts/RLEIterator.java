import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import FunctionalInterface.BiFunction;

public class RLEIterator {
    public static List<Integer> rleIterator(List<String> label, List<List<Integer>> list){
        List<Integer> output=new ArrayList<>();
        output.add(null);
        List<Integer> enCoded=new RLEIterator().encodingList(list.get(0));
        System.out.println(enCoded);
        for(int i=1;i<list.size();i++){
            if(list.get(i).get(0)>enCoded.size())
                output.add(-1);
            else {
                for(int j=0;j<list.get(i).get(0);j++){
                    if((j+1)==list.get(i).get(0)){
                        output.add(enCoded.get(0));
                        enCoded.remove(0);         
                    }
                    else 
                        enCoded.remove(0);
                }
            }
        }
        return output;
    }
    public List<Integer> encodingList(List<Integer> list){
        List<Integer> encoding=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(i%2==0){
                for(int j=0;j<list.get(i);j++)
                    encoding.add(list.get(i+1));
            }
        }
        return encoding;
    }
    public static void main(String[] args){
        Scanner sc;
        List<String> label;
        List<List<Integer>> list;
        try{
            sc=new Scanner(System.in);
            label=new ArrayList<>();
            list=new ArrayList<>();
            System.out.println("Enter the length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                label.add(sc.next());
            for(int i=0;i<length;i++){
                if(i==0){
                    System.out.println("Enter the length of RLE Iterator list : ");
                    int rleLength=sc.nextInt();
                    if(rleLength%2==0){
                        List<Integer> subList=new ArrayList<>();
                        for(int k=0;k<rleLength;k++)
                            subList.add(sc.nextInt());
                        list.add(subList);
                    }
                    else
                        throw new Exception("RLE Iterator length must be in even count..."); 
                }
                else {
                    System.out.println("Enter value of "+(i+1)+" list : ");
                    list.add(List.of(sc.nextInt()));
                }
            }
            BiFunction<List<String>,List<List<Integer>>,List<Integer>> object=RLEIterator::rleIterator;
            System.out.println("Output : "+object.apply(label, list));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
