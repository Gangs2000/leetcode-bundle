import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    Map<Integer, List<Integer>> indexMapper;
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
                List<Integer> list = indexMapper.get(nums[i]);
                list.remove(Integer.valueOf(i));
                list = indexMapper.get(reversedNum);
                if (list.size() > 0) {
                    int mostRecentIndex = list.get(0);
                    if (mostRecentIndex > i)
                        minDistance = Math.min(minDistance, Math.abs(mostRecentIndex - i));
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void mapIndicies(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> set = indexMapper.containsKey(nums[i]) ? indexMapper.get(nums[i]) : new LinkedList<>();
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
