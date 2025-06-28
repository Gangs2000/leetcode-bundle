import java.util.Scanner;

public class DivideaStringIntoGroupsofSizek {
    String[] resultArr;

    public String[] divideString(String s, int k, char fill) {
        int arrSize = (s.length() % k == 0) ? s.length() / k : (s.length() / k) + 1, index = 0;
        resultArr = new String[arrSize];
        for (int i = 0; i < arrSize; i++) {
            if (s.length() - index >= k) {
                resultArr[i] = s.substring(index, index + k);
                index = index + k;
            } else {
                StringBuilder builder = new StringBuilder();
                builder.append(s.substring(index, s.length()));
                int start = 0, end = builder.length();
                while (start < k - end) {
                    builder.append(fill);
                    start++;
                }
                resultArr[i] = builder.toString();
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Enter String value : ");
            String string = sc.nextLine();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            System.out.println("Enter character value to be filled : ");
            char character = sc.next().charAt(0);
            System.out.println(new DivideaStringIntoGroupsofSizek().divideString(string, k, character));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
