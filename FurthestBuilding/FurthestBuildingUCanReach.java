package FurthestBuilding;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FurthestBuildingUCanReach {
    private static int getFurthestBuildingIndex(List<Integer> buildings, int bricks, int ladders){
        int maxValue=0,index=0;
        for(int i=0;i<buildings.size()-1;i++){
            if(i==buildings.size()-1)
                break;
            else if(buildings.get(i)>buildings.get(i+1))
                index++;
            else if((buildings.get(i)<buildings.get(i+1)) && ladders!=0){
                maxValue=(buildings.get(i+1)-buildings.get(i)>maxValue)?(buildings.get(i+1)-buildings.get(i)):(maxValue);
                ladders--;
                index++;
            }
            else if((buildings.get(i)<buildings.get(i+1)) && ladders==0){
                if((buildings.get(i+1)-buildings.get(i)<maxValue) && bricks>=buildings.get(i+1)-buildings.get(i)){
                    bricks=bricks-(buildings.get(i+1)-buildings.get(i));
                    index++;
                }
                else if(bricks>=maxValue){
                    bricks=bricks-maxValue;
                    index++;
                }
                else
                    break;
            }
            else
                break;
        }
        return index;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> buildings;
        try{
            sc=new Scanner(System.in);
            buildings=new LinkedList<>();
            System.out.println("Enter buildings length : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                buildings.add(sc.nextInt());
            System.out.println("Enter number of bricks and ladders : ");
            int bricks=sc.nextInt(); 
            int ladders=sc.nextInt();
            System.out.println("Furthest Building that can be reachable is "+FurthestBuildingUCanReach.getFurthestBuildingIndex(buildings, bricks, ladders));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
