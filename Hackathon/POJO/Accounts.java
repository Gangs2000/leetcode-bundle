package POJO;

public class Accounts {
    long accountNo;
    String holderName;
    String accountType;
    int age;
    double intrestRate;
    String mobileNo;
    long accountBalance;
    public Accounts(long accountNo, String holderName, String accountType, int age, String mobileNo,long accountBalance) {
        this.accountNo = accountNo;
        this.holderName = holderName;
        this.accountType=accountType;
        if(accountType.equals("Savings account"))
            this.intrestRate=3.5;
        else if(accountType.equals("Cumulative deposit"))
            this.intrestRate=4.0;
        else if(accountType.equals("Fixed deposit"))
            this.intrestRate=4.6;
        this.age = age;
        this.mobileNo = mobileNo;
        this.accountBalance = accountBalance;
    }
    public long getAccountNo() {
        return accountNo;
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public String getAccountType() {
        return accountType;
    }
   
    public int getAge() {
        return age;
    }
   
    public double getIntrestRate() {
        return intrestRate;
    }
    
    public String getMobileNo() {
        return mobileNo;
    }
    
    public long getAccountBalance() {
        return accountBalance;
    }
}
