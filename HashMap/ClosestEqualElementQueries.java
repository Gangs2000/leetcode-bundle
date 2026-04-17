import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class ClosestEqualElementQueries {
    Map<Integer, TreeSet<Integer>> trackerMap;
    Map<Integer, Integer> freqMap;

    public ClosestEqualElementQueries() {
        trackerMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        // Find indices for each element
        this.findIndicesForEachElement(nums);
        return this.executeQuery(nums, queries);
    }

    private void findIndicesForEachElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            freqMap.putIfAbsent(nums[i], 0);
            freqMap.put(nums[i], freqMap.get(nums[i]) + 1);

            TreeSet<Integer> sortedIndices = trackerMap.containsKey(nums[i]) ? trackerMap.get(nums[i])
                    : new TreeSet<>();
            sortedIndices.add(i);
            sortedIndices.add(nums.length + i);
            trackerMap.put(nums[i], sortedIndices);
        }
    }

    private List<Integer> executeQuery(int[] nums, int[] queries) {
        List<Integer> result = new LinkedList<>();
        int n = nums.length;
        for (int query : queries) {
            int element = nums[query];
            if (freqMap.get(element) == 1) {
                result.add(-1);
            } else {
                TreeSet<Integer> set = trackerMap.get(element);
                int minDist = Integer.MAX_VALUE;

                // Check both the original index and its circular twin
                for (int idx : new int[] { query, query + n }) {
                    Integer lower = set.lower(idx);
                    Integer higher = set.higher(idx);
                    if (lower != null)
                        minDist = Math.min(minDist, idx - lower);
                    if (higher != null)
                        minDist = Math.min(minDist, higher - idx);
                }
                result.add(minDist == Integer.MAX_VALUE ? -1 : minDist);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums, queries;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums and queries array : ");
            int numLength = sc.nextInt(), queryLength = sc.nextInt();
            nums = new int[numLength];
            queries = new int[queryLength];
            for (int i = 0; i < numLength; i++)
                nums[i] = sc.nextInt();
            for (int i = 0; i < queryLength; i++)
                queries[i] = sc.nextInt();
            java.util.function.BiFunction<int[], int[], List<Integer>> biFunction = new ClosestEqualElementQueries()::solveQueries;
            System.out.println(biFunction.apply(nums, queries));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
