import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class FindXSumofAllKLongSubarrays {
    Map<Long, Long> freqMapper;
    Queue<List<Long>> queue;

    public FindXSumofAllKLongSubarrays() {
        freqMapper = new TreeMap<>();
        queue = new PriorityQueue<>(new Comparator<List<Long>>() {
            @Override
            public int compare(List<Long> o1, List<Long> o2) {
                if (o1.get(1) == o2.get(1))
                    return o2.get(0).compareTo(o1.get(0));
                return o2.get(1).compareTo(o1.get(1));
            }
        });
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int leftPointer = 0, rightPointer = 0;
        long[] result = new long[nums.length - k + 1];
        while (leftPointer <= nums.length - k) {
            while (rightPointer - leftPointer != k) {
                long key = Long.valueOf(nums[rightPointer]);
                freqMapper.putIfAbsent(key, 0L);
                if (freqMapper.get(key) == 0L)
                    queue.add(Arrays.asList(key, 0L));
                freqMapper.put(key, freqMapper.get(key) + 1);
                long frequency = freqMapper.get(key);
                if (queue.contains(Arrays.asList(key, frequency - 1))) {
                    queue.remove(Arrays.asList(key, frequency - 1));
                    queue.add(Arrays.asList(key, frequency));
                }
                rightPointer++;
            }
            // Handle core logic
            result[leftPointer] = this.returnCummulativeSumOfFirstX(new PriorityQueue<>(queue), x);
            Long key = Long.valueOf(nums[leftPointer]);
            long currentFreq = freqMapper.get(key);
            if (currentFreq - 1 != 0) {
                freqMapper.put(key, currentFreq - 1);
                if (queue.contains(Arrays.asList(key, currentFreq))) {
                    queue.remove(Arrays.asList(key, currentFreq));
                    queue.add(Arrays.asList(key, currentFreq - 1));
                }
            } else {
                freqMapper.remove(key);
                queue.remove(Arrays.asList(key, currentFreq));
            }
            leftPointer++;
        }
        return result;
    }

    private long returnCummulativeSumOfFirstX(Queue<List<Long>> queue, int x) {
        int index = 0;
        long cummulativeSum = 0;
        while (index < x) {
            if (!queue.isEmpty()) {
                List<Long> list = queue.poll();
                cummulativeSum = cummulativeSum + (list.get(0) * list.get(1));
            }
            index++;
        }
        return cummulativeSum;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            System.out.println("Enter K and X values : ");
            int k = sc.nextInt(), x = sc.nextInt();
            System.out.println(new FindXSumofAllKLongSubarrays().findXSum(nums, k, x));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
