package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Combinations {
    List<List<Integer>> resultList;
    public Combinations(){
        resultList=new LinkedList<>();
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new LinkedList<>();
        backTracking(1, n, k, list);
        return resultList;
    }
    public void backTracking(int start, int n, int k, List<Integer> list){        
        if(k==0){            
            resultList.add(new LinkedList<>(list));
            return ;
        }
        if(start>n)
            return ;        
        list.add(start);        
        backTracking(start+1, n, k-1, list);
        list.remove(list.size()-1);        
        backTracking(start+1, n, k, list);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N and K value : ");
            int n=sc.nextInt();
            int k=sc.nextInt();
            System.out.println(new Combinations().combine(n, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
