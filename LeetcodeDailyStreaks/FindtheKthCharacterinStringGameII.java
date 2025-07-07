import java.util.Scanner;
import java.util.function.BiFunction;

public class FindtheKthCharacterinStringGameII {
    String currentString = "a";

    public char kthCharacter(long k, int[] operations) {
        for (int operation : operations) {
            if (currentString.length() >= k)
                break;
            // Copy itself
            if (operation == 0)
                currentString = currentString.concat(currentString);
            // Create adjacent character and append to it
            else {
                String tempStr = "";
                for (int i = 0; i < currentString.length(); i++) {
                    byte byteValue = (byte) currentString.charAt(i);
                    if (byteValue == 122)
                        tempStr = tempStr.concat("a");
                    else
                        tempStr = tempStr.concat(String.valueOf((char) (byteValue + 1)));
                }
                currentString = currentString.concat(tempStr);
            }
        }
        return currentString.charAt(((int) k) - 1);
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] operations;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of K value : ");
            long k = sc.nextLong();
            System.out.println("Enter length of operations array : ");
            int length = sc.nextInt();
            operations = new int[length];
            for (int i = 0; i < length; i++)
                operations[i] = sc.nextInt();
            BiFunction<Long, int[], Character> biFunction = (input1, input2) -> new FindtheKthCharacterinStringGameII()
                    .kthCharacter(input1, input2);
            System.out.println(biFunction.apply(k, operations));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
