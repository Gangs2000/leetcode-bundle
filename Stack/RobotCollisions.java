import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

interface TriFunction<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

public class RobotCollisions {
    List<List<Integer>> queue;
    Stack<List<Integer>> stack;
    Comparator<List<Integer>> comparator;

    public RobotCollisions() {
        comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        };
        queue = new LinkedList<>();
        stack = new Stack<>();
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        // Sort by positions
        this.sortArrayByPositions(healths, positions, directions);
        Collections.sort(queue, comparator);
        while (!queue.isEmpty()) {
            List<Integer> list = queue.remove(0);
            if (stack.isEmpty())
                stack.add(list);
            else {
                if (!(list.get(2) == 1 && stack.peek().get(2) == 0))
                    stack.add(list);
                else {
                    while (!stack.isEmpty() && list.get(2) == 1 && stack.peek().get(2) == 0) {
                        int currentHealth = list.get(1), peekHealth = stack.peek().get(1);
                        if (currentHealth > peekHealth) {
                            stack.pop();
                            list.set(1, --currentHealth);
                        } else if (currentHealth < peekHealth) {
                            stack.peek().set(1, --peekHealth);
                            list = null;
                            break;
                        } else if (currentHealth == peekHealth) {
                            stack.pop();
                            list = null;
                            break;
                        }
                    }
                    if (list != null)
                        stack.add(list);
                }
            }
        }
        this.transformHealthArray(healths, positions);
        return Arrays.stream(healths).boxed().filter(health -> health != -1).toList();
    }

    private void transformHealthArray(int[] healths, int[] positions) {
        Arrays.fill(healths, -1);
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            healths[list.get(3)] = list.get(1);
        }
    }

    private void sortArrayByPositions(int[] healths, int[] positions, String directions) {
        for (int i = 0; i < positions.length; i++) {
            // Right = 0, Left = 1
            int direction = directions.charAt(i) == 'R' ? 0 : 1;
            queue.add(Arrays.asList(positions[i], healths[i], direction, i));
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] healths, positions;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter positions and healths array length : ");
            int length = sc.nextInt();
            healths = new int[length];
            positions = new int[length];
            for (int i = 0; i < length; i++)
                healths[i] = sc.nextInt();
            for (int i = 0; i < length; i++)
                positions[i] = sc.nextInt();
            System.out.println("Enter directions : ");
            String directions = sc.nextLine();
            TriFunction<int[], int[], String, List<Integer>> triFunction = new RobotCollisions()::survivedRobotsHealths;
            System.out.println(triFunction.apply(healths, positions, directions));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
