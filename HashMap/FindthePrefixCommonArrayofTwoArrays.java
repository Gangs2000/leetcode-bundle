import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BinaryOperator;

public class FindthePrefixCommonArrayofTwoArrays {
    Set<Integer> set;

    public FindthePrefixCommonArrayofTwoArrays() {
        set = new HashSet<>();
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int commonSeenSoFar = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i] && !set.contains(A[i])) {
                set.add(A[i]);
                A[i] = ++commonSeenSoFar;
            } else {
                if (!set.contains(A[i]))
                    set.add(A[i]);
                else
                    commonSeenSoFar++;
                if (!set.contains(B[i]))
                    set.add(B[i]);
                else
                    commonSeenSoFar++;
                A[i] = commonSeenSoFar;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] a, b;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of A and B array length : ");
            int length = sc.nextInt();
            a = new int[length];
            b = new int[length];
            for (int i = 0; i < length; i++) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            BinaryOperator<int[]> binaryOperator = new FindthePrefixCommonArrayofTwoArrays()::findThePrefixCommonArray;
            System.out.println(binaryOperator.apply(a, b));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
