import java.util.Scanner;
import java.util.function.Function;

public class CheckBinaryStrHasOneSegmentOnesMost {
    boolean segmentAlreadySeen = false;

    public boolean checkOnesSegment(String s) {
        if (s.length() == 1)
            return true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) == '1')
                segmentAlreadySeen = true;
            if (s.charAt(i) == '1')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter String value in binary format : ");
            String binaryStr = sc.next();
            Function<String, Boolean> function = (input) -> new CheckBinaryStrHasOneSegmentOnesMost()
                    .checkOnesSegment(input);
            System.out.println(function.apply(binaryStr));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
