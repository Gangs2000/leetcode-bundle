import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumDistanceBetweenThreeEqualElements {
    Map<Integer, List<Integer>> freqMap;
    int result = Integer.MAX_VALUE;

    public MinimumDistanceBetweenThreeEqualElements() {
        freqMap = new HashMap<>();
    }

    public int minimumDistance(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = freqMap.containsKey(nums[i]) ? freqMap.get(nums[i]) : new LinkedList<>();
            if (list.size() == 3)
                list.remove(0);
            list.add(i);
            if (list.size() == 3)
                this.findMinAbsDiff(list);
            freqMap.put(nums[i], list);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void findMinAbsDiff(List<Integer> list) {
        int firstIndex = list.get(0), secondIndex = list.get(1), thirdIndex = list.get(2);
        result = Math.min(result, (Math.abs(firstIndex - secondIndex) +
                Math.abs(secondIndex - thirdIndex) +
                Math.abs(thirdIndex - firstIndex)));
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
            Function<int[], Integer> function = new MinimumDistanceBetweenThreeEqualElements()::minimumDistance;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
