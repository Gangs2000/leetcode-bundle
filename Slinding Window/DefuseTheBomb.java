import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

class DefusetheBomb {
    int currentWindowSum = 0, currentIndex = 0;

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        Function<int[], int[]> function = (inputArr) -> this.spreadArray(inputArr);
        int[] circularArr = function.apply(code);
        return this.generateResultArr(code, circularArr, k);
    }

    private int[] spreadArray(int[] code) {
        int[] circularArr = new int[code.length * 2];
        for (int i = 0; i < code.length; i++) {
            circularArr[i] = code[i];
            circularArr[i + code.length] = code[i];
        }
        return circularArr;
    }

    private int[] generateResultArr(int[] code, int[] circularArr, int k) {
        // Initial Window Sum calculation
        if (k > 0)
            this.initialWindowCalculation(1, k, circularArr, code);
        else if (k < 0)
            this.initialWindowCalculation(code.length - Math.abs(k), code.length - 1, circularArr, code);
        int index = 1;
        while (index < code.length) {
            code[index] = currentWindowSum - circularArr[currentIndex] + (circularArr[currentIndex + Math.abs(k)]);
            currentWindowSum = code[index];
            currentIndex++;
            index++;
        }
        return code;
    }

    private void initialWindowCalculation(int start, int end, int[] circularArr, int[] code) {
        currentIndex = start;
        for (int i = start; i <= end; i++)
            currentWindowSum += circularArr[i];
        code[0] = currentWindowSum;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] code;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter the length of code array : ");
            int length = sc.nextInt();
            code = new int[length];
            for (int i = 0; i < length; i++)
                code[i] = sc.nextInt();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, int[]> biFunction = (input1, input2) -> new DefusetheBomb().decrypt(input1,
                    input2);
            System.out.println(biFunction.apply(code, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
