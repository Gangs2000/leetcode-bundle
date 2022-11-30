import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WhereBallWillFall {
    private static List<Integer> predictColumnsWhereBallWillFall(List<List<Integer>> grid){
        List<Integer> outputList=new LinkedList<>();
        int columnFlag=0; boolean flag=true;
        for(int i=0;i<grid.get(0).size();i++){
            if(i==0 && grid.get(0).get(0)==-1)                
                outputList.add(-1);
            else if(i==grid.get(0).size()-1 && grid.get(0).get(grid.size()-1)==1)                
                outputList.add(-1);
            else{
                columnFlag=(i==grid.get(0).size()-1)?(i):(i+1);                                        
                for(int j=1;j<grid.size();j++){                                        
                    if(grid.get(j).get(columnFlag)==1){
                        if(grid.get(j).get(columnFlag)==grid.get(j).get(columnFlag+1))
                            columnFlag++;
                        else{                            
                            flag=false;
                            break;
                        }
                    }
                    else{
                        if(grid.get(j).get(columnFlag)==-1){
                            if(grid.get(j).get(columnFlag)==grid.get(j).get(columnFlag-1))
                                columnFlag--;
                            else{                                
                                flag=false;
                                break;
                            }
                        }
                    }
                }   
                //Adding value to the list according to flag indigation
                if(flag)
                    outputList.add(columnFlag);
                else 
                    outputList.add(-1);
                //Resetting values to default for next iteration
                columnFlag=0; flag=true;                                    
            }
        }
        return outputList;
    }
    public static void main(String[] args){
        Scanner sc;
        List<List<Integer>> grid;
        try{
            sc=new Scanner(System.in);
            grid=new LinkedList<>();
            System.out.println("Enter row value : ");
            int rows=sc.nextInt();
            System.out.println("Enter column value : ");
            int columns=sc.nextInt();
            for(int i=0;i<rows;i++){
                List<Integer> rowList=new LinkedList<>();
                for(int j=0;j<columns;j++)
                    rowList.add(sc.nextInt());
                grid.add(rowList);            
            }
            System.out.println("Predicted Columns where ball will fall as soon as drops "+WhereBallWillFall.predictColumnsWhereBallWillFall(grid));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }        
    }
}
