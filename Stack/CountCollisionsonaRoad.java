import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

public class CountCollisionsonaRoad {
    Stack<Character> stack;
    int collisionCount = 0;

    public CountCollisionsonaRoad() {
        stack = new Stack<>();
    }

    public int countCollisions(String directions) {
        for (int i = 0; i < directions.length(); i++) {
            if (stack.isEmpty())
                stack.push(directions.charAt(i));
            else {
                if (stack.peek() == 'S' && directions.charAt(i) == 'L') {
                    collisionCount++;
                    stack.push('S');
                } else if ((stack.peek() == 'R' && directions.charAt(i) == 'S')
                        || (stack.peek() == 'R' && directions.charAt(i) == 'L')) {
                    collisionCount = (directions.charAt(i) == 'S') ? collisionCount + 1 : collisionCount + 2;
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        collisionCount++;
                        stack.pop();
                    }
                    stack.push('S');
                } else
                    stack.push(directions.charAt(i));
            }
        }
        return collisionCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter directions string : ");
            String directions = sc.nextLine();
            Function<String, Integer> function = (input) -> new CountCollisionsonaRoad().countCollisions(input);
            System.out.println(function.apply(directions));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
