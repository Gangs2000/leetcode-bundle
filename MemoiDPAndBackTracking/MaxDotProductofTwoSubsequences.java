import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MaxDotProductofTwoSubsequences {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.dynamicProgramming(0, 0, nums1, nums2, new LinkedList<>(), new LinkedList<>());
        return 1;
    }

    private void dynamicProgramming(int index1, int index2, int[] arr1, int[] arr2, List<Integer> list1,
            List<Integer> list2) {
        if (list1.size() == list2.size())
            System.out.println(list1 + " " + list2);
        if (index1 == arr1.length || index2 == arr2.length)
            return;
        list1.add(arr1[index1]);
        this.dynamicProgramming(index1 + 1, index2, arr1, arr2, list1, list2);
        list1.remove(list1.size() - 1);
        this.dynamicProgramming(index1 + 1, index2, arr1, arr2, list1, list2);
        list2.add(arr2[index2]);
        this.dynamicProgramming(index1, index2 + 1, arr1, arr2, list1, list2);
        list2.remove(list2.size() - 1);
        this.dynamicProgramming(index1, index2 + 1, arr1, arr2, list1, list2);
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] num1, num2;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of num1 and num2 : ");
            int length1 = sc.nextInt(), length2 = sc.nextInt();
            num1 = new int[length1];
            num2 = new int[length2];
            for (int i = 0; i < length1; i++)
                num1[i] = sc.nextInt();
            for (int i = 0; i < length2; i++)
                num2[i] = sc.nextInt();
            BiFunction<int[], int[], Integer> biFunction = (input1, input2) -> new MaxDotProductofTwoSubsequences()
                    .maxDotProduct(input1, input2);
            System.out.println(biFunction.apply(num1, num2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
