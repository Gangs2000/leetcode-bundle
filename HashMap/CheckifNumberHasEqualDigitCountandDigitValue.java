import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckifNumberHasEqualDigitCountandDigitValue {
    Map<Integer, Integer> freqMap;
    public CheckifNumberHasEqualDigitCountandDigitValue(){
        freqMap=new HashMap<>();
    }
    public boolean digitCount(String num) {
        //Getting frequency for each character..
        for(int i=0;i<num.length();i++){
            freqMap.putIfAbsent(num.charAt(i)-'0', 0);
            freqMap.put(num.charAt(i)-'0', freqMap.get(num.charAt(i)-'0')+1);
        }        
        for(int i=0;i<num.length();i++){            
            if(freqMap.containsKey(i)){
                if(num.charAt(i)-'0'!=freqMap.get(i))
                    return false;
            }
            else{
                if(num.charAt(i)-'0'!=0)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String value : ");
            String str=sc.next();
            System.out.println(new CheckifNumberHasEqualDigitCountandDigitValue().digitCount(str));            
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
