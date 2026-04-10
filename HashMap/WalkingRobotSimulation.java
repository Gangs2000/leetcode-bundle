import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;

public class WalkingRobotSimulation {

    Set<List<Integer>> obstaclesSet;
    List<Integer> originPoint;
    char originDirection = 'N';
    int maxEqulidianDistance = Integer.MIN_VALUE;

    public WalkingRobotSimulation() {
        obstaclesSet = new HashSet<>();
        originPoint = new LinkedList<>();
        originPoint.add(0, 0);
        originPoint.add(1, 0);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        this.prepareObstaclesSet(obstacles);
        for (int command : commands) {
            // Change the direction
            if (Arrays.asList(-1, -2).contains(command)) {
                switch (originDirection) {
                    case 'N':
                        originDirection = command == -1 ? 'E' : 'W';
                        break;
                    case 'W':
                        originDirection = command == -1 ? 'N' : 'S';
                        break;
                    case 'S':
                        originDirection = command == -1 ? 'W' : 'E';
                        break;
                    case 'E':
                        originDirection = command == -1 ? 'S' : 'N';
                        break;
                }
                continue;
            }
            // Move the robot
            this.moveRobot(command);
            int x = originPoint.get(0), y = originPoint.get(1);
            maxEqulidianDistance = Math.max(maxEqulidianDistance, ((x * x) + (y * y)));
        }
        return maxEqulidianDistance;
    }

    private void moveRobot(int unit) {
        List<Character> northSouthList = Arrays.asList('N', 'S');
        for (int i = 1; i <= unit; i++) {
            int x = originPoint.get(0), y = originPoint.get(1);
            if (northSouthList.contains(originDirection))
                y = originDirection == 'N' ? (y + 1) : (y - 1);
            if (Arrays.asList('E', 'W').contains(originDirection))
                x = originDirection == 'E' ? (x + 1) : (x - 1);

            if (obstaclesSet.contains(Arrays.asList(x, y)))
                break;
            else {
                int index = northSouthList.contains(originDirection) ? 1 : 0,
                        value = northSouthList.contains(originDirection) ? y : x;
                originPoint.set(index, value);
            }
        }
    }

    private void prepareObstaclesSet(int[][] obstacles) {
        for (int i = 0; i < obstacles.length; i++)
            obstaclesSet.add(Arrays.asList(obstacles[i][0], obstacles[i][1]));
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] commands;
        int[][] obstacles;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of commands array : ");
            int length = sc.nextInt();
            commands = new int[length];
            for (int i = 0; i < length; i++)
                commands[i] = sc.nextInt();
            System.out.println("Enter length of obstacles array : ");
            int obstacleLength = sc.nextInt();
            obstacles = new int[obstacleLength][2];
            for (int i = 0; i < obstacleLength; i++) {
                obstacles[i][0] = sc.nextInt();
                obstacles[i][1] = sc.nextInt();
            }
            BiFunction<int[], int[][], Integer> biFunction = (cArr, oArr) -> new WalkingRobotSimulation().robotSim(cArr,
                    oArr);
            System.out.println(biFunction.apply(commands, obstacles));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
