package banking;

import java.util.Arrays;

public class Bank {

    private Customer[] customers = new Customer[1];
    private int numberOfCustomers = this.customers.length;
    private String bankName;

    public Bank(String bName) {
        this.bankName = bName;
    }

    public void addCustomer(String f, String l){
        Customer customer = new Customer(f, l);
        this.customers = Arrays.copyOf(this.customers, this.customers.length + 1);
        this.customers[this.customers.length-1] = customer;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index){
        return customers[index+1];
    }

    public void printCustomers() {
        System.out.println("\ncustomers= ");
        for (int i=1; i<=this.numberOfCustomers; i++) {
            System.out.println(this.customers[i].getFirstName() + " " + this.customers[i].getLastName() + ",");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "\nbank name='" + bankName + '\'' +
                "\nnumber of customers=" + numberOfCustomers +
                "\n}";
    }
}
