package MemoiDPAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MinimumTotalDistanceTraveled {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        List<Integer> factories = new ArrayList<>();
        // Sort robots
        Collections.sort(robot);
        for (int i = 0; i < factory.length; i++) {
            for (int limit = 0; limit < factory[i][1]; limit++)
                factories.add(factory[i][0]);
        }
        // Sort factories
        Collections.sort(factories);
        long[][] memo = new long[robot.size()][factories.size()];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        return this.calculateMinDistance(0, 0, robot, factories, memo);
    }

    private long calculateMinDistance(int i, int j, List<Integer> robots, List<Integer> factories, long[][] memo) {
        if (i == robots.size())
            return 0l;
        if (j == factories.size())
            return (long) 1e12;
        if (memo[i][j] != -1)
            return memo[i][j];
        long take = 0l, skip = 0l;
        take = (Math.abs(robots.get(i) - factories.get(j)))
                + this.calculateMinDistance(i + 1, j + 1, robots, factories, memo);
        skip = this.calculateMinDistance(i, j + 1, robots, factories, memo);
        memo[i][j] = Math.min(take, skip);
        return memo[i][j];
    }

    public static void main(String[] args) {
        Scanner sc;
        List<Integer> robots;
        int[][] factories;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of robots array : ");
            int length = sc.nextInt();
            robots = new ArrayList<>();
            for (int i = 0; i < length; i++)
                robots.add(sc.nextInt());
            System.out.println("Enter length of factories array : ");
            int factoryLength = sc.nextInt();
            factories = new int[factoryLength][2];
            for (int i = 0; i < factoryLength; i++) {
                factories[i][0] = sc.nextInt();
                factories[i][1] = sc.nextInt();
            }
            BiFunction<List<Integer>, int[][], Long> biFunction = new MinimumTotalDistanceTraveled()::minimumTotalDistance;
            System.out.println(biFunction.apply(robots, factories));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
