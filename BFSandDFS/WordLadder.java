import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordLadder {
    Map<String, Integer> queue;
    List<String> visitedWords;
    int result=0;
    public WordLadder(){
        queue=new LinkedHashMap<>();
        visitedWords=new LinkedList<>();
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord)){
            if(beginWord.equals(endWord))
                return 0;
            else{
                queue.put(beginWord, 1);                    //Adding begin word into queue
                if(wordList.contains(beginWord))
                    wordList.remove(beginWord);             //Delete from list, If begin word exists in wordlist
                while(!queue.isEmpty()){
                    String poll=queue.entrySet().stream().findFirst().get().getKey();
                    int currentDepth=queue.get(poll);
                    this.traverseGraphToFindShorestPath(poll, currentDepth, endWord, wordList);                    
                    queue.remove(poll);
                }
                return result;
            }
        }
        else
            return 0;        
    }
    public void traverseGraphToFindShorestPath(String string, int depth, String endWord, List<String> wordList){        
        if(string.equals(endWord))
            result=depth;
        else{
            for(int i=0;i<wordList.size();i++){     
                String listString=wordList.get(i);       
                if(string.length()==listString.length()){                
                    int letterDifference=0; 
                    for(int letter=0;letter<listString.length();letter++){
                        if(string.charAt(letter)!=listString.charAt(letter))
                            letterDifference++;
                    }
                    if(letterDifference==1 && !visitedWords.contains(listString)){
                        queue.put(listString, depth+1);
                        visitedWords.add(listString);
                    }                       
                }                                
            }            
        }
    }
    public static void main(String[] args){
        Scanner sc;
        String beginWord,endWord;
        List<String> wordList;
        try{
            sc=new Scanner(System.in);
            wordList=new LinkedList<>();
            System.out.println("Enter begin and ending word : ");
            beginWord=sc.next().toLowerCase();
            endWord=sc.next().toLowerCase();
            System.out.println("Enter the length of the word list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                wordList.add(sc.next().toLowerCase());
            System.out.println(new WordLadder().ladderLength(beginWord,endWord,wordList));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
