import java.util.Scanner;
import java.util.function.BiFunction;

public class MovePiecestoObtainaString {
    int iPointer = 0, jPointer = 0;

    public boolean canChange(String start, String target) {
        while (iPointer < start.length() || jPointer < target.length()) {
            // Keep moving iPointer until there is a char present
            iPointer = this.findChar(iPointer, start);
            jPointer = this.findChar(jPointer, target);
            // Edge cases
            if ((iPointer >= start.length() && jPointer < target.length() && target.charAt(jPointer) != '_') ||
                    (jPointer >= target.length() && iPointer < start.length() && start.charAt(iPointer) != '_'))
                return false;
            // If not edge case, then check actual scenario
            if (iPointer < start.length() && jPointer < target.length()) {
                // Validating current status of both pointers
                if (start.charAt(iPointer) != target.charAt(jPointer)
                        || (start.charAt(iPointer) == 'L' && iPointer < jPointer)
                        || (target.charAt(jPointer) == 'R' && iPointer > jPointer))
                    return false;
            }
            iPointer++;
            jPointer++;
        }
        return true;
    }

    private int findChar(int pointer, String string) {
        while (pointer < string.length()) {
            if (string.charAt(pointer) != '_')
                break;
            pointer++;
        }
        return pointer;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter Start and Target values : ");
            String start = sc.nextLine(), target = sc.nextLine();
            BiFunction<String, String, Boolean> bFunction = (input1, input2) -> new MovePiecestoObtainaString()
                    .canChange(input1, input2);
            System.out.println(bFunction.apply(start, target));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
