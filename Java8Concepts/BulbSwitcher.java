import java.util.Scanner;
class BulbSwitcher {
    private static int bulbSwitch(long[] bulbs){
        int numOfBulbsTuredOn=0;
        for(int i=1;i<=bulbs.length;i++){
            for(int j=0;j<bulbs.length;j++){
                if((j+1)%i==0)
                    bulbs[j]=(bulbs[j]==0)?(1):(0);
                if(i==bulbs.length)
                    numOfBulbsTuredOn=(bulbs[j]==1)?(numOfBulbsTuredOn+1):(numOfBulbsTuredOn);
            }
        }
        return numOfBulbsTuredOn;
    }
    public static void main(String[] args){
        Scanner sc;
        int numOfBulbs;
        long bulbs[];
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of bulbs in the room : ");
            numOfBulbs=sc.nextInt();
            bulbs=new long[numOfBulbs];
            for(int i=0;i<numOfBulbs;i++)
                bulbs[i]=0;                            //Inserting 0 as initial status, 0 means bulbs are turned off..
            System.out.println("Number of bulbs turned on at last iteration is "+BulbSwitcher.bulbSwitch(bulbs));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
