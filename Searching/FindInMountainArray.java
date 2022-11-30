import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindInMountainArray {
    private static int returnMinimumIndexValue(int target, List<Integer> numbers){
        int leftFlag=0, rightFlag=0;
        int peakElementIndex=FindInMountainArray.returnPeakElementIndex(numbers);
        leftFlag=FindInMountainArray.doBinarySearch(numbers.subList(0, peakElementIndex+1), target);        
        if(leftFlag==0) {
            List<Integer> sortedList=numbers.subList(peakElementIndex, numbers.size()).stream().sorted().collect(Collectors.toList());
            rightFlag=FindInMountainArray.doBinarySearch(sortedList, target);
            if(rightFlag!=0)
                rightFlag=(sortedList.size()-1)-rightFlag+peakElementIndex;                      
        }            
        return (leftFlag!=0)?(leftFlag):((rightFlag!=0)?(rightFlag):(-1));
    }
    private static int returnPeakElementIndex(List<Integer> numbers){
        int indexValue=numbers.stream().max(Integer::compareTo).get();
        return numbers.indexOf(indexValue);
    }
    private static int doBinarySearch(List<Integer> numbers, int target){
        int index=0;
        int lowerBound=0, higherBound=numbers.size()-1;
        while(lowerBound<=higherBound){
            int middle=(lowerBound+higherBound)/2;
            if(numbers.get(middle)==target){
                index=(middle<index)?(middle):(index);
                break;
            }                                        
            else if(numbers.get(middle)<target)
                lowerBound=middle+1;
            else if(numbers.get(middle)>target)
                higherBound=middle-1;
        }
        return index;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> numbers;
        try {
            sc=new Scanner(System.in);
            numbers=new LinkedList<>();
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                numbers.add(sc.nextInt());
            System.out.println("Enter target value : ");
            int target=sc.nextInt();
            System.out.println("Minimum index value in mountain array is "+FindInMountainArray.returnMinimumIndexValue(target, numbers));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
