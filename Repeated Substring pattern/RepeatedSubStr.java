import java.util.Scanner;

public class RepeatedSubStr {
    private boolean isMakingPattern(String string){
        if(string.length()==1)
            return false;
        else {
            boolean flag=true;
            for(int i=0;i<string.length()/2;i++){
                for(int j=i+1;j<string.length();j=i+j+1){
                    if(string.length()%(i+1)==0){
                        flag=(!string.substring(0, (i+1)).equals(string.substring(j, (i+j+1))))?(false):(true);
                        if(!flag)
                            break;
                    }
                }
                if(flag)
                    break;
            }
            return flag;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find out whether it makes pattern or not : ");
            String string=sc.next().toLowerCase();
            System.out.println(new RepeatedSubStr().isMakingPattern(string));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
