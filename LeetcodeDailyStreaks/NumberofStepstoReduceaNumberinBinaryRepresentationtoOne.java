import java.util.Scanner;

public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    int stepCount=0;
    public int numSteps(String s) {
        while(!s.equals("1")){
            s=this.changeBinaryBasedOnOddOrEven(s);
            stepCount++;
        }
        return stepCount;
    }
    private String changeBinaryBasedOnOddOrEven(String binary){
        String result="";
        if(binary.charAt(binary.length()-1)=='0')
            result=binary.substring(0, binary.length()-1);
        else if(binary.charAt(binary.length()-1)=='1'){
            StringBuilder stringBuilder=new StringBuilder(binary);
            if(binary.contains("0")){
                int getLastIndexOfZero=stringBuilder.lastIndexOf("0");
                stringBuilder.setCharAt(getLastIndexOfZero, '1');
                for(int i=getLastIndexOfZero+1;i<stringBuilder.length();i++)
                    stringBuilder.setCharAt(i, '0');
            }
            else{
                for(int i=0;i<stringBuilder.length();i++)
                    stringBuilder.setCharAt(i, '0');
                stringBuilder.insert(0, "1");
            }
            result=stringBuilder.toString();
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.nextLine();
            System.out.println(new NumberofStepstoReduceaNumberinBinaryRepresentationtoOne().numSteps(s));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
