import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumCostofBuyingCandiesWithDiscount {
    int minCost = 0;

    public int minimumCost(int[] cost) {
        int totalCandies = 0;
        Arrays.sort(cost);
        for (int i = cost.length - 1; i >= 0; i--) {
            if (totalCandies == 2)
                totalCandies = 0;
            else {
                minCost += cost[i];
                totalCandies++;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] costs;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of cost array : ");
            int length = sc.nextInt();
            costs = new int[length];
            for (int i = 0; i < length; i++)
                costs[i] = sc.nextInt();
            Function<int[], Integer> function = new MinimumCostofBuyingCandiesWithDiscount()::minimumCost;
            System.out.println(function.apply(costs));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
