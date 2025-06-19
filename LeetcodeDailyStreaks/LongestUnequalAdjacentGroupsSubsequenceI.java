import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    List<Integer> groupingIndexStartsWithZero, groupingIndexStartsWithOne;
    List<String> resultSet1, resultSet2;

    public LongestUnequalAdjacentGroupsSubsequenceI() {
        groupingIndexStartsWithOne = new LinkedList<>();
        groupingIndexStartsWithZero = new LinkedList<>();
        resultSet1 = new LinkedList<>();
        resultSet2 = new LinkedList<>();
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        for (int i = 0; i < groups.length; i++) {
            if (groupingIndexStartsWithZero.size() == 0 && groups[i] == 0) {
                groupingIndexStartsWithZero.add(i);
                resultSet1.add(words[i]);
            }
            if (groupingIndexStartsWithOne.size() == 0 && groups[i] == 1) {
                groupingIndexStartsWithOne.add(i);
                resultSet2.add(words[i]);
            }
            if (groupingIndexStartsWithZero.size() > 0) {
                int lastInsertedIndex = groupingIndexStartsWithZero.get(groupingIndexStartsWithZero.size() - 1);
                if (groups[lastInsertedIndex] != groups[i]) {
                    groupingIndexStartsWithZero.add(i);
                    resultSet1.add(words[i]);
                }
            }
            if (groupingIndexStartsWithOne.size() > 0) {
                int lastInsertedIndex = groupingIndexStartsWithOne.get(groupingIndexStartsWithOne.size() - 1);
                if (groups[lastInsertedIndex] != groups[i]) {
                    groupingIndexStartsWithOne.add(i);
                    resultSet2.add(words[i]);
                }
            }
        }
        return (resultSet1.size() > resultSet2.size()) ? resultSet1 : resultSet2;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] groups;
        String[] words;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of words and groups array : ");
            int length = sc.nextInt();
            groups = new int[length];
            words = new String[length];
            BiFunction<String[], int[], List<String>> biFunction = (input1,
                    input2) -> new LongestUnequalAdjacentGroupsSubsequenceI().getLongestSubsequence(input1, input2);
            System.out.println(biFunction.apply(words, groups));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
