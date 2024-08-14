import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class RegionsCutBySlashes {
    Map<Character, List<String>> mapper;
    List<String> listOfRegions;
    StringBuilder builder;

    public RegionsCutBySlashes() {
        mapper = new HashMap<>();
        listOfRegions = new LinkedList<>();
        builder = new StringBuilder();
        mapper.put('\\', Arrays.asList("100", "010", "001"));
        mapper.put('/', Arrays.asList("001", "010", "100"));
        mapper.put(' ', Arrays.asList("000", "000", "000"));
    }

    public int regionsBySlashes(String[] grid) {
        int[][] matrix = new int[(grid.length) * 3][(grid.length) * 3];
        Consumer<String[]> consumer = (gridMatrix) -> this.prepareList(gridMatrix);
        consumer.accept(grid);
        BiConsumer<List<String>, int[][]> biConsumer = (list, inputMatrix) -> this.prepareMatrixArray(list,
                inputMatrix);
        biConsumer.accept(listOfRegions, matrix);
        Function<int[][], Integer> function = (inputMatrix) -> this.breathFirstSearch(inputMatrix);
        return function.apply(matrix);
    }

    private void prepareList(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            String currentStr = grid[i];
            int innerRound = 0;
            while (innerRound < 3) {
                for (int j = 0; j < currentStr.length(); j++) {
                    List<String> list = mapper.get(currentStr.charAt(j));
                    builder.append(list.get(innerRound));
                }
                listOfRegions.add(builder.toString());
                builder.delete(0, builder.length());
                innerRound++;
            }
        }
    }

    private void prepareMatrixArray(List<String> list, int[][] matrix) {
        for (int i = 0; i < list.size(); i++) {
            String region = list.get(i);
            for (int j = 0; j < region.length(); j++)
                matrix[i][j] = region.charAt(j) - '0';
        }
    }

    private int breathFirstSearch(int[][] matrix) {
        int regionCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    regionCount++;
                    this.visitNeighBourRegions(i, j, matrix);
                }
            }
        }
        return regionCount;
    }

    private void visitNeighBourRegions(int i, int j, int[][] matrix) {
        List<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(i, j));
        while (!queue.isEmpty()) {
            List<Integer> currentBlock = queue.get(0);
            int row = currentBlock.get(0), column = currentBlock.get(1);
            // Left
            this.checkBoundaryAndMarkVisited(matrix, queue, row, column - 1);
            // Right
            this.checkBoundaryAndMarkVisited(matrix, queue, row, column + 1);
            // Top
            this.checkBoundaryAndMarkVisited(matrix, queue, row + 1, column);
            // Bottom
            this.checkBoundaryAndMarkVisited(matrix, queue, row - 1, column);
            queue.remove(0);
        }
    }

    private void checkBoundaryAndMarkVisited(int[][] matrix, List<List<Integer>> queue, int i, int j) {
        if (i >= 0 && j >= 0 && i <= matrix.length - 1 && j <= matrix.length - 1 && matrix[i][j] == 0) {
            queue.add(Arrays.asList(i, j));
            matrix[i][j] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        String[] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter grid length : ");
            int length = sc.nextInt();
            grid = new String[length];
            for (int i = 0; i < length; i++)
                grid[i] = sc.useDelimiter("\n").nextLine();
            Function<String[], Integer> function = (input) -> new RegionsCutBySlashes().regionsBySlashes(input);
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred :" + e.getMessage());
            e.printStackTrace();
        }
    }
}
