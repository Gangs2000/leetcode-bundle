import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.BiFunction;

public class CountDaysWithoutMeetings {
    PriorityQueue<List<Integer>> prQueue;
    int daysCountWithOutMeetings = 0;

    public CountDaysWithoutMeetings() {
        prQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) == o2.get(0))
                    return o1.get(1).compareTo(o2.get(1));
                return o1.get(0).compareTo(o2.get(0));
            }
        });
    }

    public int countDays(int days, int[][] meetings) {
        // Load values
        this.loadArrayValuesIntoQueue(meetings);
        daysCountWithOutMeetings += (prQueue.isEmpty()) ? 0 : prQueue.peek().get(0) - 1;
        while (!prQueue.isEmpty()) {
            List<Integer> peekSchedule = prQueue.poll();
            if (!prQueue.isEmpty()) {
                List<Integer> nextPeekSchedule = prQueue.peek();
                if (peekSchedule.get(1) < nextPeekSchedule.get(0))
                    daysCountWithOutMeetings += (nextPeekSchedule.get(0) - peekSchedule.get(1)) - 1;
            } else
                daysCountWithOutMeetings += days - peekSchedule.get(1);
        }
        return daysCountWithOutMeetings;
    }

    private void loadArrayValuesIntoQueue(int[][] meetings) {
        for (int i = 0; i < meetings.length; i++)
            prQueue.add(Arrays.asList(meetings[i][0], meetings[i][1]));
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] meetings;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter days value : ");
            int days = sc.nextInt();
            System.out.println("Enter length of meetings array : ");
            int meetLength = sc.nextInt();
            meetings = new int[meetLength][2];
            for (int i = 0; i < meetLength; i++) {
                meetings[i][0] = sc.nextInt();
                meetings[i][1] = sc.nextInt();
            }
            BiFunction<Integer, int[][], Integer> biFunction = (input1, input2) -> new CountDaysWithoutMeetings()
                    .countDays(input1, input2);
            System.out.println(biFunction.apply(days, meetings));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
