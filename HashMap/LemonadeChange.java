import java.util.Scanner;
import java.util.function.Function;

public class LemonadeChange {
    int dollarFive = 0, dollarTen = 0;
    public boolean lemonadeChange(int[] bills) {
        for (int dollar : bills) {
            if (dollar == 5)
                dollarFive++;
            else if (dollar == 10) {
                if (dollarFive > 0)
                    dollarFive--;
                else
                    return false;
                dollarTen++;
            } else if (dollar == 20) {
                if (dollarTen == 0 && dollarFive >= 3)
                    dollarFive -= 3;
                else if (dollarTen > 0 && dollarFive > 0) {
                    dollarFive--;
                    dollarTen--;
                } else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] bills;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length bills array : ");
            int length = sc.nextInt();
            bills = new int[length];
            for (int i = 0; i < length; i++)
                bills[i] = sc.nextInt();
            Function<int[], Boolean> function = (input) -> new LemonadeChange().lemonadeChange(bills);
            System.out.println(function.apply(bills));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
