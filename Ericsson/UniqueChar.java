package Ericsson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueChar {
    public static void main(String[] args){
        Scanner sc;
        Map<Character,Integer> map=new HashMap<>();
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter the name to find number of characters occurence : ");
            String string=sc.nextLine();
            for(int i=0;i<string.length();i++){
                if(map.containsKey(string.charAt(i)))
                    map.put(string.charAt(i), map.get(string.charAt(i))+1);
                else
                    map.put(string.charAt(i), 1);
            }
            System.out.println(map);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
