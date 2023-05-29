package LeetcodeDailyStreaks;

import java.util.Scanner;

public class RobotReturntoOrigin {
    int row=0, column=0;
    public boolean judgeCircle(String moves) {
        for(int i=0;i<moves.length();i++){
            switch(moves.charAt(i)){
                case 'L' : column--; break;
                case 'R' : column++; break;
                case 'U' : row--; break;
                case 'D' : row++; break;
            }            
        }
        return (row==0 && column==0);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Instruction to operate robot : ");
            String moves=sc.next().toUpperCase();
            System.out.println(new RobotReturntoOrigin().judgeCircle(moves));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
