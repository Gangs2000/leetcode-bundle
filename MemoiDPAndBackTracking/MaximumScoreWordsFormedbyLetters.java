import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumScoreWordsFormedbyLetters {
    int maxScoreFormedByLetters=0;
    Map<Character, Integer> lettersFrequencyMapper;
    public MaximumScoreWordsFormedbyLetters(){
        lettersFrequencyMapper=new HashMap<>();
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        //Find frequency of all letters
        this.findFrequencyOfAllLetters(letters);
        this.backTracking(0, words, new HashMap<>(), lettersFrequencyMapper, score);
        return maxScoreFormedByLetters;
    }
    private void findFrequencyOfAllLetters(char[] letters){
        for(int i=0;i<letters.length;i++){
            lettersFrequencyMapper.putIfAbsent(letters[i], 0);
            lettersFrequencyMapper.put(letters[i], lettersFrequencyMapper.get(letters[i])+1);
        }
    }
    private void backTracking(int index, String[] words, Map<Character, Integer> frequencyMapper, Map<Character, Integer> lettersMap, int[] score){
        if(index==words.length){
            maxScoreFormedByLetters=Math.max(maxScoreFormedByLetters, this.findScoreIfWordsCombinedIsValid(frequencyMapper, lettersMap, score));
            return ; 
        }
        String currentWord=words[index];
        //Find frequency of current word and keep it in frequencyMapper
        for(int i=0;i<currentWord.length();i++){
            frequencyMapper.putIfAbsent(currentWord.charAt(i), 0);
            frequencyMapper.put(currentWord.charAt(i), frequencyMapper.get(currentWord.charAt(i))+1);
        }
        this.backTracking(index+1, words, frequencyMapper, lettersMap, score);
        //Remove frequency of current word since we need to figure combinations
        for(int i=0;i<currentWord.length();i++){
            if(frequencyMapper.get(currentWord.charAt(i))==1)
                frequencyMapper.remove(currentWord.charAt(i));
            else
                frequencyMapper.put(currentWord.charAt(i), frequencyMapper.get(currentWord.charAt(i))-1);
        }
        this.backTracking(index+1, words, frequencyMapper, lettersMap, score);
    }
    private int findScoreIfWordsCombinedIsValid(Map<Character, Integer> freqMap, Map<Character, Integer> lettersMap, int[] score){
        int totalScore=0;
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            char character=(char) entry.getKey();
            if(lettersMap.containsKey(character)){
                if(freqMap.get(character)<=lettersMap.get(character))
                    totalScore+=score[(byte) character-97]*freqMap.get(character);
                else
                    return 0;
            }
            else
                return 0;
        }
        return totalScore;
    }
    public static void main(String[] args) {
        Scanner sc;
        String[] words;
        char[] letters;
        int[] score;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of words array : ");
            int wordArrLength=sc.nextInt();
            words=new String[wordArrLength];
            for(int i=0;i<wordArrLength;i++)
                words[i]=sc.useDelimiter("\n").next();
            System.out.println("Enter length of letters array : ");
            int letterArrLength=sc.nextInt();
            letters=new char[letterArrLength];
            for(int i=0;i<letterArrLength;i++)
                letters[i]=sc.next().charAt(0);
            System.out.println("Enter length of score array : ");
            int scoreArrLength=sc.nextInt();
            score=new int[scoreArrLength];
            for(int i=0;i<scoreArrLength;i++)
                score[i]=sc.nextInt();
            System.out.println(new MaximumScoreWordsFormedbyLetters().maxScoreWords(words, letters, score));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
