import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface TriFunctionInterface<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

public class FindAllPeopleWithSecret {
    Map<Integer, List<List<Integer>>> personMapper;
    Queue<List<Integer>> queue;
    List<Integer> finalResult;
    int[] secretsArray;

    public FindAllPeopleWithSecret() {
        personMapper = new HashMap<>();
        queue = new LinkedList<>();
        finalResult = new LinkedList<>();
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        secretsArray = new int[n];
        Arrays.fill(secretsArray, Integer.MAX_VALUE);
        // Prepare map for neighbours
        for (int i = 0; i < meetings.length; i++) {
            this.prepareNeighboursMap(meetings[i][0], meetings[i][1], meetings[i][2]);
            this.prepareNeighboursMap(meetings[i][1], meetings[i][0], meetings[i][2]);
        }
        queue.add(Arrays.asList(0, 0));
        queue.add(Arrays.asList(firstPerson, 0));
        // Both 0th and firstPerson will know secrets at 0th time
        secretsArray[0] = 0;
        secretsArray[firstPerson] = 0;
        // Call method to iterate all neighbours and populate secretArr
        this.breathFirstSearch(queue);
        finalResult = IntStream.range(0, secretsArray.length)
                .filter((index) -> secretsArray[index] != Integer.MAX_VALUE).boxed().collect(Collectors.toList());
        return finalResult;
    }

    // Prepare mapper for neighbour person iteration
    private void prepareNeighboursMap(int x, int y, int time) {
        List<List<Integer>> list = personMapper.containsKey(x) ? personMapper.get(x) : new LinkedList<>();
        list.add(Arrays.asList(time, y));
        personMapper.put(x, list);
    }

    // BFS
    private void breathFirstSearch(Queue<List<Integer>> queue) {
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int currentPerson = list.get(0), currentTime = list.get(1);
            if (secretsArray[currentPerson] < currentTime)
                continue;
            if (personMapper.containsKey(currentPerson)) {
                List<List<Integer>> neighbours = personMapper.get(currentPerson);
                for (List<Integer> neighbour : neighbours) {
                    int neighbourPerson = neighbour.get(1), neighbourTime = neighbour.get(0);
                    if (neighbourTime >= currentTime && secretsArray[neighbourPerson] > neighbourTime) {
                        // Push it to the queue current neighbour and neighbour time
                        queue.add(Arrays.asList(neighbourPerson, neighbourTime));
                        // Update secret arr with earliest time..
                        secretsArray[neighbourPerson] = neighbourTime;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] meetings;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N and firstPerson values : ");
            int n = sc.nextInt(), firstPerson = sc.nextInt();
            System.out.println("Enter length of meetings array : ");
            int length = sc.nextInt();
            meetings = new int[length][3];
            for (int i = 0; i < length; i++) {
                meetings[i][0] = sc.nextInt();
                meetings[i][1] = sc.nextInt();
                meetings[i][2] = sc.nextInt();
            }
            TriFunctionInterface<Integer, int[][], Integer, List<Integer>> trifunction = (i1, i2,
                    i3) -> new FindAllPeopleWithSecret().findAllPeople(i1, i2, i3);
            System.out.println(trifunction.apply(n, meetings, firstPerson));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
