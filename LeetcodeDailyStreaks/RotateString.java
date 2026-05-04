package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.function.BiFunction;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                String prefixStr = s.substring(0, i), suffixStr = s.substring(i);
                if ((suffixStr + prefixStr).equalsIgnoreCase(goal))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter original and goal strings : ");
            String s = sc.nextLine(), goal = sc.nextLine();
            BiFunction<String, String, Boolean> biFunction = new RotateString()::rotateString;
            System.out.println(biFunction.apply(s, goal));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
