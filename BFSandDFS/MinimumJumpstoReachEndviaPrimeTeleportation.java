import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class MinimumJumpstoReachEndviaPrimeTeleportation {
    Set<Integer> visitedPrime, visitedIndicies;
    Map<Integer, List<Integer>> mapper;
    Queue<List<Integer>> queue;
    int maxElement = Integer.MIN_VALUE;

    public MinimumJumpstoReachEndviaPrimeTeleportation() {
        visitedPrime = new HashSet<>();
        visitedIndicies = new HashSet<>();
        queue = new LinkedList<>();
        mapper = new HashMap<>();
    }

    public int minJumps(int[] nums) {
        // Find max and map indicies to all elements
        this.mapIndicies(nums);
        boolean[] isPrime = new boolean[maxElement + 1];
        Arrays.fill(isPrime, true);
        this.findAllPrimeTillMaxElement(isPrime);
        // Indicies and Steps
        queue.add(Arrays.asList(0, 0));
        visitedIndicies.add(0);
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int index = list.get(0), steps = list.get(1);
            // Reached last index
            if (index == nums.length - 1)
                return steps;
            // If not traverse these possible paths i+1, i-1 & if prime do teleportation
            // Check i+1 possible path
            if (index + 1 <= nums.length - 1 && !visitedIndicies.contains(index + 1)) {
                queue.add(Arrays.asList(index + 1, steps + 1));
                visitedIndicies.add(index + 1);
            }
            // Check i-1 possible path
            if (index - 1 >= 0 && !visitedIndicies.contains(index - 1)) {
                queue.add(Arrays.asList(index - 1, steps + 1));
                visitedIndicies.add(index - 1);
            }
            // Check if num[i] is Prime if so add all it's mupltiple of indicies
            if (isPrime[nums[index]] && !visitedPrime.contains(nums[index])) {
                for (int multiple = nums[index]; multiple <= maxElement; multiple += nums[index]) {
                    for (int nextIndex : mapper.getOrDefault(multiple, new ArrayList<>())) {
                        if (!visitedIndicies.contains(nextIndex)) {
                            queue.add(Arrays.asList(nextIndex, steps + 1));
                            visitedIndicies.add(nextIndex);
                        }
                    }
                }
                visitedPrime.add(nums[index]);
            }
        }
        return -1;
    }

    // Map indicies to the element and find max element
    private void mapIndicies(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            List<Integer> indiciesList = (mapper.containsKey(nums[i])) ? mapper.get(nums[i]) : new ArrayList<>();
            indiciesList.add(i);
            mapper.put(nums[i], indiciesList);
        }
    }

    // Seive algorithm
    private void findAllPrimeTillMaxElement(boolean[] isPrime) {
        isPrime[0] = false;
        isPrime[1] = false;
        for (int number = 2; number * number <= maxElement; number++) {
            if (isPrime[number]) {
                for (int multiple = number * number; multiple <= maxElement; multiple += number)
                    isPrime[multiple] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            Function<int[], Integer> function = new MinimumJumpstoReachEndviaPrimeTeleportation()::minJumps;
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
