import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class MakeTwoArraysEqualbyReversingSubarrays {
    Map<Integer, Integer> arrMapper, targetMapper;

    public MakeTwoArraysEqualbyReversingSubarrays() {
        arrMapper = new HashMap<>();
        targetMapper = new HashMap<>();
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        BiConsumer<Integer, Map<Integer, Integer>> biConsumer = (key, map) -> this.findFrequenciesOfElements(key, map);
        for (int i = 0; i < arr.length; i++) {
            biConsumer.accept(target[i], targetMapper);
            biConsumer.accept(arr[i], arrMapper);
        }
        return this.isPossibleToMakeArrEquals(arrMapper, targetMapper);
    }

    private void findFrequenciesOfElements(int key, Map<Integer, Integer> mapper) {
        mapper.putIfAbsent(key, 0);
        mapper.put(key, mapper.get(key) + 1);
    }

    private boolean isPossibleToMakeArrEquals(Map<Integer, Integer> arrMap, Map<Integer, Integer> targetMap) {
        for (Map.Entry<Integer, Integer> entry : arrMapper.entrySet()) {
            if (!targetMap.containsKey(entry.getKey()))
                return false;
            if (arrMapper.get(entry.getKey()) != targetMap.get(entry.getKey()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] arr, target;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of arr and target arrays length : ");
            int length = sc.nextInt();
            arr = new int[length];
            target = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
                target[i] = sc.nextInt();
            }
            BiFunction<int[], int[], Boolean> biFunction = (tarIn,
                    arrIn) -> new MakeTwoArraysEqualbyReversingSubarrays().canBeEqual(tarIn, arrIn);
            System.out.println(biFunction.apply(target, arr));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
