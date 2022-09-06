package HAPGQuestion;

import java.util.List;
import java.util.stream.Collectors;

public class ListAsSet {
    public static void main(String[] args){
        List<String> list=List.of("Ganges","Waran","Nandhakumar","Ganges","Yogesh","Waran");
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }
}
