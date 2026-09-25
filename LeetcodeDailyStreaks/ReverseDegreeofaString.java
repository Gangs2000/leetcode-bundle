import java.util.Scanner;
import java.util.function.Function;

public class ReverseDegreeofaString {
    public int reverseDegree(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            byte value = (byte) s.charAt(i);
            int diff = 27 - (value - (byte) 96);
            result += ((i + 1) * diff);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a String : ");
            String str = sc.nextLine();
            Function<String, Integer> function = new ReverseDegreeofaString()::reverseDegree;
            System.out.println(function.apply(str));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred :" + e.getMessage());
            e.printStackTrace();
        }
    }
}
