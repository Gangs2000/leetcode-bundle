import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import FunctionalInterface.*;

public class ValidSquare {
    public static int pythograsFormula(List<Integer> point1, List<Integer> point2){
        return (point1.get(0)-point2.get(0))*(point1.get(0)-point2.get(0))+(point1.get(1)-point2.get(1))*(point1.get(1)-point2.get(1));
    }
    public static boolean isValidSquare(List<Integer> distances){
        Map<Integer,Long> map=new HashMap<>();
        for(Integer distance : distances){
            if(!map.containsKey(distance))
                map.put(distance, distances.stream().filter(element->element==distance).count());
        }
        System.out.println(map);
        return (map.size()==2)?((map.containsValue(Long.valueOf(2)) && map.containsValue(Long.valueOf(4))?(true):(false))):(false);
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> distances;
        List<Integer> point1,point2,point3,point4;
        BiFunction<List<Integer>,List<Integer>,Integer> object1;
        Function<List<Integer>,Boolean> object2;
        try{
            sc=new Scanner(System.in);
            distances=new LinkedList<>();
            point1=new ArrayList<>();
            point2=new ArrayList<>();
            point3=new ArrayList<>();
            point4=new ArrayList<>();
            point1.add(0); point1.add(0);
            point2.add(1); point2.add(1);
            point3.add(1); point3.add(0);
            point4.add(0); point4.add(1);
            object1=ValidSquare::pythograsFormula;
            distances.add(object1.apply(point1, point2));
            distances.add(object1.apply(point1, point3));
            distances.add(object1.apply(point1, point4));
            distances.add(object1.apply(point2, point3));
            distances.add(object1.apply(point2, point4));
            distances.add(object1.apply(point3, point4));
            object2=ValidSquare::isValidSquare;
            if(object2.apply(distances))
                System.out.println("Given points made valid Square..");
            else
                System.out.println("Given points didn't make valid Square..");
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
