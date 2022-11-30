import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

@FunctionalInterface
interface BiFunction<T1,T2,T3,R>{
    R apply(T1 t1, T2 t2,T3 t3);
}

public class MinimumGeneticMutation{
    public int minMutation(String startGene, String endGene, String[] bank) {
        int counter=0;
        List<String> bankList=Stream.of(bank).collect(Collectors.toList());
        StringBuilder startBuilder=new StringBuilder(startGene);
        StringBuilder endBuilder=new StringBuilder(endGene);
        for(int i=endBuilder.length()-1;i>=0;i--){
            if(endBuilder.charAt(i)!=startBuilder.charAt(i)){
                startBuilder.setCharAt(i, endBuilder.charAt(i));                
                if(bankList.contains(startBuilder.toString()))
                    counter++;
                else
                    break;
            }
        }
        return (counter==0)?(-1):(counter);   
    }
    public static void main(String[] args){
        Scanner sc;
        String startGene, endGene;
        String[] bank;
        try{
            sc=new Scanner(System.in);            
            System.out.println("Enter start and end gene pattern : ");
            startGene=sc.nextLine().toUpperCase();
            endGene=sc.nextLine().toUpperCase();
            System.out.println("Enter length of the bank array to store all valid mutations : ");
            int length=sc.nextInt();
            bank=new String[length];
            for(int i=0;i<length;i++)
                bank[i]=sc.next().toUpperCase();
            BiFunction<String, String, String[], Integer> functionalObject=new MinimumGeneticMutation()::minMutation;
            System.out.println("Minimum Mutation required is "+functionalObject.apply(startGene, endGene, bank));

        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
