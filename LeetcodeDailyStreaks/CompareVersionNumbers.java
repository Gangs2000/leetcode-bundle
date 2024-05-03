import java.util.Scanner;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        return this.compareAndReturnResults(
            this.deleteLeadingZeroes(version1.split("\\.")), 
            this.deleteLeadingZeroes(version2.split("\\."))
        );
    }
    private int[] deleteLeadingZeroes(String[] splittedArray){
        int[] modifiedArray=new int[splittedArray.length];
        for(int i=0;i<splittedArray.length;i++)
            modifiedArray[i]=Integer.parseInt(splittedArray[i]);
        return modifiedArray;
    }
    private int compareAndReturnResults(int[] versionsOne, int[] versionsTwo){
        int minLen=Math.min(versionsOne.length, versionsTwo.length), start=0;
        while(start<minLen){
            if(versionsOne[start]<versionsTwo[start])
                return -1;
            else if(versionsOne[start]>versionsTwo[start])
                return 1;
            start++;
        }
        if(versionsOne.length!=versionsTwo.length){
            return (minLen==versionsOne.length)?
                    (this.compareRemainingElements(versionsTwo, start, -1)):
                    (this.compareRemainingElements(versionsOne, start, 1));
        }
        return 0;
    }
    private int compareRemainingElements(int[] array, int start, int valueToBeReturned){
        while(start<array.length){
            if(array[start]!=0)
                return valueToBeReturned;
            start++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter Version 1 value : ");
            String versionOne=sc.nextLine();
            System.out.println("Enter Version 2 value : ");
            String versionTwo=sc.nextLine();
            System.out.println(new CompareVersionNumbers().compareVersion(versionOne, versionTwo));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
