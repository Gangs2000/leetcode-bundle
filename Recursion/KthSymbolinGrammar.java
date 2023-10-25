import java.util.Scanner;

public class KthSymbolinGrammar {        
    public int kthGrammar(int n, int k) {
        if(n==1 && k==1)
            return 0;
        int length=(int) Math.pow(2, n-1);
        int middle=length/2;
        if(k<=middle)
            return kthGrammar(n-1, k);
        else
            return (kthGrammar(n-1, k-middle)==0)?(1):(0);
    }
    
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N and K values : ");
            int n=sc.nextInt();
            int k=sc.nextInt();
            System.out.println(new KthSymbolinGrammar().kthGrammar(n, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
