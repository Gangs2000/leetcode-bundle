import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import FunctionalInterface.Function;

public class MaximizeDistanceToClosestPerson {
    private static int distance=0;
    private static int returnMaximumDistance(List<Integer> seats){
        List<Integer> getPersonSeatsIndex=new LinkedList<>();        
        for(int i=0;i<seats.size();i++)
            if(seats.get(i)==1)
                getPersonSeatsIndex.add(i);        
        if(!getPersonSeatsIndex.contains(0))
            getPersonSeatsIndex.add(0);
        if(!getPersonSeatsIndex.contains(seats.size()-1))
            getPersonSeatsIndex.add(seats.size()-1);
        getPersonSeatsIndex=getPersonSeatsIndex.stream().sorted().collect(Collectors.toList());    
        if(getPersonSeatsIndex.size()==1)
            distance=getPersonSeatsIndex.get(0);
        else if(getPersonSeatsIndex.size()==2)
            distance=getPersonSeatsIndex.get(getPersonSeatsIndex.size()-1);
        else {
            int maxValue=0;
            for(int i=0;i<getPersonSeatsIndex.size()-1;i++){
                int currentValue=(getPersonSeatsIndex.get(i+1)-getPersonSeatsIndex.get(i))/2;
                if(currentValue>maxValue)
                    maxValue=currentValue;
            }
            distance=maxValue;
        }    
        return distance;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> seats;
        try{
            sc=new Scanner(System.in);
            seats=new LinkedList<>();
            System.out.println("Enter the length of list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                seats.add(sc.nextInt());
            Function<List<Integer>,Integer> object=MaximizeDistanceToClosestPerson::returnMaximumDistance;
            System.out.println("Maximum distance to the closest person is "+object.apply(seats));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
