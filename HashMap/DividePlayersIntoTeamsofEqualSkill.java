import java.util.Arrays;
import java.util.Scanner;

public class DividePlayersIntoTeamsofEqualSkill {
    long productOfScore=0, targetScore=0;
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int leftPointer=0, rightPointer=skill.length-1;
        while(leftPointer<rightPointer){
            if(leftPointer==0 && rightPointer==skill.length-1)
                targetScore=skill[leftPointer]+skill[rightPointer];
            else if(skill[leftPointer]+skill[rightPointer]!=targetScore)
                return -1;
            productOfScore+=(skill[leftPointer]*skill[rightPointer]);
            leftPointer++; rightPointer--;
        }
        return productOfScore;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] skill;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of skill array : ");
            int length=sc.nextInt();
            skill=new int[length];
            for(int i=0;i<length;i++)
                skill[i]=sc.nextInt();
            
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
