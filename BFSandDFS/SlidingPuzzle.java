import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class SlidingPuzzle {
    PriorityQueue<List<Object>> priorityQueue;
    Set<String> visited;

    public SlidingPuzzle() {
        visited = new HashSet<>();
        priorityQueue = new PriorityQueue<>(new Comparator<List<Object>>() {
            // Compare only second index where no of steps stored
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                return Integer.valueOf((int) o1.get(1)).compareTo(Integer.valueOf((int) o2.get(1)));
            }
        });
    }

    public int slidingPuzzle(int[][] board) {
        // Convert board into string for easy manipulation
        String builder = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                builder += board[i][j];
        }
        return this.solveTheBoard(builder, board);
    }

    private void isValidMove(StringBuilder builder, String currentBoard, int currentIndex, int targetIndex,
            int currentStep) {
        char targetChar = currentBoard.charAt(targetIndex);
        builder.setCharAt(currentIndex, targetChar);
        builder.setCharAt(targetIndex, '0');
        if (!visited.contains(builder.toString())) {
            priorityQueue.add(Arrays.asList(builder.toString(), currentStep + 1));
            visited.add(builder.toString());
        }
    }

    private int solveTheBoard(String input, int[][] board) {
        priorityQueue.add(Arrays.asList(input, 0));
        visited.add(input.toString());
        StringBuilder builder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            List<Object> list = priorityQueue.poll();
            String currentBoard = String.valueOf(list.get(0));
            int currentStep = Integer.valueOf((int) list.get(1)), indexOfZero = currentBoard.indexOf("0");
            // Check if board is solved at this stage
            if (currentBoard.toString().equals("123450"))
                return currentStep;
            // Left
            if (Arrays.asList(0, 1, 2).contains(indexOfZero) && indexOfZero > 0
                    || Arrays.asList(3, 4, 5).contains(indexOfZero) && indexOfZero > 3) {
                builder.append(currentBoard);
                this.isValidMove(builder, currentBoard, indexOfZero, indexOfZero - 1, currentStep);
                builder.delete(0, builder.length());
            }
            // Right
            if (Arrays.asList(0, 1, 2).contains(indexOfZero) && indexOfZero < 2
                    || Arrays.asList(3, 4, 5).contains(indexOfZero) && indexOfZero < 5) {
                builder.append(currentBoard);
                this.isValidMove(builder, currentBoard, indexOfZero, indexOfZero + 1, currentStep);
                builder.delete(0, builder.length());
            }
            // Top
            if (indexOfZero - 3 >= 0) {
                builder.append(currentBoard);
                this.isValidMove(builder, currentBoard, indexOfZero, indexOfZero - 3, currentStep);
                builder.delete(0, builder.length());
            }
            // Bottom
            if (indexOfZero + 3 <= currentBoard.length() - 1) {
                builder.append(currentBoard);
                this.isValidMove(builder, currentBoard, indexOfZero, indexOfZero + 3, currentStep);
                builder.delete(0, builder.length());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] board;
        try {
            sc = new Scanner(System.in);
            board = new int[2][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            Function<int[][], Integer> function = (input) -> new SlidingPuzzle().slidingPuzzle(input);
            System.out.println(function.apply(board));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
