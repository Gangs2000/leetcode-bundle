import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class LargestSubmatrixWithRearrangements {
    Map<Integer, Integer> freqCount;
    Queue<Integer> pq;
    int largestSubMatrix = 0;

    public LargestSubmatrixWithRearrangements() {
        freqCount = new HashMap<>();
        pq = new PriorityQueue<>();
    }

    public int largestSubmatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            pq.clear();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    freqCount.putIfAbsent(j, 0);
                    freqCount.put(j, freqCount.get(j) + 1);
                } else if (freqCount.containsKey(j))
                    freqCount.remove(j);
            }
            if (!freqCount.isEmpty()) {
                freqCount.entrySet().stream().map(entry -> entry.getValue()).forEach(count -> pq.add(count));
                largestSubMatrix = Math.max(largestSubMatrix, this.findOutMaxSqaure(pq));
            }
        }
        return largestSubMatrix;
    }

    private int findOutMaxSqaure(Queue<Integer> queue) {
        int maxArea = 0;
        while (!queue.isEmpty()) {
            maxArea = Math.max(maxArea, queue.peek() * queue.size());
            queue.poll();
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] matrix;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m = sc.nextInt(), n = sc.nextInt();
            matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Function<int[][], Integer> function = (input) -> new LargestSubmatrixWithRearrangements()
                    .largestSubmatrix(input);
            System.out.println(function.apply(matrix));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
