import java.util.Scanner;
import java.util.function.BiFunction;

class CheckIfWordOccursPrefixAnyWordinaSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = 1;
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (word.length() >= searchWord.length() && word.substring(0, searchWord.length()).equals(searchWord))
                return index;
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter Sentence and Search word : ");
            String sentence = sc.useDelimiter("\n").nextLine();
            String searchWord = sc.useDelimiter("\n").nextLine();
            BiFunction<String, String, Integer> bFunction = (input1,
                    input2) -> new CheckIfWordOccursPrefixAnyWordinaSentence().isPrefixOfWord(input1, input2);
            System.out.println(bFunction.apply(sentence, searchWord));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}