import java.util.Arrays;
import java.util.Scanner;

public class EliminateMaximumNumberofMonsters {
    int killedMonsters=1;
    int[] timeArr;
    public int eliminateMaximum(int[] dist, int[] speed) {        
        timeArr=new int[dist.length];
        for(int i=0;i<dist.length;i++)
            timeArr[i]=((int) Math.ceil(((double) dist[i]/(double) speed[i])));
        Arrays.sort(timeArr);
        for(int i=1;i<timeArr.length;i++){
            if(timeArr[i]==i)
                break;
            else
                killedMonsters++;
        }
        return killedMonsters;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] distance, speed;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of distance and speed array : ");
            int length=sc.nextInt();
            distance=new int[length];
            System.out.println("Enter distance array elements : ");
            for(int i=0;i<length;i++)
                distance[i]=sc.nextInt();            
            speed=new int[length];
            System.out.println("Enter speed array elements : ");
            for(int i=0;i<length;i++)
                speed[i]=sc.nextInt();
            System.out.println(new EliminateMaximumNumberofMonsters().eliminateMaximum(distance, speed));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
