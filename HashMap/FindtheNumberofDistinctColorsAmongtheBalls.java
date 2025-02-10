import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class FindtheNumberofDistinctColorsAmongtheBalls {
    Map<Integer, Integer> ballMap;
    Map<Integer, List<Integer>> colorMap;

    public FindtheNumberofDistinctColorsAmongtheBalls() {
        colorMap = new HashMap<>();
        ballMap = new HashMap<>();
    }

    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            List<Integer> list = null;
            int ball = queries[i][0], color = queries[i][1];
            if (ballMap.containsKey(ball)) {
                if (colorMap.containsKey(ballMap.get(ball))) {
                    list = colorMap.get(ballMap.get(ball));
                    list.remove(Integer.valueOf(ball));
                    if (list.isEmpty())
                        colorMap.remove(Integer.valueOf(ballMap.get(ball)));
                    else
                        colorMap.put(ballMap.get(ball), list);
                }
            }
            list = colorMap.containsKey(color) ? colorMap.get(color) : new LinkedList<>();
            list.add(ball);
            colorMap.put(color, list);
            ballMap.put(ball, color);
            result[i] = colorMap.size();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] queries;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter Limit of balls : ");
            int limit = sc.nextInt();
            System.out.println("Enter length of queries array : ");
            int length = sc.nextInt();
            queries = new int[length][2];
            for (int i = 0; i < length; i++) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
            }
            BiFunction<Integer, int[][], int[]> bFunction = (input1,
                    input2) -> new FindtheNumberofDistinctColorsAmongtheBalls().queryResults(input1, input2);
            System.out.println(bFunction.apply(limit, queries));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
