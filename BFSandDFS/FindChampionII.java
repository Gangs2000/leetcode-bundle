import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindChampionII {
    List<Integer> nodes = null;

    public int findChampion(int n, int[][] edges) {
        // Prepare Node list
        this.prepareNodeList(n);
        for (int i = 0; i < edges.length; i++) {
            int weakestTeam = edges[i][1];
            if (nodes.contains(weakestTeam))
                nodes.remove(Integer.valueOf(weakestTeam));
        }
        return (nodes.size() > 1) ? -1 : (nodes.get(0));
    }

    private void prepareNodeList(int n) {
        nodes = IntStream.range(0, n).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] edges;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n = sc.nextInt();
            System.out.println("Enter length of an edge array : ");
            int length = sc.nextInt();
            edges = new int[length][2];
            for (int i = 0; i < length; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }
            BiFunction<Integer, int[][], Integer> biFunction = (input1, input2) -> new FindChampionII()
                    .findChampion(input1, input2);
            System.out.println(biFunction.apply(n, edges));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
