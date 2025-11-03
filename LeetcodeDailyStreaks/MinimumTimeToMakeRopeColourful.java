import java.util.Scanner;
import java.util.function.BiFunction;

public class MinimumTimeToMakeRopeColourful {
    int totalMinTime = 0;

    public int minCost(int[] neededTime, String colors) {
        if (neededTime.length == 1)
            return neededTime[0];
        int currentSum = neededTime[0], currentMaxValue = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                currentSum += neededTime[i];
                currentMaxValue = Math.max(currentMaxValue, neededTime[i]);
            } else {
                totalMinTime += (currentSum - currentMaxValue);
                currentSum = neededTime[i];
                currentMaxValue = neededTime[i];
            }
        }
        return totalMinTime;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] neededTime;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter colour value : ");
            String colour = sc.nextLine();
            System.out.println("Enter length of NeededTime array : ");
            int length = sc.nextInt();
            neededTime = new int[length];
            for (int i = 0; i < length; i++)
                neededTime[i] = sc.nextInt();
            BiFunction<int[], String, Integer> biFunction = (input1, input2) -> new MinimumTimeToMakeRopeColourful()
                    .minCost(neededTime, colour);
            System.out.println(biFunction.apply(neededTime, colour));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
