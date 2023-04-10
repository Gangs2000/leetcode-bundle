package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuccessfulPairsOfSpellsAndPotions {    
    int[] result;
    Map<Integer, Integer> map;
    public SuccessfulPairsOfSpellsAndPotions(){
        map=new HashMap<>();
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        result=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            if(!map.containsKey(spells[i])){                
                result[i]=this.binarySearch((long) spells[i], potions, success);
                map.put(spells[i], result[i]);
            }
            else
                result[i]=map.get(spells[i]);
        }
        return result;
    }
    public int binarySearch(long spell, int[] potions, long success){
        int start=0, end=potions.length-1;
        while(start<=end){
            int middle=start+(end-start)/2;            
            if((potions[middle]*spell)>=success){
                if(start==potions.length-1 && end==potions.length-1)
                    return 1;         
                end=middle-1;                    
            }                  
            else if((potions[middle]*spell)<success)
                start=middle+1;
        }                            
        return (start==potions.length-1)?(0):((potions.length-1-start)+1);               
    }    
    public static void main(String[] a){
        Scanner sc;
        int[] spells, potions;
        long success;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of spells array : ");
            int spellLength=sc.nextInt();
            spells=new int[spellLength];
            for(int i=0;i<spellLength;i++)
                spells[i]=sc.nextInt();
            int potionsLength=sc.nextInt();
            potions=new int[potionsLength];
            for(int i=0;i<potionsLength;i++)
                potions[i]=sc.nextInt();
            System.out.println("Enter Success Value : ");
            success=sc.nextLong();
            System.out.println(new SuccessfulPairsOfSpellsAndPotions().successfulPairs(spells, potions, success));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
