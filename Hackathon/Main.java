import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import POJO.*;
public class Main {
    /*Code done by Gangeswaran B B*/

    public static void listOfAccounts(List<Accounts> list){
        System.out.println("List of account details..");
        for(Accounts obj : list){
            System.out.print(obj.getAccountNo()+" - "+obj.getHolderName()+" - "+obj.getAge()+" - "+obj.getAccountType()+" - "+obj.getMobileNo()+" - "+obj.getIntrestRate());
            System.out.println();
        }
    }

    public static void highestNetworth(List<Accounts> list){
        System.out.println("2 Highest net worth account holder with their account balance..");
        List<Accounts> highest=list.stream().sorted(Comparator.comparing(Accounts::getAccountBalance).reversed()).limit(2).collect(Collectors.toList());
        highest.forEach(object->{
            System.out.print(object.getAccountNo()+" "+object.getHolderName()+" "+object.getAge()+" "+object.getAccountType()+" "+object.getMobileNo()+" "+object.getIntrestRate()+" "+object.getAccountBalance());
            System.out.println();
        });
    }

    public static void fetchAccountDetailsBasedOnAccountType(String accountType, List<Accounts> list){
        System.out.println("Filter based on account type..");
        list.stream().filter(object->(object.getAccountType().toLowerCase().equals(accountType))).forEach(accountDetails->{
            System.out.print(accountDetails.getAccountNo()+" "+accountDetails.getHolderName()+" "+accountDetails.getAge()+" "+accountDetails.getAccountType()+" "+accountDetails.getMobileNo()+" "+accountDetails.getIntrestRate()+" "+accountDetails.getAccountBalance());
            System.out.println();
        });
    }

    public static void showMinimumBalance(long balance,List<Accounts> list){
        System.out.println("Filter based on minimum account balance..");
        List<Accounts> minAccountHolder=list.stream().filter(object->object.getAccountBalance()<balance).collect(Collectors.toList());
        minAccountHolder.forEach(object->{
            System.out.print(object.getAccountNo()+" "+object.getHolderName()+" "+object.getAge()+" "+object.getAccountType()+" "+object.getMobileNo()+" "+object.getIntrestRate()+" "+object.getAccountBalance());
            System.out.println();
        });
    }

    public static void totalDepositAmount(List<Accounts> list){
        long depositBalance=list.stream().mapToLong(Accounts::getAccountBalance).sum();
        System.out.println("Total deposit amount from all account : "+depositBalance);
    }

    public static void main(String[] args){
        Scanner sc;
        List<Accounts> list;
        try{
            sc=new Scanner(System.in);
            list=new ArrayList<Accounts>();
            list.add(new Accounts(101,"Gangeswaran B B", "Savings account",22,"8870715249", 4000));
            list.add(new Accounts(102,"Nisha B B", "Cumulative deposit",20,"7867453412", 10000));
            list.add(new Accounts(103,"Nandhu K V", "Fixed deposit",21,"8978564534", 2000));
            list.add(new Accounts(104,"Banu K N", "Fixed deposit",62,"8978675634", 5000));

            Main.listOfAccounts(list); //Print the list of all account numbers, names and contact no of account holders and balance.
            System.out.println();
            
            Main.highestNetworth(list); //Details of 2 Highest net worth account holder with their account balance
            System.out.println();

            System.out.println("Enter account type to fetch details : ");
            String type=sc.nextLine().toLowerCase();
            Main.fetchAccountDetailsBasedOnAccountType(type,list); //Using Streams, filter the customers based on account types and print their Account  number, name and  balances.
            System.out.println();

            Main.showMinimumBalance(5000,list); //Show members with account balances below minimum balance, minimum account balance is INR 5000
            System.out.println();

            Main.totalDepositAmount(list); //Total amount in the deposits
            System.out.println();
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
