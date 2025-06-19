import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MaximumCandiesYouCanGetfromBoxes {
    int totalCandies = 0;
    static Scanner sc;
    Queue<Integer> queue, tempQueue;
    Set<Integer> keysFound;

    public MaximumCandiesYouCanGetfromBoxes() {
        queue = new LinkedList<>();
        keysFound = new HashSet<>();
        tempQueue = new LinkedList<>();
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        // Load initial boxes to the queue..
        for (int box : initialBoxes)
            queue.add(box);
        // Start BFS here..
        while (!queue.isEmpty()) {
            int currentBox = queue.poll(); // Poll first box from queue
            if (status[currentBox] == 1) { // Check it's status is 1
                totalCandies += candies[currentBox]; // Add candies if status is 1
                this.loadKeys(currentBox, keys);
            } else if (keysFound.contains(currentBox)) {
                keysFound.remove(currentBox); // Check key is available in set
                totalCandies += candies[currentBox]; // Add candies if keys is found in set
                this.loadKeys(currentBox, keys);
            } else
                tempQueue.add(currentBox); // Else put it in tempQueue may be it's key obtain in future boxes
            int[] getBoxes = containedBoxes[currentBox];
            for (int box : getBoxes)
                queue.add(box);
        }

        // Temp queue is nothing but boxes that doesn't have keys and locked in previous
        // BFS call
        while (!tempQueue.isEmpty()) {
            int currentBox = tempQueue.poll();
            if (keysFound.contains(currentBox)) {
                keysFound.remove(currentBox);
                totalCandies += candies[currentBox];
            }
        }
        return totalCandies;
    }

    private void loadKeys(int currentBox, int[][] keys) {
        int[] getKeys = keys[currentBox]; // Get keys of corresponding box
        for (int key : getKeys)
            keysFound.add(key); // Load those keys to set
    }

    private static void loadSingleArrayElements(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();
    }

    private static void loadMultiDimentionArrayElements(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter length of current array : ");
            int length = sc.nextInt();
            arr[i] = new int[length];
            for (int j = 0; j < length; j++)
                arr[i][j] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        int[] status, candies, initialBoxes;
        int[][] keys, containedBoxes;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of status, candies, keys and contained boxes array : ");
            int length = sc.nextInt();
            status = new int[length];
            candies = new int[length];
            initialBoxes = new int[length];
            keys = new int[length][];
            containedBoxes = new int[length][];
            MaximumCandiesYouCanGetfromBoxes.loadSingleArrayElements(status); // Load status array
            MaximumCandiesYouCanGetfromBoxes.loadSingleArrayElements(candies); // Load candies array
            MaximumCandiesYouCanGetfromBoxes.loadSingleArrayElements(initialBoxes); // Load initialboxes array
            MaximumCandiesYouCanGetfromBoxes.loadMultiDimentionArrayElements(keys); // Load keys array
            MaximumCandiesYouCanGetfromBoxes.loadMultiDimentionArrayElements(containedBoxes); // Load contained boxes
            System.out.println(new MaximumCandiesYouCanGetfromBoxes().maxCandies(status, candies, keys, containedBoxes,
                    initialBoxes));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
