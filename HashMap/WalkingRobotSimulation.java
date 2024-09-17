import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class WalkingRobotSimulation {
    Set<Integer> lookUpForObstacles;
    char currentDirection = 'N';
    private final int HASH_MULTIPLIER = 60013;

    public WalkingRobotSimulation() {
        lookUpForObstacles = new HashSet<>();
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Consumer<int[][]> consumer = (obsArr) -> this.prepareObstacleMapper(obsArr);
        consumer.accept(obstacles);
        Function<int[], Integer> function = (commandArr) -> this.commandPromptingToRobot(commandArr);
        return function.apply(commands);
    }

    private int commandPromptingToRobot(int[] commands) {
        int maxEqulidianDistance = 0;
        List<Integer> currentPoints = new LinkedList<>();
        currentPoints.addAll(Arrays.asList(0, 0));
        for (int command : commands) {
            // Command to change the direction
            if (command == -1 || command == -2)
                this.directionChanger(command);
            // Command to move robot
            else {
                // Move robot in Y Axis
                if (currentDirection == 'N' || currentDirection == 'S') {
                    int index = 0;
                    while (index < command) {
                        int x = currentPoints.get(0), y = currentPoints.get(1);
                        if (!lookUpForObstacles.contains(x + HASH_MULTIPLIER * y))
                            currentPoints.set(1, y + ((currentDirection == 'N') ? (1) : (-1)));
                        else {
                            currentPoints.set(0, x + ((currentDirection == 'N') ? (-1) : (1)));
                            break;
                        }
                        index++;
                    }
                }
                // Move robot in X Axis
                else if (currentDirection == 'E' || currentDirection == 'W') {
                    int index = 0;
                    while (index < command) {
                        int x = currentPoints.get(0), y = currentPoints.get(1);
                        if (!lookUpForObstacles.contains(x + HASH_MULTIPLIER * y))
                            currentPoints.set(0, x + ((currentDirection == 'E') ? (1) : (-1)));
                        else {
                            currentPoints.set(0, x + ((currentDirection == 'E') ? (-1) : (1)));
                            break;
                        }
                        index++;
                    }
                }
            }
            int equlidianDistance = (currentPoints.get(0) * currentPoints.get(0))
                    + (currentPoints.get(1) * currentPoints.get(1));
            maxEqulidianDistance = Math.max(maxEqulidianDistance, equlidianDistance);
        }
        return maxEqulidianDistance;
    }

    private void prepareObstacleMapper(int[][] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            int x = obstacles[i][0], y = obstacles[i][1];
            lookUpForObstacles.add(x + HASH_MULTIPLIER * y);
        }
    }

    private void directionChanger(int command) {
        switch (currentDirection) {
            case 'N':
                currentDirection = (command == -1) ? ('E') : ('W');
                break;
            case 'E':
                currentDirection = (command == -1) ? ('S') : ('N');
                break;
            case 'W':
                currentDirection = (command == -1) ? ('N') : ('S');
                break;
            case 'S':
                currentDirection = (command == -1) ? ('W') : ('E');
                break;
        }
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
