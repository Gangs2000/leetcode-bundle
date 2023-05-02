package HAPGQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
    
    private String empId;
    private String empName;
    private String sex;
    private String organizationName;
    private float yearOfExp;

    public String getEmpId() {
        return empId;
    }    
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getOrganizationName() {
        return organizationName;
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public float getYearOfExp() {
        return yearOfExp;
    }
    public void setYearOfExp(float yearOfExp) {
        this.yearOfExp = yearOfExp;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Employee employee;
        System.out.println("Enter the number of records to be inserted : ");
        int count=sc.nextInt();
        List<Employee> listOfEmployees=new ArrayList<>();
        for(int i=0;i<count;i++){
            employee=new Employee();
            System.out.println("Enter Employee ID : ");
            employee.setEmpId(sc.useDelimiter("\n").next());
            System.out.println("Enter Employee Name : ");
            employee.setEmpName(sc.useDelimiter("\n").next());
            System.out.println("Enter Sex: ");            
            employee.setSex(sc.useDelimiter("\n").next());
            System.out.println("Enter Organization name : ");
            employee.setOrganizationName(sc.useDelimiter("\n").next());
            System.out.println("Enter year of experience : ");
            employee.setYearOfExp(sc.nextFloat());
            listOfEmployees.add(employee);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Displyaing employee records : ");
        for(Employee empObj : listOfEmployees){
            System.out.println("Employee ID : "+empObj.empId);
            System.out.println("Employee Name : "+empObj.empName);
            System.out.println("Sex : "+empObj.sex);
            System.out.println("Organization : "+empObj.organizationName);
            System.out.println("Year of experience : "+empObj.yearOfExp);
            System.out.println("-------------------------------------------------------");
        }
        sc.close();
    }
}
