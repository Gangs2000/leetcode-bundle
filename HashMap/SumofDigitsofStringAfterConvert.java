import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SumofDigitsofStringAfterConvert {
    public int getLucky(String s, int k) {
        Function<String, String> function = (str) -> this.getDigits(str);
        String builderString = function.apply(s);
        return this.keepAddingDigitsKTimes(builderString, k);
    }

    private String getDigits(String s) {
        StringBuilder buildStr = new StringBuilder();
        byte toBeSubtracted = 96;
        for (int i = 0; i < s.length(); i++)
            buildStr.append((byte) s.charAt(i) - toBeSubtracted);
        return buildStr.toString();
    }

    private int keepAddingDigitsKTimes(String builderString, int k) {
        int sum = 0;
        while (k > 0) {
            for (int i = 0; i < builderString.length(); i++)
                sum += builderString.charAt(i) - '0';
            if (k-- > 0) {
                builderString = String.valueOf(sum);
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.next();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<String, Integer, Integer> biFunction = (str, kValue) -> new SumofDigitsofStringAfterConvert()
                    .getLucky(str, kValue);
            System.out.println(biFunction.apply(s, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
