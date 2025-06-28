import java.util.Scanner;
import java.util.function.BiFunction;

public class LongestBinarySubsequenceLessThanorEqualtoK {
    int zeroesCount = 0, takenCount = 0;
    Double currentDecimal = 0.0;

    public int longestSubsequence(String s, int k) {
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                zeroesCount++;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0' && currentDecimal <= k)
                zeroesCount--;
            if (string.isEmpty())
                string = string.concat(String.valueOf(s.charAt(i)));
            else
                string = String.valueOf(s.charAt(i)).concat(string);
            currentDecimal = this.binaryToDecimal(string);
            System.out.println(string + " " + currentDecimal);
            if (currentDecimal <= k)
                takenCount++;
        }
        System.out.println(zeroesCount + " " + takenCount);
        return zeroesCount + takenCount;
    }

    private double binaryToDecimal(String binary) {
        double decimal = 0, power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            decimal = decimal + ((binary.charAt(i) - '0') * (Math.pow(2, power)));
            power++;
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter String s : ");
            String s = sc.nextLine();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<String, Integer, Integer> biFunction = (input1,
                    input2) -> new LongestBinarySubsequenceLessThanorEqualtoK()
                            .longestSubsequence(input1, input2);
            System.out.println(biFunction.apply(s, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Excption occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
