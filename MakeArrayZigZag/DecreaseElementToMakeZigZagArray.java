package MakeArrayZigZag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecreaseElementToMakeZigZagArray {
    private static int modifyEvenIndexedElement(List<Integer> list){                //Pattern must be a[0]>a[1]<a[2]>a[3]<a[4]......
        int count=0;
        for(int i=0;i<list.size()-1;i++){
            if(i%2==0)
                count+=DecreaseElementToMakeZigZagArray.template2(list, i);                
            else if(i%2==1)
                count+=DecreaseElementToMakeZigZagArray.template1(list, i);                
        }
        return count;
    }
    private static int modifyOddIndexedElement(List<Integer> list){                 //Pattern must be a[0]<a[1]>a[2]<a[3]>a[4]......
        int count=0;
        for(int i=0;i<list.size()-1;i++){
            if(i%2==0)                
                count+=DecreaseElementToMakeZigZagArray.template1(list, i);                
            else if(i%2==1)                
                count+=DecreaseElementToMakeZigZagArray.template2(list, i);                
        }
        return count;
    }
    private static int template1(List<Integer> list, int index){
        int count=0;
        if(!(list.get(index)<list.get(index+1))){
            int oldValue=list.get(index);
            list.set(index, list.get(index+1)-1);
            count+=oldValue-list.get(index);
        }
        return count;
    }
    private static int template2(List<Integer> list, int index){
        int count=0;
        if(!(list.get(index)>list.get(index+1))){
            int oldValue=list.get(index+1);
            list.set((index+1), list.get(index)-1);
            count+=oldValue-list.get(index+1);
        }
        return count;
    }
    private static List<Integer> cloneListValues(List<Integer> list){               //Cloning original list values to fakeList to avoid data collision in list
        List<Integer> resultList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
            resultList.add(list.get(i));
        return resultList;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> listOfIntegers,cloneList;
        int minimumMoves=0;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            listOfIntegers=new ArrayList<>();
            cloneList=new ArrayList<>();
            for(int i=0;i<length;i++)
                listOfIntegers.add(sc.nextInt());       
            cloneList=DecreaseElementToMakeZigZagArray.cloneListValues(listOfIntegers);                     
            int evenIndexedOutput=DecreaseElementToMakeZigZagArray.modifyEvenIndexedElement(cloneList);                 
            cloneList.clear(); cloneList=DecreaseElementToMakeZigZagArray.cloneListValues(listOfIntegers);     //Clearing cloned list and again reinserting original list values to fakeList                     
            int oddIndexedOutput=DecreaseElementToMakeZigZagArray.modifyOddIndexedElement(cloneList);                 
            minimumMoves=(evenIndexedOutput<oddIndexedOutput)?(evenIndexedOutput):(oddIndexedOutput);
            System.out.println("Minimum moves required to make an array to ZigZag "+minimumMoves);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
