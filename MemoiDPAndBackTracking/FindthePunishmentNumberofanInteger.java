import java.util.Scanner;
import java.util.function.Function;

public class FindthePunishmentNumberofanInteger {
    int totalPunishmentSum = 0;

    public int punishmentNumber(int n) {
        for (int i = 1; i <= n; i++)
            totalPunishmentSum += (this.canBePartitioned(String.valueOf(i * i), i * i)) ? (i * i) : 0;
        return totalPunishmentSum;
    }

    private boolean canBePartitioned(String numString, int target) {
        if (numString.isEmpty() && target == 0)
            return true;
        if (target < 0)
            return false;

        for (int index = 0; index < numString.length(); index++) {
            String leftPortion = numString.substring(0, index + 1);
            String rightPortion = numString.substring(index + 1);
            if (this.canBePartitioned(rightPortion, target - Integer.valueOf(leftPortion).intValue()))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n = sc.nextInt();
            Function<Integer, Integer> function = (input) -> new FindthePunishmentNumberofanInteger()
                    .punishmentNumber(input);
            System.out.println(function.apply(n));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
