import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;

public class LargestNumber {

    Comparator<String> comparator;

    public LargestNumber() {
        comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
    }

    public String largestNumber(int[] nums) {
        Function<int[], String[]> function = (intArr) -> this.convertIntToStr(intArr);
        String[] strArr = function.apply(nums);
        Arrays.sort(strArr, comparator);
        if ("0".equals(strArr[0]))
            return "0";
        String resultString = "";
        for (int i = 0; i < strArr.length; i++)
            resultString += strArr[i];
        return resultString;
    }

    private String[] convertIntToStr(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
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
            Function<int[], String> function = (arr) -> new LargestNumber().largestNumber(arr);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
