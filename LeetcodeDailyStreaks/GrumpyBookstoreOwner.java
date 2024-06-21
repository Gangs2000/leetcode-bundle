import java.util.Scanner;
import java.util.stream.IntStream;

public class GrumpyBookstoreOwner {
    int totalSatisfiedCustomer=0;
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        totalSatisfiedCustomer+=this.findMaxUnSatisfiedWindow(customers, grumpy, minutes);
        totalSatisfiedCustomer+=this.findAllSatisfiedCustomers(customers, grumpy);
        return totalSatisfiedCustomer;
    }
    private int findMaxUnSatisfiedWindow(int[] customers, int[] grumpy, int minutes){
        int maxUnSatisfiedCustomers=0, unSatisfiedCustomers=0, leftPointer=0, rightPointer=0;
        while (rightPointer<minutes) {
            if(grumpy[rightPointer]==1)
                unSatisfiedCustomers+=customers[rightPointer];
            rightPointer++;
        }
        maxUnSatisfiedCustomers=unSatisfiedCustomers;
        while (rightPointer<grumpy.length) {
            if(grumpy[leftPointer]==1)
                unSatisfiedCustomers-=customers[leftPointer];
            if(grumpy[rightPointer]==1)
                unSatisfiedCustomers+=customers[rightPointer];
            maxUnSatisfiedCustomers=Math.max(maxUnSatisfiedCustomers, unSatisfiedCustomers);
            leftPointer++; rightPointer++;
        }
        return maxUnSatisfiedCustomers;
    }
    private int findAllSatisfiedCustomers(int[] customers, int[] grumpy){
        return IntStream.range(0, grumpy.length).filter(i->grumpy[i]==0).map(i->customers[i]).sum();
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] customers, grumpy;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of Customers and Grumpy arrays : ");
            int length=sc.nextInt();
            customers=new int[length];
            grumpy=new int[length];
            for(int i=0;i<length;i++){
                customers[i]=sc.nextInt();
                grumpy[i]=sc.nextInt();
            }
            System.out.println("Enter Minutes value : ");
            int minutes=sc.nextInt();
            System.out.println(new GrumpyBookstoreOwner().maxSatisfied(customers, grumpy, minutes));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
