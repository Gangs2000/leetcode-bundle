package HAPGQuestion.POJO;

public class Employee implements Comparable<Employee>{
    private int empId;
    private String empname;
    private String department;
    private double salary;
    public Employee(int empId, String empname, String department, double salary) {
        this.empId = empId;
        this.empname = empname;
        this.department = department;
        this.salary = salary;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + empId;
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (empId != other.empId)
            return false;
        return true;
    }
    @Override
    public int compareTo(Employee object) {
        return (this.getSalary()<object.getSalary())?(-1):(1);
    }
    @Override
    public String toString() {
        return "Employee [department=" + department + ", empId=" + empId + ", empname=" + empname + ", salary=" + salary
                + "]";
    }
}
