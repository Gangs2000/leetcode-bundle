import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordLadder {
    int depth=0,lsize=1;
    List<String> list=new LinkedList<>();
    private int findMinimumTransformation(String beginWord,String endWord,List<String> wordList){
        list.add(beginWord);
        if(!wordList.contains(endWord))
            return depth;
        else{
            boolean flag=false;
            while(true){
                for(int i=0;i<list.get(0).length();i++){
                    StringBuilder word=new StringBuilder(list.get(0));
                    for(char lowercase='a';lowercase<='z';lowercase++){
                        word.setCharAt(i, lowercase);
                        if(word.length()==1 && !new String(word).equals(endWord) && !list.get(0).equals(new String(word))){
                            depth++;
                            list.add(new String(word));
                            wordList.remove(new String(word));
                        }
                        else if(new String(word).equals(endWord)){
                            list.add(new String(word));
                            if(!(word.length()==1))
                                depth++;
                            flag=true;
                            break;
                        }
                        else if(wordList.contains(new String(word)) && !list.get(0).equals(new String(word))){
                            list.add(new String(word));
                            wordList.remove(new String(word));
                        }
                    }
                }
                if(flag)
                    break;
                if(list.size()==1 && list.size()==lsize){
                    depth=-1;
                    break;
                }
                lsize--; list.remove(0);
                if(lsize==0){
                    depth++;
                    lsize=list.size();
                }
            }
            return depth+1;
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
            System.out.println(new WordLadder().findMinimumTransformation(beginWord,endWord,wordList));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
