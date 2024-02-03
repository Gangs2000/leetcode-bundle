import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlphabetBoardPath {
    Map<Integer, String> board;
    List<Integer> initialPosition;
    StringBuilder result;
    public AlphabetBoardPath(){
        board=new LinkedHashMap<>();
        initialPosition=List.of(0,0);
        result=new StringBuilder();
        board.put(0, "abcde");
        board.put(1, "fghij");
        board.put(2, "klmno");
        board.put(3, "pqrst");
        board.put(4, "uvwxy");
        board.put(5, "z");
    }
    public String alphabetBoardPath(String target) {
        for(int i=0;i<target.length();i++){
            if(i!=0 && target.charAt(i)!=target.charAt(i-1))                
                template(target, i);
            else if(i!=0 && target.charAt(i)==target.charAt(i-1))
                result.append('!');
            else if(i==0)                
                template(target, i);
        }
        //Test
        return result.toString();        
    }
    public void template(String target, int index){
        List<Integer> getCurrentCharPosition=getPositionFromBoard(String.valueOf(target.charAt(index)));                    
        char character;
        boolean flag=false;
        //Up Or Down    
        int upOrDown=initialPosition.get(0)-getCurrentCharPosition.get(0);   
        int leftOrRight=initialPosition.get(1)-getCurrentCharPosition.get(1);         
        if(upOrDown<0 && leftOrRight>0){
            flag=true;
            appendCharsToResult(Math.abs(upOrDown)-1, 'D');
        }   
        else{
            character=(upOrDown<=0)?('D'):('U');
            appendCharsToResult(Math.abs(upOrDown), character);
        }                   
        //Left Or Right            
        character=(leftOrRight<=0)?('R'):('L');                                          
        appendCharsToResult(Math.abs(leftOrRight), character);
        if(flag)
            result.append('D');
        result.append('!');            
        initialPosition=getCurrentCharPosition; 
    }
    public void appendCharsToResult(int noOfTimes, char c){
        for(int i=1;i<=noOfTimes;i++)
            result.append(c);        
    }
    public List<Integer> getPositionFromBoard(String currentChar){
        int count=0;
        for(Map.Entry<Integer, String> entry : board.entrySet()){
            if(entry.getValue().contains(currentChar))
                break;
            count++;
        }        
        //Test
        return List.of(count, board.get(count).indexOf(currentChar));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Target value : ");
            String target=sc.next();
            System.out.println(new AlphabetBoardPath().alphabetBoardPath(target));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
