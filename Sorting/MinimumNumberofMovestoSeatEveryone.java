import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberofMovestoSeatEveryone {
    int minMovesRequired=0;
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i=0;i<seats.length;i++)
            minMovesRequired+=Math.abs(seats[i]-students[i]);
        return minMovesRequired;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] seats, students;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of seats and students array : ");
            int length=sc.nextInt();
            seats=new int[length];
            students=new int[length];
            for(int i=0;i<length;i++){
                seats[i]=sc.nextInt();
                students[i]=sc.nextInt();
            }
            System.out.println(new MinimumNumberofMovestoSeatEveryone().minMovesToSeat(seats, students));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
