import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumNumberOfOperationstoMakeElementsinArrayDistinct {
    Map<Integer, Integer> freqMapper;
    int minCount = 0;

    public MinimumNumberOfOperationstoMakeElementsinArrayDistinct() {
        freqMapper = new HashMap<>();
    }

    public int minimumOperations(int[] nums) {
        for (int number : nums) {
            freqMapper.putIfAbsent(number, 0);
            freqMapper.put(number, freqMapper.get(number) + 1);
        }
        int index = 0;
        while (this.isDuplicatePresent()) {
            int iterationCount = 0;
            while (iterationCount <= 2) {
                if (index < nums.length) {
                    if (freqMapper.containsKey(nums[index])) {
                        int currentValue = freqMapper.get(nums[index]);
                        if (currentValue > 1)
                            freqMapper.put(nums[index], currentValue - 1);
                        else
                            freqMapper.remove(nums[index]);
                    }
                }
                iterationCount++;
                index++;
            }
        }
        return minCount;
    }

    private boolean isDuplicatePresent() {
        long duplicateCount = freqMapper.values().stream().filter(value -> value > 1).count();
        if (duplicateCount > 0)
            minCount++;
        return duplicateCount > 0;
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
            Function<int[], Integer> function = (input) -> new MinimumNumberOfOperationstoMakeElementsinArrayDistinct()
                    .minimumOperations(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
