import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaximumBinaryTree {
    List<List<Integer>> leftNodeLists, rightNodeLists;
    List<Integer> outputList;
    public MaximumBinaryTree(){
        this.leftNodeLists=new LinkedList<>();
        this.rightNodeLists=new LinkedList<>();
        this.outputList=new LinkedList<>();        
    }
    private List<Integer> algorithm(List<Integer> list){        
        this.splitLeftRightAndRootValues(list);               
        if(leftNodeLists.size()!=0 || rightNodeLists.size()!=0){
            List<Integer> nodeValues=new LinkedList<>();            
            if(leftNodeLists.size()>=rightNodeLists.size()){                
                nodeValues=leftNodeLists.get(0);                   
                leftNodeLists.remove(0);                                              
            }
            else if(leftNodeLists.size()<rightNodeLists.size()){
                nodeValues=rightNodeLists.get(0);
                rightNodeLists.remove(0);                 
            }
            if(nodeValues.size()==0)
                outputList.add(null);            
            algorithm(nodeValues);                                                      //Recursive function call
        }
        return outputList;
    }
    private void splitLeftRightAndRootValues(List<Integer> list){
        if(list.size()>1){
            int rootValue=list.stream().max(Integer::compareTo).get();
            outputList.add(rootValue);                                                  //Adding root value to the list            
            leftNodeLists.add(list.subList(0, list.indexOf(rootValue)));                //Adding left prefix nodes to the list       
            rightNodeLists.add(list.subList(list.indexOf(rootValue)+1, list.size()));   //Adding right suffix nodes to the list        
        }
        else if(list.size()==1)
            outputList.add(list.get(0));
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> listOfNums;
        try{
            sc=new Scanner(System.in);
            listOfNums=new LinkedList<>();
            System.out.println("Enter the length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                listOfNums.add(sc.nextInt());
            System.out.println(new MaximumBinaryTree().algorithm(listOfNums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
