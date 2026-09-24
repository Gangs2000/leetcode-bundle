import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

enum Skills {
    JAVA, PYTHON, CPP, RUST, GOLANG,
    AI, ML, RAG, LANGCHAIN
}

record DepartmentSummary(
        long employeeCount,
        double averageAge,
        double totalSalary,
        double maximumExperience,
        Set<Skills> skills) {
}

class Employee {
    long id;
    String name;
    int age;
    double salary;
    String department;
    double experience;
    String managerName;
    List<Skills> skills;

    public Employee(long id, String name, int age, double salary, String department, double experience,
            String managerName,
            List<Skills> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.experience = experience;
        this.managerName = managerName;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee[id = " + id + ", name = " + name + ", age = " + age + ", salary = " + salary
                + ", department = " + department + ", experience = " + experience + ", managerName = " + managerName
                + ", skills = " + skills + "]";
    }
}

public class StreamCollections {

    private void printEmployees(Map<String, List<Employee>> empMap) {
        empMap.entrySet().parallelStream().forEachOrdered(entry -> {
            System.out.println("Departement Name : " + entry.getKey());
            entry.getValue().parallelStream().forEachOrdered(employee -> {
                System.out.println("***********************************");
                System.out.println(employee.toString());
            });
            System.out.println("-----------------------------------------");
        });
    }

