package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.Stack;

public class AsteroidCollision {
    Stack<Integer> stack;
    int[] result;    
    public AsteroidCollision(){
        stack=new Stack<>();
    }
    public int[] asteroidCollision(int[] asteroids) {
        for(int i=0;i<asteroids.length;i++){
            if(stack.isEmpty())
                stack.push(asteroids[i]);
            else{
                boolean isCurrentAsteroidBigEnough=true;
                while((!stack.isEmpty()) && (stack.peek()>0 && asteroids[i]<0)){
                    if(Math.abs(asteroids[i])>stack.peek())
                        stack.pop();                        
                    else {
                        if(Math.abs(asteroids[i])==stack.peek())
                            stack.pop();
                        isCurrentAsteroidBigEnough=false;
                        break;
                    }
                }                
                if(isCurrentAsteroidBigEnough)
                    stack.push(asteroids[i]);
            }            
        }        
        result=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
            result[i]=stack.pop();
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] asteroids;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of asteroids array : ");
            int length=sc.nextInt();
            asteroids=new int[length];
            for(int i=0;i<length;i++)
                asteroids[i]=sc.nextInt();
            System.out.println(new AsteroidCollision().asteroidCollision(asteroids));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
