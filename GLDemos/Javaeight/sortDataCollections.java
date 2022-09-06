package Javaeight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sortDataCollections {
    public static void main(String[] aa) {

        ArrayList<String> empName1 = new ArrayList<String>();

        empName1.add("Tim");
        empName1.add("Rim");
        empName1.add("Xim");
        empName1.add("Kim");
        empName1.add("Jim");

        System.out.println("Before Sorting Employee Names");
        System.out.println(empName1);

        sortDataCollections strObj = new sortDataCollections();

        strObj.sortempName(empName1);

        System.out.println("After Sorting Employee Names");
        System.out.println(empName1);

    }

    public void sortempName(ArrayList<String> empName) {

        Collections.sort(empName, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }

        });
    }
}