    public void practiceArea(List<Employee> employees) {
        // Find the employee with the highest salary.
        Optional<String> employeeWithHighestSalary = employees.stream()
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                .map(employee -> employee.name).findFirst();
        System.out.println("Employee with highest salary: ");
        employeeWithHighestSalary.ifPresent((e) -> System.out.println(e));

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Group employees by department, then sort each department’s employees by
        // experience descending.
        Map<String, List<Employee>> groupDepts = employees.stream().collect(
                Collectors.groupingBy((e) -> e.department, Collectors.collectingAndThen(Collectors.toList(),
                        (list) -> list.stream()
                                .sorted(Comparator.comparingDouble((Employee e) -> e.experience).reversed())
                                .collect(Collectors.toList()))));
        System.out.println("Group employees by department with employees experience sorted in descending order : ");
        this.printEmployees(groupDepts);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Find the department with the highest average salary.
        String deptWithHighAvgSalary = employees.stream()
                .collect(Collectors.groupingBy((Employee e) -> e.department, Collectors.averagingDouble(e -> e.salary)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
                .orElse("Not Department found");
        System.out.println("Department with the highest average salary : " + deptWithHighAvgSalary);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Produce a map of each manager to the total salary of their direct reports.
        Map<String, Double> mapSalaryToManager = employees.stream()
                .collect(Collectors.groupingBy((e) -> e.managerName, Collectors.summingDouble((e) -> e.salary)));
        System.out.println("Manager to the total salary of their direct reports :" + mapSalaryToManager);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // List all distinct skills held by employees, sorted alphabetically by enum
        // name.
        List<Skills> distinctSkills = employees.stream().flatMap((stream) -> stream.skills.stream()).distinct()
                .toList();
        System.out.println("Distinct skills held by employees, sorted alphabetically by enum : " + distinctSkills);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Find employees who have both JAVA and AI, then order them by salary
        // descending and name ascending.
        List<Employee> skilledEmployees = employees.stream()
                .filter((Employee e) -> e.skills.contains(Skills.AI) && e.skills.contains(Skills.JAVA))
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed()
                        .thenComparing(Comparator.comparing((Employee e) -> e.name)))
                .toList();
        System.out.println(
                "Employees who have both JAVA and AI, then order them by salary descending and name ascending : "
                        + skilledEmployees);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Count how many employees possess each skill, returning a Map<Skills, Long>.
        Map<Skills, Long> skillCount = employees.stream().flatMap((stream) -> stream.skills.stream())
                .collect(Collectors.groupingBy((skill) -> skill, Collectors.counting()));
        System.out.println("How many employees possess each skill, returning a Map<Skills, Long> : " + skillCount);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Identify the skill or skills held by the greatest number of employees. Handle
        // ties.
        long mostCount = skillCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        List<Skills> mostOccurredSkills = skillCount.entrySet().stream()
                .filter((entry) -> entry.getValue() == mostCount).map(Map.Entry::getKey).toList();
        System.out.println(
                "Identify the skill or skills held by the greatest number of employees : " + mostOccurredSkills);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Create a map from department to its most experienced employee. Decide how to
        // resolve equal experience.
        Map<String, Optional<Employee>> mostExpFromDept = employees.stream()
                .collect(Collectors.groupingBy((Employee e) -> e.department,
                        Collectors.maxBy(Comparator.comparingDouble((Employee e) -> e.experience)
                                .thenComparing(Comparator.comparing((Employee e) -> e.id)))));
        System.out.println("Department to its most experienced employee. Decide how to resolve equal experience : "
                + mostExpFromDept);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Partition employees into two groups: those paid above their department’s
        // average salary and everyone else.
        Map<String, Double> deptAvg = employees.stream()
                .collect(Collectors.groupingBy((Employee e) -> e.department,
                        Collectors.averagingDouble((Employee e) -> e.salary)));
        Map<String, Map<Boolean, List<Employee>>> salarySegMap = employees.stream().collect(Collectors.groupingBy(
                employee -> employee.department, Collectors.partitioningBy(e -> deptAvg.get(e.department) < e.salary)));

        System.out.println(
                "Partition employees into two groups: those paid above their department’s average salary and everyone else."
                        + salarySegMap + " " + deptAvg);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Find managers whose direct reports belong to at least two different
        // departments.
        List<String> managerFromDiffDepts = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.managerName,
                        Collectors.mapping((Employee e) -> e.department, Collectors.toSet())))
                .entrySet()
                .stream().filter((entry) -> entry.getValue().size() > 1).map(Map.Entry::getKey).toList();
        System.out.println("Find managers whose direct reports belong to at least two different departments : "
                + managerFromDiffDepts);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Build a nested grouping: department → manager → list of employee names.
        Map<String, Map<String, List<String>>> deptToManagerToEmployees = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.department,
                        Collectors.groupingBy((employee) -> employee.managerName,
                                Collectors.mapping(employee -> employee.name, Collectors.toList()))));
        System.out.println(
                "Build a nested grouping: department → manager → list of employee names : " + deptToManagerToEmployees);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Calculate the total salary cost for every distinct combination of skills. For
        // example, employees with [JAVA, AI] should be grouped separately from [AI,
        // JAVA] if order is considered significant; then repeat treating order as
        // insignificant.
        Map<List<Skills>, Double> totalSalFromDistinctSkills = employees.stream().collect(Collectors
                .groupingBy(employee -> employee.skills, Collectors.summingDouble(employee -> employee.salary)));
        System.out.println(
                "Calculate the total salary cost for every distinct combination of skills. For example, employees with [JAVA, AI] should be grouped separately from [AI, JAVA] if order is considered significant; then repeat treating order as insignificant. : "
                        + totalSalFromDistinctSkills);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Find employees whose skill set is unique: no other employee has exactly the
        // same set of skills.
        List<String> employeeWithUniqueSkillSets = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.skills))
                .values().stream().filter(list -> list.size() == 1).map((list) -> list.get(0).name).toList();
        System.out.println(
                "Find employees whose skill set is unique: no other employee has exactly the same set of skills. : "
                        + employeeWithUniqueSkillSets);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Return the top two highest-paid employees per department, preserving
        // salary-descending order within each department.
        Map<String, List<Employee>> topPaidPerDept = employees.stream().collect(Collectors
                .groupingBy(employee -> employee.department, Collectors.collectingAndThen(Collectors.toList(),
                        (list) -> list.stream().sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                                .limit(2).toList())));
        System.out.println(
                "Return the top two highest-paid employees per department, preserving salary-descending order within each department. : "
                        + topPaidPerDept);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Determine whether every department has at least one employee with more than
        // five years of experience.
        Map<String, List<Employee>> deptWithHighExp = employees.stream().collect(Collectors.groupingBy(
                employee -> employee.department,
                Collectors.filtering((employee) -> employee.experience > 5, Collectors.toList())));
        System.out.println(
                "Determine whether every department has at least one employee with more than five years of experience. : "
                        + deptWithHighExp);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Find the pair of employees with the largest age difference, excluding
        // comparisons of an employee with themselves.
        Optional<Map.Entry<Employee, Employee>> largestAgeDifferencePair = employees.stream()
                .flatMap(firstEmployee -> employees.stream()
                        .filter(secondEmployee -> firstEmployee.id < secondEmployee.id)
                        .map(secondEmployee -> Map.entry(firstEmployee, secondEmployee)))
                .max(Comparator.comparingInt(pair -> Math.abs(pair.getKey().age - pair.getValue().age)));
        System.out.println(
                "Find the pair of employees with the largest age difference, excluding comparisons of an employee with themselves. : "
                        + largestAgeDifferencePair);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        // Create a department summary containing employee count, average age, total
        // salary, maximum experience, and the set of all department skills.
        Map<String, DepartmentSummary> deptSummaries = employees.stream().collect(Collectors
                .groupingBy(employee -> employee.department,
                        Collectors.collectingAndThen(Collectors.toList(), (deptEmployees) -> {
                            double aveAge = deptEmployees.stream()
                                    .collect(Collectors.averagingDouble(employee -> employee.age));
                            long empCount = deptEmployees.size();
                            double totalSalary = deptEmployees.stream()
                                    .collect(Collectors.averagingDouble(employee -> employee.salary));
                            double maxExp = deptEmployees.stream()
                                    .max(Comparator.comparingDouble(employee -> employee.experience)).get().experience;
                            Set<Skills> skills = deptEmployees.stream().flatMap((stream) -> stream.skills.stream())
                                    .collect(Collectors.toSet());
                            return new DepartmentSummary(empCount, aveAge, totalSalary, maxExp, skills);
                        })));
        System.out.println("Department summaries : " + deptSummaries);

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            List<Employee> employees = Arrays.asList(
                    new Employee(1, "USER_1", 27, 12.90, "CREDITI", 6.1, "MANAGER_1",
                            Arrays.asList(Skills.JAVA, Skills.AI)),
                    new Employee(2, "USER_2", 34, 10.90, "PAYMENTS", 4.2, "MANAGER_2",
                            Arrays.asList(Skills.PYTHON, Skills.AI, Skills.ML)),
                    new Employee(3, "USER_3", 45, 6.89, "PAYMENTS", 9.9, "MANAGER_1",
                            Arrays.asList(Skills.JAVA, Skills.LANGCHAIN, Skills.PYTHON, Skills.GOLANG)),
                    new Employee(4, "USER_4", 21, 6.78, "CREDITI", 10.0, "MANAGER_3",
                            Arrays.asList(Skills.PYTHON, Skills.JAVA, Skills.AI)),
                    new Employee(5, "USER_5", 54, 21.56, "ANAGRAFE", 18.7, "MANAGER_2",
                            Arrays.asList(Skills.JAVA, Skills.AI, Skills.LANGCHAIN, Skills.RAG)));
            Consumer<List<Employee>> consumer = new StreamCollections()::practiceArea;
            consumer.accept(employees);
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
