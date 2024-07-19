import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FindtheWinneroftheCircularGame {
    Deque<Integer> players;
    public FindtheWinneroftheCircularGame(){
        players=new ArrayDeque<>();
    }
    public int findTheWinner(int n, int k) {
        //Load all players
        int count=k;
        this.initializeAllPlayes(n);
        //Keep looping Deque array till it's size becomes 1
        while (players.size()!=1) {
            //Keep adding players to the last till count reaches 1
            while (count>1) {
                players.offerLast(players.poll());
                count--;
            }
            //Eliminate first player after passing K players
            players.poll();
            //Reset count value to K again for next set of elimination
            count=k;
        }
        return players.getFirst();
    }
    private void initializeAllPlayes(int n){
        for(int i=1;i<=n;i++)
            players.add(i);
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter N and K values : ");
            int n=sc.nextInt();
            int k=sc.nextInt();
            System.out.println(new FindtheWinneroftheCircularGame().findTheWinner(n, k));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
