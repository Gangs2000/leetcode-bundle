import java.util.Scanner;

public class FindtheOriginalTypedStringI {
    int possibleCount = 1;

    public int possibleStringCount(String word) {
        int count = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != word.charAt(i + 1)) {
                if (count > 0)
                    possibleCount += count;
                count = 0;
            } else
                count++;
        }
        return possibleCount + count;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
