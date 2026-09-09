import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class DistinctSubsequencesII {
    public int distinctSubseqII(String s) {
        Set<String> resultSet = new HashSet<>();
        this.dynamicProgramming(0, s, resultSet, new StringBuilder(""));
        return resultSet.size();
    }

    private void dynamicProgramming(int index, String s, Set<String> set, StringBuilder stringBuilder) {
        if (index == s.length()) {
            if (!stringBuilder.isEmpty())
                set.add(stringBuilder.toString());
            return;
        }
        stringBuilder.append(s.charAt(index));
        this.dynamicProgramming(index + 1, s, set, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        this.dynamicProgramming(index + 1, s, set, stringBuilder);
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s = sc.nextLine();
            Function<String, Integer> function = new DistinctSubsequencesII()::distinctSubseqII;
            System.out.println(function.apply(s));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
