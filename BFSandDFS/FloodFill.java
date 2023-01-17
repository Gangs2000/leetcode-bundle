import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FloodFill {
    List<List<Integer>> queue;    
    int adjGridVal=0;
    public FloodFill(){
        queue=new LinkedList<>();
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;        
        adjGridVal=image[sr][sc];
        queue.add(List.of(sr,sc));
        image[sr][sc]=color;
        while(!queue.isEmpty()){
            int row=queue.get(0).get(0);
            int column=queue.get(0).get(1);
            fillFloodWithGivenColor(row, column-1, image, color);     //Left
            fillFloodWithGivenColor(row, column+1, image, color);     //Right
            fillFloodWithGivenColor(row-1, column, image, color);     //Top
            fillFloodWithGivenColor(row+1, column, image, color);     //Bottom
            if(queue.isEmpty())
                break;
            queue.remove(0);
        }        
        return image;
    }
    public void fillFloodWithGivenColor(int i, int j, int[][] image , int color){
        if(i>=0 && i<=image.length-1 && j>=0 && j<=image[i].length-1){
            if(image[i][j]==adjGridVal){
                image[i][j]=color;
                queue.add(List.of(i,j));
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner;
        int[][] edges;
        try{
            scanner=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            edges=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    edges[i][j]=scanner.nextInt();
                }
            }
            System.out.println("Enter Source Row and Source Column values : ");
            int sr=scanner.nextInt();
            int sc=scanner.nextInt();
            System.out.println("Enter color value to be filled : ");
            int color=scanner.nextInt();
            System.out.println(new FloodFill().floodFill(edges, sr, sc, color));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
