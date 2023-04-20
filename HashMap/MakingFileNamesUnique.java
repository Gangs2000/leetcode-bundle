import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingFileNamesUnique {
    Map<String, Integer> mapper;
    String[] result;
    public MakingFileNamesUnique(){
        mapper=new HashMap<>();
    }
    public String[] getFolderNames(String[] names) {
        result=new String[names.length];
        for(int i=0;i<names.length;i++){
            if(mapper.containsKey(names[i])) {                                
                int numericNum=mapper.get(names[i]);
                while(mapper.containsKey(names[i]+"("+numericNum+")"))
                    numericNum++;                       
                mapper.put(names[i]+"("+numericNum+")", 1);
                mapper.put(names[i], numericNum);
                result[i]=names[i]+"("+numericNum+")";
            }
            else { 
                mapper.put(names[i], 1);
                result[i]=names[i];
            }            
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] names;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of names array : ");
            int length=sc.nextInt();
            names=new String[length];
            for(int i=0;i<length;i++)
                names[i]=sc.next();
            String result[]=new MakingFileNamesUnique().getFolderNames(names);
            Arrays.stream(result).forEach(folder->System.out.print(folder+" "));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
