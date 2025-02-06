import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class TuplewithSameProduct {
    Map<Integer, List<List<Integer>>> mapper;
    int totalTuples = 0;

    public TuplewithSameProduct() {
        mapper = new HashMap<>();
    }

    public int tupleSameProduct(int[] nums) {
        Consumer<int[]> consumer = (input) -> this.prepareMapForEachPossibleProduct(input);
        consumer.accept(nums);
        for (Map.Entry<Integer, List<List<Integer>>> entry : mapper.entrySet()) {
            if (entry.getValue().size() > 1) {
                int currentSize = entry.getValue().size();
                totalTuples += ((currentSize) * (currentSize - 1)) * 4;
            }
        }
        return totalTuples;
    }

    private void prepareMapForEachPossibleProduct(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i], b = nums[j];
                if (mapper.containsKey((a * b))) {
                    List<List<Integer>> list = mapper.get((a * b));
                    if (!list.contains(Arrays.asList(a, b)) && !list.contains(Arrays.asList(b, a))) {
                        list.add(Arrays.asList(a, b));
                        mapper.put((a * b), list);
                    }
                } else {
                    List<List<Integer>> list = new LinkedList<>();
                    list.add(Arrays.asList(a, b));
                    mapper.put((a * b), list);
                }
            }
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
            Function<int[], Integer> function = (input) -> new TuplewithSameProduct().tupleSameProduct(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
