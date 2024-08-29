import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class MostStonesRemovedwithSameRoworColumn {
    Map<Integer, List<Integer>> mapper;
    Set<Integer> visited;

    public MostStonesRemovedwithSameRoworColumn() {
        mapper = new HashMap<>();
        visited = new HashSet<>();
    }

    public int removeStones(int[][] stones) {
        Consumer<int[][]> consumer = (input) -> this.prepareList(stones);
        consumer.accept(stones);
        Function<int[][], Integer> function = (input) -> this.generateResult(input);
        return function.apply(stones);
    }

    private void prepareList(int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    this.putInMap(i, j);
                    this.putInMap(j, i);
                }
            }
        }
    }

    private void putInMap(int key, int value) {
        List<Integer> list = mapper.containsKey(key) ? (mapper.get(key)) : (new LinkedList<>());
        list.add(value);
        mapper.put(key, list);
    }

    private int generateResult(int[][] stones) {
        int noOfConnectedComponents = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {
                noOfConnectedComponents++;
                this.depthFirstSearch(i);
            }
        }
        return stones.length - noOfConnectedComponents;
    }

    private void depthFirstSearch(int stone) {
        visited.add(stone);
        for (int nextStone : mapper.getOrDefault(stone, new LinkedList<>())) {
            if (!visited.contains(nextStone))
                this.depthFirstSearch(nextStone);
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] stones;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter number of stones : ");
            int noOfStones = sc.nextInt();
            stones = new int[noOfStones][2];
            for (int i = 0; i < noOfStones; i++) {
                stones[i][0] = sc.nextInt();
                stones[i][1] = sc.nextInt();
            }
            Function<int[][], Integer> function = (input) -> new MostStonesRemovedwithSameRoworColumn()
                    .removeStones(input);
            System.out.println(function.apply(stones));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
