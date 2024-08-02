import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MinimumRightShiftstoSorttheArray {
    int minElement = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE;
    Deque<Integer> deque;

    public MinimumRightShiftstoSorttheArray() {
        deque = new ArrayDeque<>();
    }

    public int minimumRightShifts(List<Integer> nums) {
        Consumer<List<Integer>> consumer = (numsList) -> this.findMinAndMaxOfNums(nums);
        consumer.accept(nums);
        Function<Deque<Integer>, Integer> function = (input) -> this.minShiftToSortArr(input);
        return function.apply(deque);
    }

    private void findMinAndMaxOfNums(List<Integer> nums) {
        for (int i = nums.size() - 1; i >= 0; i--) {
            deque.add(nums.get(i));
            minElement = Math.min(minElement, nums.get(i));
            maxElement = Math.max(maxElement, nums.get(i));
        }
    }

    private int minShiftToSortArr(Deque<Integer> deque) {
        int minShift = 0;
        while (deque.peekFirst() != maxElement) {
            deque.addLast(deque.pollFirst());
            minShift++;
        }
        if (deque.getLast() != minElement)
            return -1;
        Predicate<Deque<Integer>> predicate = (input) -> this.isSorted(input);
        return (predicate.test(deque)) ? (minShift) : (-1);
    }

    private boolean isSorted(Deque<Integer> sortedQueue) {
        int max = deque.pollFirst();
        while (!deque.isEmpty()) {
            if (max < deque.peekFirst())
                return false;
            max = deque.pollFirst();
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        List<Integer> nums = new LinkedList<>();
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of num size : ");
            int length = sc.nextInt();
            for (int i = 0; i < length; i++)
                nums.add(sc.nextInt());
            Function<List<Integer>, Integer> function = (list) -> new MinimumRightShiftstoSorttheArray()
                    .minimumRightShifts(list);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
