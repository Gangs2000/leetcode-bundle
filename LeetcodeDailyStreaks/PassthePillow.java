import java.util.Scanner;

public class PassthePillow {
    int currentPerson=1, direction=1;
     public int passThePillow(int n, int time) {
        while(time>0){
            currentPerson=(direction==1)?(currentPerson+1):(currentPerson-1);
            direction=(currentPerson==n)?(-1):((currentPerson==1)?(1):(direction));
            time--;
        }
        return currentPerson;
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter N and Time values : ");
            int n=sc.nextInt();
            int time=sc.nextInt();
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
