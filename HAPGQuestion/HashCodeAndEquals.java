package HAPGQuestion;

import java.util.HashSet;
import java.util.Set;

import HAPGQuestion.POJO.Employee;

public class HashCodeAndEquals {
    public static void main(String[] args){
        Set<Employee> set=new HashSet<>();
        try{
            set.add(new Employee(1, "Gangeswaran", "JAVA", 42000));
            set.add(new Employee(2, "Manoj", "UI Designer", 48000));
            set.add(new Employee(3, "Nandhakumar", "VFX Designer", 50000));
            set.add(new Employee(1, "Gangeswaran", "JAVA", 42000));
            System.out.println(set);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
