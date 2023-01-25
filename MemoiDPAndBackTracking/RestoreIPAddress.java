package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RestoreIPAddress {
    List<String> result;
    public RestoreIPAddress(){
        result=new LinkedList<>();
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12)
            return result;            
        String currentString="";
        findAllValidIPAddress(s, 0, 0, currentString);
        return result;
    }
    public void findAllValidIPAddress(String s, int index, int parts, String currentString){        
        if(index==s.length() && parts==4){            
            currentString=currentString.substring(0, currentString.length()-1);
            result.add(currentString);
            return ;
        }
        if((index+1)<=s.length())
            findAllValidIPAddress(s, index+1, parts+1, currentString+s.substring(index, index+1)+".");
        if((index+2)<=s.length() && isSafeToProceed(s.substring(index, index+2)))
            findAllValidIPAddress(s, index+2, parts+1, currentString+s.substring(index, index+2)+".");
        if((index+3)<=s.length() && isSafeToProceed(s.substring(index, index+3)))
            findAllValidIPAddress(s, index+3, parts+1, currentString+s.substring(index, index+3)+".");
    }
    public boolean isSafeToProceed(String string){
        if(string.charAt(0)=='0')
            return false;        
        return Integer.valueOf(string)<=255;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String value to find out all possible IP address : ");
            String string=sc.next();
            System.out.println(new RestoreIPAddress().restoreIpAddresses(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
