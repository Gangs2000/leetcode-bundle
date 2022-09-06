package Javaeight;

import java.util.ArrayList;
import java.util.List;

public class acceptUserDetails {

    public static void main(String[] aa) {

        Consumer<String> display = x -> System.out.println(x);

        display.accept("Hello World");

        List<Integer> dataList = new ArrayList<>();
        dataList.add(10);
        dataList.add(20);
        dataList.add(30);

        Consumer<Integer> displayList = (Integer x) -> System.out.println(x);

        fetchData(dataList, displayList);

    }

    public static <T> void fetchData(List<T> lData, Consumer<T> consume) {
        for (T t : lData) {
            consume.accept(t);
        }
    }

}
