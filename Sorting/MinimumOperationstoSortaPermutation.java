import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumOperationstoSortaPermutation {
    Queue<List<Object>> queue;

    public MinimumOperationstoSortaPermutation() {
        queue = new LinkedList<>();
    }

    public int minOperations(int[] nums) {
        int minOperations = Integer.MAX_VALUE;
        List<Integer> arrList = Arrays.stream(nums).boxed().toList();
        queue.add(Arrays.asList(arrList, 0));
        while (!queue.isEmpty()) {
            List<Object> currentObject = queue.poll();
            List<Integer> list = (List<Integer>) currentObject.get(0);
            int steps = (int) currentObject.get(1);
            List<Integer> nonReversed = this.getMinMaxAndPivot(list);
            if (this.checkIfSorted(list, nonReversed.get(0), nonReversed.get(1), nonReversed.get(2)))
                return steps;
            List<Integer> reversed = this.getMinMaxAndPivot(new LinkedList<>(list.reversed()));
            if (this.checkIfSorted(new LinkedList<>(list), reversed.get(0), reversed.get(1), reversed.get(2)))
                return steps;
            if (nonReversed.get(2) > 1 && reversed.get(2) > 1)
                return -1;
            List<Integer> rotatedList = new LinkedList<>();
            if (list.size() > 1)
                rotatedList.addAll(list.subList(1, list.size()));
            rotatedList.add(list.get(0));
            queue.add(Arrays.asList(rotatedList, steps + 1));
            queue.add(Arrays.asList(new LinkedList<>(list.reversed()), steps + 1));
        }
        return Math.min(minOperations, -1);
    }

    private boolean checkIfSorted(List<Integer> list, int min, int max, int voilationCount) {
        if (voilationCount == 1 && list.indexOf(min) == 0 && list.indexOf(max) == list.size() - 1)
            return true;
        return false;
    }

    private List<Integer> getMinMaxAndPivot(List<Integer> list) {
        int minElement = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE, voilationCount = 0, last = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            minElement = Math.min(minElement, list.get(i));
            maxElement = Math.max(maxElement, list.get(i));
            if (!((i != last && list.get(i) < list.get(i + 1))
                    || (i == last && list.get(i) < list.get(0))))
                voilationCount++;
        }
        return Arrays.asList(minElement, maxElement, voilationCount);
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], Integer> function = new MinimumOperationstoSortaPermutation()::minOperations;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
