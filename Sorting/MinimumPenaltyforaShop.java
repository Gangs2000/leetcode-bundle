import java.util.Scanner;
import java.util.function.Function;

public class MinimumPenaltyforaShop {
    int customersCount = 0, minIndex = Integer.MAX_VALUE, minCount = Integer.MAX_VALUE;

    public int bestClosingTime(String customers) {
        for (char customer : customers.toCharArray()) {
            if (customer == 'Y')
                customersCount++;
        }

        for (int i = 0; i < customers.length(); i++) {
            if (minCount > customersCount) {
                minCount = customersCount;
                minIndex = i;
            }
            if (customers.charAt(i) == 'Y')
                customersCount--;
            else
                customersCount++;
        }
        if (minCount > customersCount) {
            minCount = customersCount;
            minIndex = customers.length();
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter customer data : ");
            String customers = sc.nextLine();
            Function<String, Integer> function = (input) -> new MinimumPenaltyforaShop().bestClosingTime(input);
            System.out.println(function.apply(customers));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
