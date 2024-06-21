import java.util.Scanner;

public class ReverseString {
    public void reverseString(char[] s) {
        int leftPointer=0, rightPointer=s.length-1;
        while (leftPointer<=rightPointer) {
            if(s[leftPointer]!=s[rightPointer]){
                char temp=s[leftPointer];
                s[leftPointer]=s[rightPointer];
                s[rightPointer]=temp;
            }
            leftPointer++;
            rightPointer--;
        }
    }
    public static void main(String[] args) {
        Scanner sc;
        char[] chars;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of char array : ");
            int length=sc.nextInt();
            chars=new char[length];
            for(int i=0;i<length;i++)
                chars[i]=sc.nextLine().charAt(0);
            new ReverseString().reverseString(chars);
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
