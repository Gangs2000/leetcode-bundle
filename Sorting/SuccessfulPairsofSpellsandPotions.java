import java.util.Arrays;
import java.util.Scanner;

public class SuccessfulPairsofSpellsandPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++)
            result[i] = potions.length - this.binarySearch(potions, (long) spells[i], success);
        return result;
    }

    private int binarySearch(int[] potions, long current, long target) {
        int leftPointer = 0, rightPointer = potions.length - 1;
        while (leftPointer <= rightPointer) {
            int middle = leftPointer + ((rightPointer - leftPointer) / 2);
            long product = current * potions[middle];
            if (product >= target)
                rightPointer = middle - 1;
            else if (product < target)
                leftPointer = middle + 1;
        }
        return leftPointer;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] spells, potions;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of spells and potions array respectively : ");
            int n = sc.nextInt(), m = sc.nextInt();
            spells = new int[n];
            potions = new int[m];
            for (int i = 0; i < n; i++)
                spells[i] = sc.nextInt();
            for (int i = 0; i < m; i++)
                potions[i] = sc.nextInt();
            System.out.println("Enter success value : ");
            int success = sc.nextInt();
            System.out.println(new SuccessfulPairsofSpellsandPotions().successfulPairs(spells, potions, success));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
