package banking;

public class driver {
    public static void main(String[] args){
        Bank bank1 = new Bank("moneytime");
        Customer customer1 = new Customer("Bob", "Ross");
        Account account1 = new Account(100);

        bank1.addCustomer("Joko", "Oui");
        bank1.addCustomer("pepe", "ga");
        System.out.println(bank1.toString());
        bank1.printCustomers();

        customer1.setAccount(account1);
        customer1.getAccount().deposit(50);

        System.out.println(customer1.getAccount().toString());
        System.out.println(customer1.toString());


    }
}
