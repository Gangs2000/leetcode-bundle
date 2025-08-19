import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CountHillsandValleysinanArray {
    List<Integer> list;
    int hillsAndValleysCount = 0;

    public CountHillsandValleysinanArray() {
        list = new LinkedList<>();
    }

    public int countHillValley(int[] nums) {
        for (int number : nums) {
            if (list.isEmpty())
                list.add(number);
            else if (list.get(list.size() - 1) != number)
                list.add(number);
        }
        if (list.size() > 2) {
            for (int i = 1; i < list.size() - 1; i++) {
                if ((list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1) ||
                        (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1))))
                    hillsAndValleysCount++;
            }
        }
        return hillsAndValleysCount;
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
            Function<int[], Integer> function = (input) -> new CountHillsandValleysinanArray().countHillValley(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
