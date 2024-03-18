import java.util.Scanner;

public class MinimumLengthofStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int leftPointer=0, rightPointer=s.length()-1;
        while (leftPointer<rightPointer) {
            if(s.charAt(leftPointer)==s.charAt(rightPointer)){
                while (leftPointer++<s.length()-1) {
                    if(s.charAt(leftPointer)==s.charAt(leftPointer+1))
                        leftPointer++;
                    else
                        break;
                }
                if(leftPointer<rightPointer){
                    while (rightPointer>1) {
                        if(s.charAt(rightPointer)==s.charAt(rightPointer-1))
                            rightPointer--;
                        else
                            break;
                    }
                }
            }
            else
                return (rightPointer-leftPointer)+1;
            leftPointer++; rightPointer--;
        }
        return (leftPointer>rightPointer)?(0):((leftPointer-rightPointer)+1);
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new MinimumLengthofStringAfterDeletingSimilarEnds().minimumLength(s));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
