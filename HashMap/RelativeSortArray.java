import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface TernaryOperator<T> {
    T operation(T t1, T t2);
}

public class RelativeSortArray {
    Map<Integer, Integer> freqMapper;

    public RelativeSortArray() {
        freqMapper = new HashMap<>();
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for (int number : arr1) {
            freqMapper.putIfAbsent(number, 0);
            freqMapper.put(number, freqMapper.get(number) + 1);
        }
        int resultArr[] = new int[arr1.length];
        this.sortRelativeArr(resultArr, 0, arr2);
        int[] array = freqMapper.keySet().stream().sorted().mapToInt(Integer::valueOf).toArray();
        this.sortRelativeArr(resultArr, arr2.length, array);
        return resultArr;
    }

    private void sortRelativeArr(int resultArr[], int index, int[] arr) {
        for (int number : arr) {
            int count = freqMapper.get(number);
            for (int i = 0; i < count; i++)
                resultArr[index++] = number;
            freqMapper.remove(number);
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums1, nums2;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of arr1 and arr2 arrays : ");
            int length1 = sc.nextInt(), length2 = sc.nextInt();
            nums1 = new int[length1];
            nums2 = new int[length2];
            for (int i = 0; i < length1; i++)
                nums1[i] = sc.nextInt();
            for (int i = 0; i < length2; i++)
                nums2[i] = sc.nextInt();
            TernaryOperator<int[]> operator = new RelativeSortArray()::relativeSortArray;
            System.out.println(operator.operation(nums1, nums2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
