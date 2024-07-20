import java.util.Arrays;
import java.util.Scanner;

public class FindValidMatrixGivenRowandColumnSums {
    int[][] originalMatrix;
    int[] currentRowSum, currentColumnSum;
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        originalMatrix=new int[rowSum.length][colSum.length];
        Arrays.stream(originalMatrix).forEach(t -> Arrays.fill(t, 0));
        currentRowSum=new int[rowSum.length];
        Arrays.fill(currentRowSum, 0);
        currentColumnSum=new int[colSum.length];
        Arrays.fill(currentColumnSum, 0);
        for(int i=0;i<originalMatrix.length;i++){
            for(int j=0;j<originalMatrix[i].length;j++){
                originalMatrix[i][j]=Math.min(rowSum[i]-currentRowSum[i], colSum[j]-currentColumnSum[j]);
                currentRowSum[i]+=originalMatrix[i][j];
                currentColumnSum[j]+=originalMatrix[i][j];
            }
        }
        return originalMatrix;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] rowSum, columnSum;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length rowSum array : ");
            int rowsLength=sc.nextInt();
            rowSum=new int[rowsLength];
            for(int i=0;i<rowsLength;i++)
                rowSum[i]=sc.nextInt();
            System.out.println("Enter length of columnSum array : ");
            int columnsLength=sc.nextInt();
            columnSum=new int[columnsLength];
            for(int i=0;i<columnsLength;i++)
                columnSum[i]=sc.nextInt();
            System.out.println(new FindValidMatrixGivenRowandColumnSums().restoreMatrix(rowSum, columnSum));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
