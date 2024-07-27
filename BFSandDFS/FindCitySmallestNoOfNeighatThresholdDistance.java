import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class FindCitySmallestNoOfNeighatThresholdDistance {
    int result = -1, minReachableCount = Integer.MAX_VALUE;
    Map<Integer, List<List<Integer>>> adjWeightMapper;
    PriorityQueue<List<Integer>> priorityQueue;
    Set<Integer> visited;

    public FindCitySmallestNoOfNeighatThresholdDistance() {
        adjWeightMapper = new HashMap<>();
        priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        visited = new HashSet<>();
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Prepare adjacent mapper with weight value
        Consumer<int[][]> consumer = (edgeArr) -> this.getAdjacentMapWithWeight(edgeArr);
        consumer.accept(edges);
        for (int i = 0; i < n; i++) {
            int reachableCount = this.dijkistra(i, distanceThreshold);
            if (reachableCount <= minReachableCount) {
                minReachableCount = reachableCount;
                result = Math.max(result, i);
            }
        }
        return result;
    }

    private void getAdjacentMapWithWeight(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            this.mapper(edges[i][0], Arrays.asList(edges[i][1], edges[i][2]));
            this.mapper(edges[i][1], Arrays.asList(edges[i][0], edges[i][2]));
        }
    }

    private void mapper(int key, List<Integer> value) {
        List<List<Integer>> list = adjWeightMapper.containsKey(key) ? (adjWeightMapper.get(key)) : (new LinkedList<>());
        list.add(value);
        adjWeightMapper.put(key, list);
    }

    private int dijkistra(int source, int thresHold) {
        int count = 0;
        priorityQueue.add(Arrays.asList(source, 0));
        while (!priorityQueue.isEmpty()) {
            List<Integer> list = priorityQueue.poll();
            int currentNode = list.get(0);
            int distance = list.get(1);
            if (visited.contains(currentNode))
                continue;
            visited.add(currentNode);
            count++;
            if (adjWeightMapper.containsKey(currentNode)) {
                List<List<Integer>> nextNodes = adjWeightMapper.get(currentNode);
                for (int i = 0; i < nextNodes.size(); i++) {
                    int nextNode = nextNodes.get(i).get(0);
                    int weight = nextNodes.get(i).get(1);
                    if (!visited.contains(nextNode) && distance + weight <= thresHold)
                        priorityQueue.add(Arrays.asList(nextNode, distance + weight));
                }
            }
        }
        visited.clear();
        return count - 1;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] edges;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n = sc.nextInt();
            System.out.println("Enter length of an edges array : ");
            int length = sc.nextInt();
            edges = new int[length][3];
            for (int i = 0; i < length; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            System.out.println("Enter Threshold value : ");
            int thresHold = sc.nextInt();
            System.out.println(new FindCitySmallestNoOfNeighatThresholdDistance().findTheCity(n, edges, thresHold));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
