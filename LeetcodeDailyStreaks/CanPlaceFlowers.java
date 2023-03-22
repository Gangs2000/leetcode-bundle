package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {     
        if(flowerbed.length==1) 
            return (flowerbed[0]==0)?(true):((n==0)?(true):(false));               
        for(int i=0;i<flowerbed.length;i++){
            if(n!=0){
                if(flowerbed[i]==0 && i==0){
                    if(flowerbed[i+1]==0){
                        flowerbed[i]=1;
                        n--;
                    }
                }   
                else if(flowerbed[i]==0 && i==flowerbed.length-1){
                    if(flowerbed[i-1]==0){
                        flowerbed[i]=1;
                        n--;
                    }
                }
                else if(flowerbed[i]==0){
                    if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                        flowerbed[i]=1;
                        n--;
                    }
                }
            }
            else
                break;
        }
        return n==0;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] flowerbed;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of flowerbed array : ");
            int length=sc.nextInt();
            flowerbed=new int[length];
            for(int i=0;i<length;i++)
                flowerbed[i]=sc.nextInt();
            System.out.println("Enter number of floweres to be planted : ");
            int n=sc.nextInt();
            System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
