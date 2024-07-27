import java.util.Arrays;
import java.util.Scanner;

public class MinimumCosttoConvertStringSource {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] minCostMatix = new long[26][26];
        Arrays.stream(minCostMatix).forEach(array -> Arrays.fill(array, Integer.MAX_VALUE));
        this.assignOriginalAndTargetValues(original, changed, cost, minCostMatix);
        this.floyddMarshell(minCostMatix);
        return this.getMinCost(source, target, minCostMatix);
    }

    private void assignOriginalAndTargetValues(char[] original, char[] changed, int[] costs, long[][] minCostMatix) {
        for (int i = 0; i < original.length; i++) {
            int startChar = original[i] - 'a';
            int endChar = changed[i] - 'a';
            minCostMatix[startChar][endChar] = Math.min(minCostMatix[startChar][endChar], (long) costs[i]);
        }
    }

    private void floyddMarshell(long[][] minCostMatix) {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    minCostMatix[i][j] = Math.min(minCostMatix[i][j], minCostMatix[i][k] + minCostMatix[k][j]);
                }
            }
        }
    }

    private long getMinCost(String source, String target, long[][] minCostMatix) {
        long totalCosts = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i))
                continue;
            if (minCostMatix[source.charAt(i) - 'a'][target.charAt(i) - 'a'] >= Integer.MAX_VALUE)
                return -1;
            totalCosts += minCostMatix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        return totalCosts;
    }

    public static void main(String[] args) {
        Scanner sc;
        String source, target;
        char[] original, changed;
        int[] costs;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter Source and Target values : ");
            source = sc.useDelimiter("\n").next();
            target = sc.useDelimiter("\n").next();
            System.out.println("Enter length of arrays : ");
            int length = sc.nextInt();
            original = new char[length];
            changed = new char[length];
            costs = new int[length];
            for (int i = 0; i < length; i++) {
                original[i] = sc.next().charAt(0);
                changed[i] = sc.next().charAt(0);
                costs[i] = sc.nextInt();
            }
            System.out.println(
                    new MinimumCosttoConvertStringSource().minimumCost(source, target, original, changed, costs));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
