import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;

public class MaximumSwap {
    PriorityQueue<Character> pq;

    public MaximumSwap() {
        pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public int maximumSwap(int num) {
        String sortedStr = this.sortNumber(num);
        if (String.valueOf(num).equals(sortedStr))
            return num;
        List<String> strings = this.breakPrefixAndSuffix(String.valueOf(num), sortedStr);
        return this.swapElement(strings);
    }

    private String sortNumber(int num) {
        String string = String.valueOf(num), sortedStr = "";
        for (int i = 0; i < string.length(); i++)
            pq.add(string.charAt(i));
        while (!pq.isEmpty())
            sortedStr = sortedStr.concat(String.valueOf(pq.poll()));
        return sortedStr;
    }

    private List<String> breakPrefixAndSuffix(String originalStr, String sortedStr) {
        int index = 1;
        while (index < originalStr.length()) {
            if (!originalStr.substring(0, index).equals(sortedStr.substring(0, index)))
                break;
            index++;
        }
        return Arrays.asList(originalStr.substring(0, index - 1), originalStr.substring(index - 1));
    }

    private int swapElement(List<String> strings) {
        int maxIndex = 0, maxElement = Integer.MIN_VALUE;
        StringBuilder suffix = new StringBuilder(strings.get(1));
        for (int i = 0; i < suffix.length(); i++) {
            if (maxElement <= suffix.charAt(i) - '0') {
                maxElement = Math.max(maxElement, suffix.charAt(i) - '0');
                maxIndex = Math.max(maxIndex, i);
            }
        }
        suffix.setCharAt(maxIndex, (char) (suffix.charAt(0)));
        suffix.setCharAt(0, (char) (maxElement + '0'));
        return Integer.valueOf(strings.get(0).concat(suffix.toString()));
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter a Number : ");
            int num = sc.nextInt();
            Function<Integer, Integer> function = (input) -> new MaximumSwap().maximumSwap(input);
            System.out.println(function.apply(num));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
