package HAPGQuestion;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import HAPGQuestion.POJO.Employee;

public class ComparableAndComparator {
    public static void main(String[] args){
        List<Employee> list=new LinkedList<>();
        list.add(new Employee(1, "Gangeswaran", "Java Developer", 42000));
        list.add(new Employee(2, "Manoj", "UI Designer", 48000));
        list.add(new Employee(3, "Nandhakumar", "VFX Designer", 50000));
        list.add(new Employee(4, "Nitesh", "Spring developer", 40000));
        //Sorting using Comparable interface
        System.out.println("Before Sorting : ");
        for(Employee employee : list)
            System.out.println(employee);
        Collections.sort(list);
        System.out.println("After Sorting : ");
        for(Employee employee : list)
            System.out.println(employee);
        
        //Sorting using Comparator interface
        Comparator<Employee> comparator=new Comparator<Employee>() {
            @Override
            public int compare(Employee obj1, Employee obj2) {
                return (obj1.getSalary()>obj2.getSalary())?(-1):(1);
            }
        };
        System.out.println("Before Sorting : ");
        for(Employee employee : list)
            System.out.println(employee);
        Collections.sort(list, comparator);
        System.out.println("After Sorting : ");
        for(Employee employee : list)
            System.out.println(employee);
    }
}
