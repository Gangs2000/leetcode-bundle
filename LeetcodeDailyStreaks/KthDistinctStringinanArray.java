import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class KthDistinctStringinanArray {
    Map<String, Integer> freqMapper;

    public KthDistinctStringinanArray() {
        freqMapper=new LinkedHashMap<>();
    }

    public String kthDistinct(String[] arr, int k) {
        Consumer<String[]> consumer = (stringArr) -> this.putNumsIntoList(stringArr);
        consumer.accept(arr);
        return this.getKthDistrinctString(freqMapper, k);
    }

    private String getKthDistrinctString(Map<String, Integer> mapper, int k){
        for(Map.Entry<String, Integer> entry : mapper.entrySet()){
            if(entry.getValue()==1){
                if(k==1)
                    return entry.getKey();
                k--;
            }
        }
        return "";
    }

    private void putNumsIntoList(String[] arr) {
        for (String character : arr) {
            freqMapper.putIfAbsent(character, 0);
            freqMapper.put(character, freqMapper.get(character)+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        String[] arr;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of arr : ");
            int length = sc.nextInt();
            arr = new String[length];
            for (int i = 0; i < length; i++)
                arr[i] = sc.useDelimiter("\n").nextLine();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<String[], Integer, String> biFunction = (stringArr, inputK) -> new KthDistinctStringinanArray()
                    .kthDistinct(stringArr, inputK);
            System.out.println(biFunction.apply(arr, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
