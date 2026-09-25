package Greedy;

import java.util.Scanner;
import java.util.function.Function;

public class MinimumNumberofPushestoTypeWordI {
    int minimumPushes = 0, iteration = 1;

    public int minimumPushes(String word) {
        for (int i = 0; i < word.length(); i++) {
            int reminder = (i % 8);
            if (reminder == 0)
                iteration++;
            minimumPushes += iteration;
        }
        return minimumPushes;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a word :");
            String word = sc.nextLine();
            Function<String, Integer> function = new MinimumNumberofPushestoTypeWordI()::minimumPushes;
            System.out.println(function.apply(word));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
