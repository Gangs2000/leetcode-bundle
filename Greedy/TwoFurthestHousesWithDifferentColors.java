package Greedy;

import java.util.Scanner;

public class TwoFurthestHousesWithDifferentColors {
    int farthestDistance = Integer.MIN_VALUE;

    public int maxDistance(int[] colors) {
        int initialHouseColour = colors[0], initialIndex = 0;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] != initialHouseColour)
                farthestDistance = Math.max(farthestDistance, Math.abs(i - initialIndex));
        }
        initialHouseColour = colors[colors.length - 1];
        initialIndex = colors.length - 1;
        for (int i = colors.length - 2; i >= 0; i--) {
            if (colors[i] != initialHouseColour)
                farthestDistance = Math.max(farthestDistance, Math.abs(i - initialIndex));
        }
        return farthestDistance;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] colors;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of colors array : ");
            int length = sc.nextInt();
            colors = new int[length];
            for (int i = 0; i < length; i++)
                colors[i] = sc.nextInt();
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
