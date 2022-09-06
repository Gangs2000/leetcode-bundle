package Javaeight;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails {

    public static void main(String[] aa) {
        ArrayList<Integer> listData = new ArrayList<Integer>();

        Predicate<Integer> positiveData = i -> i > 0;

        listData.add(1);
        listData.add(10);
        listData.add(101);
        listData.add(200);
        listData.add(-10);
        listData.add(0);

        List<Integer> finalOutput = filterList(listData, positiveData);

        finalOutput.forEach(System.out::println);

    }

    public static List<Integer> filterList(List<Integer> listData, Predicate<Integer> predicate) {
        ArrayList<Integer> filterListData = new ArrayList<Integer>();

        for (Integer mydata : listData) {
            if (predicate.test(mydata)) {
                filterListData.add(mydata);
            }
        }
        return filterListData;
    }
}