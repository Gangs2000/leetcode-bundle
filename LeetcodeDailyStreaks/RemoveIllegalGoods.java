package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RemoveIllegalGoods {    
    List<Integer> leftList, rightList;
    public RemoveIllegalGoods(){
        leftList=new LinkedList<>();
        rightList=new LinkedList<>();
    }
    int minimumTime=Integer.MAX_VALUE;
    public int minimumTime(String s) {        
        for(int i=0;i<s.length();i++){
            //From Left to Right
            if(leftList.size()==0 && s.charAt(i)=='1')
                leftList.add(i+1);
            else if(leftList.size()==0 && s.charAt(i)=='0')
                leftList.add(0);
            else{
                if(s.charAt(i)=='1')                    
                    leftList.add(Math.min(i+1, leftList.get(i-1)+2));
                else if(s.charAt(i)=='0')
                    leftList.add(leftList.get(i-1));
            }
            //From Right to Left
            if(rightList.size()==0 && s.charAt(s.length()-i-1)=='1')
                rightList.add(1);
            else if(rightList.size()==0 && s.charAt(s.length()-i-1)=='0')
                rightList.add(0);
            else{                
                if(s.charAt(s.length()-i-1)=='1')                    
                    rightList.add(Math.min(i+1, rightList.get(i-1)+2));
                else if(s.charAt(s.length()-i-1)=='0')
                    rightList.add(rightList.get(i-1));
            }
        }                       
        for(int i=0;i<s.length()-1;i++){
            int sumNum=leftList.get(i)+rightList.get(rightList.size()-i-2);                     
            if(sumNum<minimumTime)
                minimumTime=sumNum;
        }
        minimumTime=Math.min(minimumTime, leftList.get(leftList.size()-1));
        minimumTime=Math.min(minimumTime, rightList.get(rightList.size()-1));        
        return minimumTime;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to remove all illegal good in minimum time : ");
            String cars=sc.nextLine();
            System.out.println(new RemoveIllegalGoods().minimumTime(cars));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
