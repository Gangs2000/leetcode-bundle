import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RelativeRanks {
    Comparator<Integer> comparator;
    public RelativeRanks(){
        comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
    }
    public String[] findRelativeRanks(int[] score) {
        String[] positions=new String[score.length];
        List<Integer> sortedList=Arrays.stream(score).boxed().collect(Collectors.toList());
        Collections.sort(sortedList, comparator);
        for(int i=0;i<score.length;i++){
            int index=(sortedList.indexOf(score[i]))+1;
            switch (index) {
                case 1: positions[i]="Gold Medal"; break;
                case 2: positions[i]="Silver Medal"; break;
                case 3: positions[i]="Bronze Medal"; break;
                default: positions[i]=String.valueOf(index); break;
            }
        }
        return positions;
    }    
    public static void main(String[] args) {
        Scanner sc;
        int[] score;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of score array :");
            int length=sc.nextInt();
            score=new int[length];
            for(int i=0;i<length;i++)
                score[i]=sc.nextInt();
            System.out.println(new RelativeRanks().findRelativeRanks(score));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
