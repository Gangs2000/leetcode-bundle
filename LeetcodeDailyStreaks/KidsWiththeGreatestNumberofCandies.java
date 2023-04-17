package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class KidsWiththeGreatestNumberofCandies {
    List<Boolean> resulList;
    public KidsWiththeGreatestNumberofCandies(){
        resulList=new LinkedList<>();
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxAmongAllCandies=Arrays.stream(candies).boxed().max(Integer::compareTo).get();
        Arrays.stream(candies).forEach(element->{
            resulList.add(((element+extraCandies)>=maxAmongAllCandies)?(true):(false));
        });
        return resulList;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] candies;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of candies array : ");
            int length=sc.nextInt();
            candies=new int[length];
            System.out.println("Enter extra candies value : ");
            int extraCandies=sc.nextInt();
            System.out.println(new KidsWiththeGreatestNumberofCandies().kidsWithCandies(candies, extraCandies));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
