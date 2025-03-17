import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class PartitionArrayAccordingtoGivenPivot {
    List<Integer> lesserPivot, equalPivot, greaterPivot;

    public PartitionArrayAccordingtoGivenPivot() {
        lesserPivot = new LinkedList<>();
        equalPivot = new LinkedList<>();
        greaterPivot = new LinkedList<>();
    }

    public int[] pivotArray(int[] nums, int pivot) {
        for (int number : nums) {
            if (number < pivot)
                lesserPivot.add(number);
            else if (number == pivot)
                equalPivot.add(number);
            else if (number > pivot)
                greaterPivot.add(number);
        }
        this.prepareResultArr(nums);
        return nums;
    }

    private void prepareResultArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!lesserPivot.isEmpty())
                this.addToArrAndRemoveFromList(i, nums, lesserPivot);
            else if (!equalPivot.isEmpty())
                this.addToArrAndRemoveFromList(i, nums, equalPivot);
            else if (!greaterPivot.isEmpty())
                this.addToArrAndRemoveFromList(i, nums, greaterPivot);
        }
    }

    private void addToArrAndRemoveFromList(int index, int[] nums, List<Integer> list) {
        nums[index] = list.get(0);
        list.remove(0);
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
            System.out.println("Enter pivot value : ");
            int pivot = sc.nextInt();
            BiFunction<int[], Integer, int[]> biFunction = (input1, input2) -> new PartitionArrayAccordingtoGivenPivot()
                    .pivotArray(input1, input2);
            System.out.println(biFunction.apply(nums, pivot));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
