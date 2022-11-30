import java.util.Scanner;

public class Maximum69Number {
    private static int returnOutput=0;
    private static int findMaximumNumber(int number, int pointer){
        if(pointer!=String.valueOf(number).length()){                                               //Recursive till pointer reaches to the length of the String
            if(pointer==0)                                                                          //Special condition to check number itself is maximum before modification
                Maximum69Number.setMaximumValue(number);
            StringBuilder stringBuilder=new StringBuilder(String.valueOf(number));                  //Building String builder by converting int to string
            if(stringBuilder.charAt(pointer)=='9')                                                  //Setting char at pointer (If 6, set 9 or vice versa )
                stringBuilder.setCharAt(pointer, '6');                                                                                 
            else 
                stringBuilder.setCharAt(pointer, '9');                               
            Maximum69Number.setMaximumValue(Integer.parseInt(stringBuilder.toString()));  
            findMaximumNumber(number, pointer+1);                                                   //Recursive function call incrementing pointer by 1
        }   
        return returnOutput;
    }
    private static void setMaximumValue(int number){
        if(number>returnOutput)
            returnOutput=number;
    }
    private static int simpleApproach(int number){        
        StringBuilder convertIntToStr=new StringBuilder(String.valueOf(number));
        for(int i=0;i<convertIntToStr.length();i++){
            if(convertIntToStr.charAt(i)=='6'){
                convertIntToStr.setCharAt(i, '9');  
                break;
            }        
        }
        return Integer.parseInt(convertIntToStr.toString());
    }
    public static void main(String[] args){
        Scanner sc;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the number to find out maximum : ");
            int number=sc.nextInt();
            System.out.println("Maximum 69 number is "+Maximum69Number.findMaximumNumber(number, 0));   //Calling function with initial pointer-0
            System.out.println("Obtained output through simple approach "+Maximum69Number.simpleApproach(number));  //Simple approach                                                                                                            
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
