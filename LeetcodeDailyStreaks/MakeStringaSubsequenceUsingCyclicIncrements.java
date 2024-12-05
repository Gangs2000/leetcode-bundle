import java.util.Scanner;
import java.util.function.BiFunction;

public class MakeStringaSubsequenceUsingCyclicIncrements {
    int str1Pointer = 0, str2Pointer = 0;

    public boolean canMakeSubsequence(String str1, String str2) {
        while (str1Pointer < str1.length() && str2Pointer < str2.length()) {
            if (str2.charAt(str2Pointer) == str1.charAt(str1Pointer))
                str2Pointer++;
            else {
                while (str1Pointer < str1.length()) {
                    byte currentByte = (byte) str1.charAt(str1Pointer);
                    char nextChar = (char) ((currentByte != 122) ? (currentByte + 1) : (97));
                    if (nextChar == str2.charAt(str2Pointer) || str1.charAt(str1Pointer) == str2.charAt(str2Pointer)) {
                        str2Pointer++;
                        break;
                    }
                    str1Pointer++;
                }
            }
            str1Pointer++;
        }
        return str2.length() == str2Pointer;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter Str1 and Str2 values : ");
            String str1 = sc.nextLine(), str2 = sc.nextLine();
            BiFunction<String, String, Boolean> bFunction = (input1,
                    input2) -> new MakeStringaSubsequenceUsingCyclicIncrements().canMakeSubsequence(input1, input2);
            System.out.println(bFunction.apply(str1, str2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
