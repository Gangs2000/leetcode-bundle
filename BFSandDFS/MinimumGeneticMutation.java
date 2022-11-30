import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinimumGeneticMutation {
    Map<String, Integer> queue;
    List<String> bankList;
    List<Character> validChars;
    int value; boolean flag=false;
    public MinimumGeneticMutation(){
        value=0;
        queue=new LinkedHashMap<>();
        bankList=new LinkedList<>();
        validChars=List.of('A','C','G','T');
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        //Moving all Bank array elements to Bank List
        bankList=Arrays.asList(bank).stream().collect(Collectors.toList());
        if(bankList.size()==0)
            return -1;
        else if(startGene.equals(endGene) && bankList.contains(endGene))
            return 0;        
        else{
            queue.put(startGene, 0);                        
            while(queue.size()!=0){                            
                String gene=queue.entrySet().stream().findFirst().get().getKey();
                value=queue.get(gene)+1;
                this.searchValidGenes(gene, endGene);                
                queue.remove(gene);
                if(flag)
                    break;
            }
            return (flag)?(value):(-1);
        }        
    }
    public void searchValidGenes(String gene, String endGene){
        for(Character character : validChars){            
            if(!flag && bankList.size()!=0){
                for(int i=0;i<gene.length();i++){
                    String tempString=gene;
                    StringBuilder stringBuilder=new StringBuilder(tempString);
                    if(gene.charAt(i)!=character){
                        stringBuilder.setCharAt(i, character);                        
                        if(stringBuilder.toString().equals(endGene) && bankList.contains(stringBuilder.toString()))                            
                            flag=true;
                        else if(bankList.contains(stringBuilder.toString())){
                            queue.put(stringBuilder.toString(), value);
                            bankList.remove(stringBuilder.toString());                            
                        }
                    }
                    if(flag)
                        break;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        String startGene,endGene;
        String[] bank;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Starting and Ending Gene : ");
            startGene=sc.next().toUpperCase();
            endGene=sc.next().toUpperCase();
            System.out.println("Enter length of bank array : ");
            int length=sc.nextInt();
            bank=new String[length];
            for(int i=0;i<length;i++)
                bank[i]=sc.next().toUpperCase();            
            System.out.println(new MinimumGeneticMutation().minMutation(startGene, endGene, bank));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
