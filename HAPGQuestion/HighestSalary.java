package HAPGQuestion;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import HAPGQuestion.POJO.Employee;

public class HighestSalary {
    public static void main(String[] args){
        List<Employee> list=new LinkedList<>();
        Map<String,Double> map=new LinkedHashMap<>();
        list.add(new Employee(1,"Gangeswaran", "Java", 15000));
        list.add(new Employee(2,"Sameer", "Java", 25000));
        list.add(new Employee(3,"Nandhakumar", "VFX designer", 65000));
        list.add(new Employee(4,"Utsave","Accountant", 45000));
        list.add(new Employee(5,"Yogeshwaran","Accountant", 56000));
        list.stream().forEach(object->{
            if(!map.containsKey(object.getDepartment()))
                map.put(object.getDepartment(), object.getSalary());
            else{
                if((double) map.get(object.getDepartment())<object.getSalary())
                    map.put(object.getDepartment(), object.getSalary());
            }
        });
        System.out.println("Highest Salary from each department : "+map);
    }
}