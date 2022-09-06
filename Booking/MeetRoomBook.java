import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
class MeetRoomBook
{
    int maxMeetNum=0;
    private void checkSlot(TreeMap<Integer,Integer> tm,ArrayList<Integer> unSortedStartTime)
    {
        for(Map.Entry entry : tm.entrySet())
        {
            if((int) entry.getValue()>maxMeetNum)
            {
                if((int) entry.getValue()<(int) entry.getKey())
                {
                    maxMeetNum=(int) entry.getKey();
                    System.out.print(((unSortedStartTime.indexOf(entry.getKey()))+1)+" ");
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc;
        ArrayList<Integer> unSortedStartTime;
        TreeMap<Integer,Integer> tm;                       //TreeMap implicity sorts its key in ascending order
        int meetingSlots=0;
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter number of meeting slots : ");
            meetingSlots=sc.nextInt();
            tm=new TreeMap<Integer,Integer>();
            unSortedStartTime=new ArrayList<Integer>();
            for(int i=0;i<meetingSlots;i++)
            {
                System.out.println("Enter meeting slot start time : ");
                int value=sc.nextInt();
                System.out.println("Enter meeting slot end time : ");
                int key=sc.nextInt();
                unSortedStartTime.add(key);                //Adding start time unsorted form
                tm.put(key,value);
            }
            new MeetRoomBook().checkSlot(tm,unSortedStartTime);
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
