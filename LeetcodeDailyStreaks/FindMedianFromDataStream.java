package LeetcodeDailyStreaks;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindMedianFromDataStream {
    static List<Integer> tempList;
    static List<Double> outputList;
    static List<List<Integer>> listNum;
    DecimalFormat decimalFormat;
    public FindMedianFromDataStream(){
        tempList=new LinkedList<>();
        outputList=new LinkedList<>();
        decimalFormat=new DecimalFormat("#0.0");
        outputList.add(null);
    }
    
    public void addNum(int num) {
        tempList.add(num);
        outputList.add(null);   
    }
    
    public double findMedian() {        
        double value=0;
        List<Integer> sortedList=tempList.stream().sorted().collect(Collectors.toList());
        if(sortedList.size()%2==0){
            int midIndex=sortedList.size()/2;
            value=Double.valueOf(decimalFormat.format((sortedList.get(midIndex)+sortedList.get(midIndex-1))/2.0));
        }   
        else
            value=Double.valueOf(decimalFormat.format(sortedList.get(sortedList.size()/2)));
        return value;
    }
    public static void main(String[] args){
        Scanner sc;
        List<String> labels;           
        FindMedianFromDataStream findMedianFromDataStream;     
        try{
            sc=new Scanner(System.in);
            labels=new LinkedList<>(); 
            listNum=new LinkedList<>();  
            findMedianFromDataStream=new FindMedianFromDataStream();         
            System.out.println("Enter length of the labels list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)   
                labels.add(sc.next());
            for(int i=0;i<length;i++){
                if(labels.get(i).equals("addNum"))
                    listNum.add(List.of(sc.nextInt()));
                else if(labels.get(i).equals("MedianFinder") || labels.get(i).equals("findMedian"))
                    listNum.add(List.of());
            }        
            for(int i=1;i<length;i++){
                if(labels.get(i).equals("addNum"))
                    findMedianFromDataStream.addNum(listNum.get(i).get(0));
                else if(labels.get(i).equals("findMedian"))
                   outputList.add(findMedianFromDataStream.findMedian());
            }        
            System.out.println(outputList);
        }
        catch(Exception e){
            System.out.println("Exception occured : ");
            e.printStackTrace();
        }
    }
}
