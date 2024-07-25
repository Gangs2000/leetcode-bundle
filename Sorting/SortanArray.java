import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;

public class SortanArray {
    Map<Integer, Integer> frequencyMapper;

    public SortanArray() {
        frequencyMapper = new TreeMap<>();
    }

    public int[] sortArray(int[] nums) {
        Consumer<int[]> mapConsumer = (numArr) -> this.mapFrequencyForEachElement(numArr);
        Consumer<int[]> resultConsumer = (numArr) -> this.generatedResult(numArr);
        mapConsumer.accept(nums);
        resultConsumer.accept(nums);
        return nums;
    }

    private void mapFrequencyForEachElement(int[] nums) {
        for (int number : nums) {
            frequencyMapper.putIfAbsent(number, 0);
            frequencyMapper.put(number, frequencyMapper.get(number) + 1);
        }
    }

    private void generatedResult(int[] nums) {
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMapper.entrySet()) {
            int end = index + entry.getValue();
            for (int i = index; i < end; i++)
                nums[i] = entry.getKey();
            index += entry.getValue();
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], int[]> function = (numArr) -> new SortanArray().sortArray(numArr);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
