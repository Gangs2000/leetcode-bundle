package Javaeight;

public class Student {
    private String stdName;
    private int stdAge;

    public Student() {
    }

    public Student(String stdName, int stdAge) {
        this.stdName = stdName;
        this.stdAge = stdAge;
    }

    public String getStdName() {
        return this.stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return this.stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }
}
