import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

interface TriFunction<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

public class LongestHappyString {
    StringBuilder builder;
    PriorityQueue<List<Object>> pq, tempQueue;

    public LongestHappyString() {
        builder = new StringBuilder();
        Comparator<List<Object>> comparator = new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                if ((int) o1.get(0) == (int) o2.get(0))
                    return Character.valueOf((char) o1.get(1)).compareTo(Character.valueOf((char) o2.get(1)));
                return Integer.valueOf((int) o2.get(0)).compareTo(Integer.valueOf((int) o1.get(0)));
            }
        };
        pq = new PriorityQueue<>(comparator);
        tempQueue = new PriorityQueue<>(comparator);
    }

    public String longestDiverseString(int a, int b, int c) {
        // Load initial values to heap
        this.loadInitialValuesToHeapQueue(a, b, c);
        while (!pq.isEmpty()) {
            System.out.println(pq+" "+tempQueue);
            List<Object> list = pq.poll();
            int currentCount = (int) list.get(0);
            char currentChar = (char) list.get(1);
            if (currentCount > 1) {
                if (tempQueue.isEmpty()) {
                    builder.append(currentChar);
                    currentCount--;
                }
                builder.append(currentChar);
                currentCount--;
            } else {
                builder.append(currentChar);
                currentCount--;
            }

            // Check current and previous characters are same
            if (currentCount > 0) {
                tempQueue.add(Arrays.asList(currentCount, currentChar));
                boolean isSameCharacter = (char) tempQueue.peek().get(1) == currentChar;
                if (!isSameCharacter) {
                    while (!tempQueue.isEmpty())
                        pq.add(tempQueue.poll());
                }
            } else {
                while (!tempQueue.isEmpty())
                    pq.add(tempQueue.poll());
            }
        }
        return builder.toString();
    }

    private void loadInitialValuesToHeapQueue(int a, int b, int c) {
        if (a > 0)
            pq.add(Arrays.asList(a, 'a'));
        if (b > 0)
            pq.add(Arrays.asList(b, 'b'));
        if (c > 0)
            pq.add(Arrays.asList(c, 'c'));
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter A,B and C values : ");
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            TriFunction<Integer, Integer, Integer, String> function = (input1, input2,
                    input3) -> new LongestHappyString().longestDiverseString(input1, input2, input3);
            System.out.println(function.apply(a, b, c));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
