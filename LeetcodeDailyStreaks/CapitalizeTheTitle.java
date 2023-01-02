package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CapitalizeTheTitle {
    String result="";
    public String capitalizeTitle(String title) {
        String[] words=title.split(" ");
        for(int i=0;i<words.length;i++){
            if(words[i].length()<=2)
                words[i]=words[i].toLowerCase();
            else
                words[i]=Character.toUpperCase(words[i].charAt(0))+words[i].substring(1, words[i].length()).toLowerCase();             
            result+=words[i];
        }
        return result.trim();        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter title to capitalize : ");
            String title=sc.useDelimiter("\n").next();
            System.out.println(new CapitalizeTheTitle().capitalizeTitle(title));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
