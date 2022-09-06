import java.util.ArrayList;
import java.util.Scanner;
class PredictWinner
{
    boolean turn=true,flag;
    int player1=0,player2=0;
    private boolean predictWinner(ArrayList<Integer> points)
    {
        if(points.size()==0)                       //Stops Recursion once size becomes 0
            flag=(player1>=player2)?(true):(false);
        else if(points.size()<=3)                  //When size falls less than or equal to 3, players should try to pick max values
        {
            if(turn)                               //Player1 turn
            {
                player1=(turn==true && points.get(0)>=points.get(points.size()-1))?(player1+=points.get(0)):(player1+=points.get(points.size()-1));
                if(points.get(0)>=points.get(points.size()-1))
                    points.remove(0);
                else
                    points.remove(points.size()-1);
                turn=false;
                predictWinner(points);              //Recursion
            }
            else                                    //Player2 turn
            {
                player2=(turn==false && points.get(0)>=points.get(points.size()-1))?(player2+=points.get(0)):(player2+=points.get(points.size()-1));
                if(points.get(0)>=points.get(points.size()-1))
                    points.remove(0);
                else
                    points.remove(points.size()-1);
                turn=true;
                predictWinner(points);               //Recursion
            }
        }
        else if(points.size()>3)                     //When size is greater than 3, players would need to think before picks max value
        {
            
            if(turn)                                 //Player1 turn
            {
                player1=(turn==true && (points.get(1)<=points.get(points.size()-2)))?(player1+=points.get(0)):(player1+=points.get(points.size()-1));
                if((points.get(1)<=points.get(points.size()-2)))
                    points.remove(0);
                else
                    points.remove(points.size()-1);
                turn=false;
                predictWinner(points);               //Recursion
            }
            else                                     //Player2 turn
            {
                player2=(turn==false && (points.get(1)<=points.get(points.size()-2)))?(player2+=points.get(0)):(player2+=points.get(points.size()-1));
                if((points.get(1)<=points.get(points.size()-2)))
                    points.remove(0);
                else
                    points.remove(points.size()-1);
                turn=true;
                predictWinner(points);                //Recursion
            }
        }
        return flag;
    }
    public static void main(String[] args)
    {
        Scanner sc;
        ArrayList<Integer> points;
        int size;
        try
        {
            sc=new Scanner(System.in);
            points=new ArrayList<Integer>();
            System.out.println("Enter size of an arraylist : ");
            size=sc.nextInt();
            for(int i=0;i<size;i++)
            {
                int value=sc.nextInt();
                if(value>=0)
                    points.add(value);
                else    
                    throw new Exception("Value must be greater than 0..");
            }
            System.out.println("Player 1 will win the game : "+new PredictWinner().predictWinner(points));
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}