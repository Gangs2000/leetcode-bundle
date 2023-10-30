import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BulbSwitcherII {
    List<List<Object>> queue;
    Set<String> allStatus;      
    public BulbSwitcherII(){
        allStatus=new HashSet<>();
        queue=new LinkedList<>();
    }
    public int flipLights(int n, int presses) {        
        if(n==1 && presses==0)
            return 1;
        char[] onState=new char[n];
        Arrays.fill(onState, '1');        
        //Initially All bulbs are turned on
        queue.add(List.of(String.valueOf(onState).toString(), 0));
        allStatus.add((String.valueOf(onState)).toString());
        while(!queue.isEmpty()){
            List<Object> firstQueue=queue.get(0);
            StringBuilder builder=new StringBuilder(String.valueOf(firstQueue.get(0)));
            int currentPress=(int) firstQueue.get(1);
            if(currentPress<presses){
                //Pressing button 1
                this.buttonFunction(builder, currentPress, presses, 1);
                //Pressing button 2
                this.buttonFunction(builder, currentPress, presses, 2);
                //Pressing button 3
                this.buttonFunction(builder, currentPress, presses, 3);
                //Pressing button 4
                this.buttonFunction(builder, currentPress, presses, 4);
            }            
            queue.remove(0);
        }
        return allStatus.size();
    }
    public void buttonFunction(StringBuilder builder, int currentPress, int presses, int function){
        StringBuilder stringBuilder=new StringBuilder(builder);
        //Toggle all bulb status to off
        if(function==1){
            char[] offState=new char[builder.length()];
            Arrays.fill(offState, '0');
            String offStateStr=String.valueOf(offState).toString();
            stringBuilder=new StringBuilder(offStateStr);
        }            
        //Toggle every even position bulbs
        else if(function==2){
            for(int i=0;i<stringBuilder.length();i=i+2){
                if(stringBuilder.charAt(i)=='0')
                    stringBuilder.setCharAt(i, '1');
                else if(stringBuilder.charAt(i)=='1')
                    stringBuilder.setCharAt(i, '0');                    
            }
        }
        //Toggle every odd position bulbs
        else if(function==3){
            for(int i=1;i<stringBuilder.length();i=i+2){
                if(stringBuilder.charAt(i)=='0')
                    stringBuilder.setCharAt(i, '1');
                else if(stringBuilder.charAt(i)=='1')
                    stringBuilder.setCharAt(i, '0');                    
            }
        }
        //Toggle every 3(i)+1 position bulbs
        else if(function==4){
            for(int i=1;i<stringBuilder.length();i=((3*i)+1)){
                if(stringBuilder.charAt(i)=='0')
                    stringBuilder.setCharAt(i, '1');
                else if(stringBuilder.charAt(i)=='1')
                    stringBuilder.setCharAt(i, '0');                    
            }
        }
        //Add bulb pattern in set as it maintains unique values..Then add it into the queue        
        if(currentPress+1<presses && !allStatus.contains(stringBuilder.toString()))
            queue.add(List.of(stringBuilder, currentPress+1));
        allStatus.add(stringBuilder.toString());        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println("Enter Presses value : ");
            int presses=sc.nextInt();
            System.out.println(new BulbSwitcherII().flipLights(n, presses));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
