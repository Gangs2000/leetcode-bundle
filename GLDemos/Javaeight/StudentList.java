package Javaeight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentList {
    public static void main(String[] aa) {

        Function<Student, String> stdNameListFunc = (Student stdObj) -> {
            return stdObj.getStdName();
        };

        ArrayList<Student> stdList = new ArrayList<Student>();

        stdList.add(new Student("Tim", 21));
        stdList.add(new Student("Rim", 19));
        stdList.add(new Student("Kim", 22));
        stdList.add(new Student("Jim", 18));
        stdList.add(new Student("Xim", 23));

        List<String> stdNameList = stdNameListConversion(stdList, stdNameListFunc);

        // stdNameList.forEach(System.out::println);

        // Iterator it = stdNameList.iterator();

        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

    }

    public static List<String> stdNameListConversion(List<Student> stdList, Function<Student, String> stdToStrFunc) {
        ArrayList<String> stdNameList = new ArrayList<String>();

        for (Student stdObj : stdList) {
            stdNameList.add(stdToStrFunc.apply(stdObj));
        }

        return stdNameList;
    }
}
