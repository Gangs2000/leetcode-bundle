package StreamDemo;

public class Student {

    private String stdName;
    private int stdAge;
    private double feeAmount;

    public Student() {
    }

    public Student(String stdName, int stdAge, double feeAmount) {
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.feeAmount = feeAmount;
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

    public double getFeeAmount() {
        return this.feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Student stdName(String stdName) {
        setStdName(stdName);
        return this;
    }

    public Student stdAge(int stdAge) {
        setStdAge(stdAge);
        return this;
    }

    public Student feeAmount(double feeAmount) {
        setFeeAmount(feeAmount);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " stdName='" + getStdName() + "'" +
                ", stdAge='" + getStdAge() + "'" +
                ", feeAmount='" + getFeeAmount() + "'" +
                "}";
    }
}
