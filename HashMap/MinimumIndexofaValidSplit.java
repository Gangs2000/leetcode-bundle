import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumIndexofaValidSplit {
    Map<Integer, Integer> mapper;
    int dominantKey = Integer.MIN_VALUE, dominantValue = Integer.MIN_VALUE;

    public MinimumIndexofaValidSplit() {
        mapper = new HashMap<>();
    }

    public int minimumIndex(List<Integer> nums) {
        // Find Dominent Key and Prepare frequencyMapper
        this.findOverAllFrequencyOfEachElement(nums);
        int leftCount = 0, rightCount = mapper.get(dominantKey);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominantKey) {
                leftCount++;
                rightCount--;
            }

            if (leftCount * 2 > (i + 1) && rightCount * 2 > (nums.size() - i - 1))
                return i + 1;
        }
        return -1;
    }

    private void findOverAllFrequencyOfEachElement(List<Integer> nums) {
        for (int num : nums) {
            mapper.putIfAbsent(num, 0);
            mapper.put(num, mapper.get(num) + 1);
            if (mapper.get(num) > dominantValue) {
                dominantValue = Math.max(dominantValue, mapper.get(num));
                dominantKey = num;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter nums into the list : ");
            int size = sc.nextInt();
            List<Integer> nums = new LinkedList<>();
            for (int i = 0; i < size; i++)
                nums.add(sc.nextInt());
            Function<List<Integer>, Integer> function = (input) -> new MinimumIndexofaValidSplit().minimumIndex(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
