import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class MaximumNumberofTasksYouCanAssign {
    int answer = 0;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // Sort tasks and workers array..
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int leftPointer = 0, rightPointer = Math.min(tasks.length, workers.length);
        while (leftPointer <= rightPointer) {
            int middlePointer = leftPointer + ((rightPointer - leftPointer)) / 2;
            if (this.checkTasksCanBeDone(tasks, workers, pills, strength, middlePointer)) {
                answer = middlePointer;
                leftPointer = middlePointer + 1;
            } else
                rightPointer = middlePointer - 1;
        }
        return answer;
    }

    private boolean checkTasksCanBeDone(int[] tasks, int[] workers, int pills, int strength, int middle) {
        TreeMap<Integer, Integer> workersMapper = new TreeMap<>();
        for (int i = workers.length - middle; i < workers.length; i++) {
            workersMapper.putIfAbsent(workers[i], 0);
            workersMapper.put(workers[i], workersMapper.get(workers[i]) + 1);
        }
        for (int i = middle - 1; i >= 0; i--) {
            Integer strongerWorker = workersMapper.lastKey();
            if (strongerWorker >= tasks[i]) {
                workersMapper.put(strongerWorker, workersMapper.get(strongerWorker) - 1);
                if (workersMapper.get(strongerWorker) == 0)
                    workersMapper.remove(strongerWorker);
            } else {
                if (pills == 0)
                    return false;
                strongerWorker = workersMapper.ceilingKey(tasks[i] - strength);
                if (strongerWorker == null)
                    return false;
                workersMapper.put(strongerWorker, workersMapper.get(strongerWorker) - 1);
                if (workersMapper.get(strongerWorker) == 0)
                    workersMapper.remove(strongerWorker);
                pills--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] tasks, workers;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of tasks and workers array : ");
            int taskArrLen = sc.nextInt(), workArrLen = sc.nextInt();
            tasks = new int[taskArrLen];
            workers = new int[workArrLen];
            System.out.println("Enter Pills and Strength values : ");
            int pills = sc.nextInt(), strength = sc.nextInt();
            System.out.println(new MaximumNumberofTasksYouCanAssign().maxTaskAssign(tasks, workers, pills, strength));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
