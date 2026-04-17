import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.Function;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    Map<Integer, TreeSet<Integer>> indexMapper;
    int minDistance = Integer.MAX_VALUE;

    public MinimumAbsoluteDistanceBetweenMirrorPairs() {
        indexMapper = new HashMap<>();
    }

    public int minMirrorPairDistance(int[] nums) {
        // Map indicies of each element
        this.mapIndicies(nums);
        for (int i = 0; i < nums.length; i++) {
            StringBuilder reversedStr = new StringBuilder(String.valueOf(nums[i]));
            Integer reversedNum = Integer.valueOf(reversedStr.reverse().toString());
            if (indexMapper.containsKey(reversedNum)) {
                TreeSet<Integer> set = indexMapper.get(reversedNum);
                Optional<Integer> upperIndex = Optional.ofNullable(set.higher(i));
                if (upperIndex.isPresent())
                    minDistance = Math.min(minDistance, Math.abs(upperIndex.get() - i));
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void mapIndicies(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            TreeSet<Integer> set = indexMapper.containsKey(nums[i]) ? indexMapper.get(nums[i]) : new TreeSet<>();
            set.add(i);
            indexMapper.put(nums[i], set);
        }
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
            Function<int[], Integer> function = new MinimumAbsoluteDistanceBetweenMirrorPairs()::minMirrorPairDistance;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
