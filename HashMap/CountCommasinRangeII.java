import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class CountCommasinRangeII {
    Map<Integer, long[]> rangeMapper;

    public CountCommasinRangeII() {
        rangeMapper = new LinkedHashMap<>();
        rangeMapper.put(1, new long[] { 1000l, 999999l });
        rangeMapper.put(2, new long[] { 1000000l, 999999999l });
        rangeMapper.put(3, new long[] { 1000000000l, 999999999999l });
        rangeMapper.put(4, new long[] { 1000000000000l, 999999999999999l });
        rangeMapper.put(5, new long[] { 1000000000000000l, 1000000000000000l });
    }

    public long countCommas(long n) {
        if (n <= 999)
            return 0l;
        int rangeFound = 0;
        for (Map.Entry<Integer, long[]> entry : rangeMapper.entrySet()) {
            long[] range = entry.getValue();
            long lowerRange = range[0], higherRange = range[1];
            if (lowerRange <= n && higherRange >= n) {
                range[1] = n;
                rangeFound = entry.getKey();
                break;
            }
        }
        long result = 0l;
        while (rangeFound >= 1) {
            long[] range = rangeMapper.get(rangeFound);
            long higherBound = range[1], lowerBound = range[0];
            result += ((higherBound - lowerBound) + 1) * rangeFound;
            rangeFound--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            long n = sc.nextLong();
            UnaryOperator<Long> unaryOperator = new CountCommasinRangeII()::countCommas;
            System.out.println(unaryOperator.apply((long) n));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
