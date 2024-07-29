import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountNumberofTeams {
    Map<String, Integer> memoMapper;

    public CountNumberofTeams() {
        memoMapper = new HashMap<>();
    }

    //TLE
    public int firstApproach(int[] rating) {
        int[] memo = new int[rating.length + 1];
        Arrays.fill(memo, -1);
        return this.findAllCombination(0, rating, memoMapper, new LinkedList<>());
    }

    private int findAllCombination(int index, int[] ratings, Map<String, Integer> memoMap, List<Integer> list) {
        String key = index + ":" + (list.stream().map(String::valueOf).collect(Collectors.joining(",")));
        if (list.size() == 3) {
            if (memoMap.containsKey(key))
                return memoMap.get(key);
            Predicate<List<Integer>> predicate = (inputList) -> this.isValidList(inputList);
            int result = predicate.test(list) ? (1) : (0);
            memoMap.put(key, result);
            return result;
        }
        if (index >= ratings.length)
            return 0;
        if (memoMap.containsKey(key))
            return memoMap.get(key);
        int result = 0, take = 0, notTake = 0;
        list.add(ratings[index]);
        take = this.findAllCombination(index + 1, ratings, memoMap, list);
        list.remove(list.size() - 1);
        notTake = this.findAllCombination(index + 1, ratings, memoMap, list);
        memoMap.put(key, result);
        result = take + notTake;
        return result;
    }

    private boolean isValidList(List<Integer> list) {
        return ((list.get(0) < list.get(1) && list.get(1) < list.get(2)) ||
                (list.get(0) > list.get(1) && list.get(1) > list.get(2)));
    }

    public int secondApproach(int[] ratings){
        int[][][] memo=new int[ratings.length+1][ratings.length+1][4];
        this.setMemo(memo);
        int increasingCount=this.findIncreasing(-1, 0, 0, ratings, memo);
        this.setMemo(memo);
        int decreasingCount=this.findDecreasing(-1, 0, 0, ratings, memo);
        return increasingCount+decreasingCount;
    }

    private int findIncreasing(int prevIndex, int currentIndex, int count, int[] ratings, int[][][] memo){
        if(count==3)
            return 1;
        if(currentIndex==ratings.length)
            return 0;
        if(memo[prevIndex+1][currentIndex][count]!=-1)
            return memo[prevIndex+1][currentIndex][count];
        int take=0, notTake=0;
        if(prevIndex==-1 || ratings[currentIndex]>ratings[prevIndex])
            take=this.findIncreasing(currentIndex, currentIndex+1, count+1, ratings, memo);
        notTake=this.findIncreasing(prevIndex, currentIndex+1, count, ratings, memo);
        return memo[prevIndex+1][currentIndex][count]=take+notTake;
    }

    private int findDecreasing(int prevIndex, int currentIndex, int count, int[] ratings, int[][][] memo){
        if(count==3)
            return 1;
        if(currentIndex==ratings.length)
            return 0;
        if(memo[prevIndex+1][currentIndex][count]!=-1)
            return memo[prevIndex+1][currentIndex][count];
        int take=0, notTake=0;
        if(prevIndex==-1 || ratings[currentIndex]<ratings[prevIndex])
            take=this.findDecreasing(currentIndex, currentIndex+1, count+1, ratings, memo);
        notTake=this.findDecreasing(prevIndex, currentIndex+1, count, ratings, memo);
        return memo[prevIndex+1][currentIndex][count]=take+notTake;
    }

    private void setMemo(int[][][] memo){
        Arrays.stream(memo).forEach(outerArr -> Arrays.stream(outerArr).forEach(innerArr -> Arrays.fill(innerArr, -1)));
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] ratings;
        try {
            sc = new Scanner(System.in);
            System.out.println("Emter length of rating array : ");
            int length = sc.nextInt();
            ratings = new int[length];
            for (int i = 0; i < length; i++)
                ratings[i] = sc.nextInt();
            Function<int[], Integer> function = (arr) -> new CountNumberofTeams().firstApproach(arr);
            System.out.println(function.apply(ratings));
            function = (arr) -> new CountNumberofTeams().secondApproach(arr);
            System.out.println(function.apply(ratings));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}