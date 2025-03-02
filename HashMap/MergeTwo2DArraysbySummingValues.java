import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class MergeTwo2DArraysbySummingValues {
    Map<Integer, Integer> mapper;
    int[][] resultArr;

    public MergeTwo2DArraysbySummingValues() {
        mapper = new TreeMap<>();
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Summing values..
        this.summingValues(nums1);
        this.summingValues(nums2);
        if (!mapper.isEmpty()) {
            int currentIndex = 0;
            resultArr = new int[mapper.size()][2];
            for (Map.Entry<Integer, Integer> entry : mapper.entrySet()) {
                resultArr[currentIndex][0] = entry.getKey();
                resultArr[currentIndex][1] = entry.getValue();
                currentIndex++;
            }
        }
        return resultArr;
    }

    private void summingValues(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (mapper.containsKey(arr[i][0]))
                mapper.put(arr[i][0], mapper.get(arr[i][0]) + arr[i][1]);
            else
                mapper.putIfAbsent(arr[i][0], arr[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] nums1, nums2;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums1 and nums2 array : ");
            int length1 = sc.nextInt(), length2 = sc.nextInt();
            nums1 = new int[length1][2];
            nums2 = new int[length2][2];
            for (int i = 0; i < length1; i++) {
                nums1[i][0] = sc.nextInt();
                nums1[i][1] = sc.nextInt();
            }
            for (int i = 0; i < length2; i++) {
                nums2[i][0] = sc.nextInt();
                nums2[i][1] = sc.nextInt();
            }
            BiFunction<int[][], int[][], int[][]> biFunction = (input1, input2) -> new MergeTwo2DArraysbySummingValues()
                    .mergeArrays(input1, input2);
            System.out.println(biFunction.apply(nums1, nums2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
