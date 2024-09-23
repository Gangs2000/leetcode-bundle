import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LexicographicalNumbers {
    List<Integer> resultList;
    StringBuilder stringBuilder;

    public LexicographicalNumbers() {
        resultList = new LinkedList<>();
        stringBuilder = new StringBuilder();
    }

    public List<Integer> lexicalOrder(int n) {
        IntStream.range(1, 10).boxed()
                .forEach(number -> {
                    this.depthFirstSearch(n, stringBuilder.append(String.valueOf(number)), resultList);
                    stringBuilder.deleteCharAt(0);
                });
        return resultList;
    }

    private void depthFirstSearch(int limit, StringBuilder builder, List<Integer> list) {
        if (Integer.valueOf(builder.toString()) > limit)
            return;
        list.add(Integer.valueOf(builder.toString()));
        IntStream.range(0, 10).boxed().forEach(toBeAppended -> {
            this.depthFirstSearch(limit, builder.append(toBeAppended), list);
            builder.deleteCharAt(builder.length() - 1);
        });
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n = sc.nextInt();
            Function<Integer, List<Integer>> function = (input) -> new LexicographicalNumbers().lexicalOrder(input);
            System.out.println(function.apply(n));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
