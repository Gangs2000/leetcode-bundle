import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class SorttheJumbledNumbers {
    Map<Integer, List<Integer>> valueMapper;

    public SorttheJumbledNumbers() {
        valueMapper = new TreeMap<>();
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        BiFunction<int[], Integer, Integer> mapEachDigitFunction;
        for (int i = 0; i < nums.length; i++) {
            mapEachDigitFunction = (mapArr, number) -> this.mapEachDigit(mapping, number);
            int resultValue = mapEachDigitFunction.apply(mapping, nums[i]);
            BiConsumer<Integer, Integer> biConsumer = (key, value) -> this.sortMappingElements(key, value);
            biConsumer.accept(resultValue, nums[i]);
        }
        BiConsumer<int[], Map<Integer, List<Integer>>> biConsumer = (numArr, mapper) -> this
                .generateFinalResultOfNums(numArr, mapper);
        biConsumer.accept(nums, valueMapper);
        return nums;
    }

    private int mapEachDigit(int[] mapping, int number) {
        String numStr = String.valueOf(number), resultStr = "";
        for (int i = 0; i < numStr.length(); i++)
            resultStr += mapping[numStr.charAt(i) - '0'];
        return Integer.valueOf(resultStr);
    }

    private void sortMappingElements(int key, int value) {
        List<Integer> list = (valueMapper.containsKey(key)) ? (valueMapper.get(key)) : (new LinkedList<>());
        list.add(value);
        valueMapper.put(key, list);
    }

    private void generateFinalResultOfNums(int[] nums, Map<Integer, List<Integer>> mapper) {
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : mapper.entrySet()) {
            int listIndex = 0;
            List<Integer> list = entry.getValue();
            int end = index + list.size();
            for (int i = index; i < end; i++) {
                nums[i] = list.get(listIndex);
                listIndex++;
            }
            index += list.size();
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] mapping, nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of mapping array : ");
            int mapLen = sc.nextInt();
            mapping = new int[mapLen];
            for (int i = 0; i < mapLen; i++)
                mapping[i] = sc.nextInt();
            System.out.println("Enter length of nums array : ");
            int numLen = sc.nextInt();
            nums = new int[numLen];
            for (int i = 0; i < numLen; i++)
                nums[i] = sc.nextInt();
            BiFunction<int[], int[], int[]> biFunction = (mapArr, numArr) -> new SorttheJumbledNumbers()
                    .sortJumbled(mapping, nums);
            System.out.println(biFunction.apply(mapping, nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
