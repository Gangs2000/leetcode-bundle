package LeetcodeDailyStreaks;

import java.util.Scanner;

public class NumOfValidClocks {
    int count=1;
    public int countTime(String time) {
        String[] splitStr=time.split(":");           
        return count*this.checkValidCountForHours(splitStr[0])*this.checkValidCountForMinutes(splitStr[1]);
    }
    public int checkValidCountForHours(String hours){
        if(hours.equals("??"))
            return 24;
        else
            return (hours.charAt(0)=='?')?((hours.charAt(1)-'0')<=3)?(3):(2):((hours.charAt(1)=='?')?((hours.charAt(0)-'0')<=1)?(10):(4):(1));
    }
    public int checkValidCountForMinutes(String minutes){
        if(minutes.equals("??"))
            return 60;
        else
            return (minutes.charAt(0)=='?')?(6):((minutes.charAt(1)=='?')?(10):(1));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a time between 00:00 - 23:59 to find out number of valid clocks : ");
            String clock=sc.nextLine();
            System.out.println(new NumOfValidClocks().countTime(clock));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
