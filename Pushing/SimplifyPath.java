import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {    
    Stack<String> stack;
    public SimplifyPath(){
        stack=new Stack<>();             
    }
    public String simplifyPath(String path) {
        String tempStr="";
        path=path+"/";
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='/'){                
                if(tempStr.length()!=0){
                    if(tempStr.equals("..")){
                        if(!stack.isEmpty())
                            stack.pop();
                    }
                    else if(!tempStr.equals("."))
                        stack.push(tempStr+"/");                    
                }
                tempStr="";
            }
            else
                tempStr+=path.charAt(i);
        }     
        return this.mergePaths(stack);
    }
    public String mergePaths(Stack<String> stack){
        String simplifiedPath="";
        for(String str : stack)
            simplifiedPath+=str;                    
        return (simplifiedPath.length()!=0)?("/"+simplifiedPath.substring(0, simplifiedPath.length()-1)):("/"+simplifiedPath);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter path value : ");
            String path=sc.next();
            System.out.println(new SimplifyPath().simplifyPath(path));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
