import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        Function<List<String>, Integer> function = (list) -> this.getMinimumTimeDifference(list);
        return function.apply(timePoints);
    }

    private int getMinimumTimeDifference(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            List<Integer> minutes = this.getConvertedHourAndMinute(timePoints.get(i), timePoints.get(i - 1));
            minDiff = Math.min(minDiff, minutes.get(0) - minutes.get(1));
        }
        List<Integer> minutes = this.getConvertedHourAndMinute(timePoints.get(timePoints.size() - 1),
                timePoints.get(0));
        minDiff = Math.min(minDiff, (24 * 60) - (minutes.get(0) + minutes.get(1)));
        return minDiff;
    }

    private List<Integer> getConvertedHourAndMinute(String current, String previous) {
        String[] currentPoint = current.split(":");
        String[] previousPoint = previous.split(":");
        int currentMinutes = (Integer.valueOf(currentPoint[0]) * 60) + Integer.valueOf(currentPoint[1]);
        int previousMinutes = (Integer.valueOf(previousPoint[0]) * 60) + Integer.valueOf(previousPoint[1]);
        return Arrays.asList(currentMinutes, previousMinutes);
    }

    public static void main(String[] args) {
        Scanner sc;
        List<String> timePoints;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of timePoints list : ");
            int length = sc.nextInt();
            timePoints = new LinkedList<>();
            for (int i = 0; i < length; i++)
                timePoints.add(sc.useDelimiter("\n").nextLine());
            Function<List<String>, Integer> function = (input) -> new MinimumTimeDifference().findMinDifference(input);
            System.out.println(function.apply(timePoints));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
