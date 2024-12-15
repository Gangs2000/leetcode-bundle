import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumNumberofIntegerstoChooseFromaRangeI {
    int currentSum = 0, noOfCount = 0, maxCount = 0;

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = Arrays.stream(banned).boxed().filter((num) -> num <= n).collect(Collectors.toSet());
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i)) {
                currentSum += i;
                if (currentSum > maxSum)
                    break;
                noOfCount++;
                maxCount = Math.max(maxCount, noOfCount);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] banned;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of banned array : ");
            int length = sc.nextInt();
            banned = new int[length];
            for (int i = 0; i < length; i++)
                banned[i] = sc.nextInt();
            System.out.println("Enter N and MaxSum values : ");
            int n = sc.nextInt(), maxSum = sc.nextInt();
            System.out.println(new MaximumNumberofIntegerstoChooseFromaRangeI().maxCount(banned, n, maxSum));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
