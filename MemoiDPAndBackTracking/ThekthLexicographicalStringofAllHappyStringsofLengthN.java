import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ThekthLexicographicalStringofAllHappyStringsofLengthN {
    Queue<String> queue;

    public ThekthLexicographicalStringofAllHappyStringsofLengthN() {
        queue = new PriorityQueue<>();
    }

    public String getHappyString(int n, int k) {
        int removeCount = 1;
        this.backTracking(n, k, queue, new StringBuilder());
        while (!queue.isEmpty()) {
            if (removeCount == k)
                return queue.poll();
            else
                queue.poll();
            removeCount++;
        }
        return "";
    }

    public void backTracking(int n, int k, Queue<String> queue, StringBuilder currentStr) {
        if (queue.size() <= k && currentStr.length() == n && !queue.contains(currentStr.toString())) {
            queue.add(currentStr.toString());
            return;
        }
        if (queue.size() <= k) {
            for (char letter = 'a'; letter <= 'c'; letter++) {
                if (currentStr.length() > 0 && currentStr.charAt(currentStr.length() - 1) != letter)
                    currentStr.append(letter);
                else if (currentStr.isEmpty())
                    currentStr.append(letter);
                else
                    continue;
                this.backTracking(n, k, queue, currentStr);
                // Delete last character
                currentStr.deleteCharAt(currentStr.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N and K values : ");
            int n = sc.nextInt(), k = sc.nextInt();
            BiFunction<Integer, Integer, String> biFunction = (input1,
                    input2) -> new ThekthLexicographicalStringofAllHappyStringsofLengthN()
                            .getHappyString(input1, input2);
            System.out.println(biFunction.apply(n, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
