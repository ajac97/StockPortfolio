import java.util.Arrays;

public class StockPortfolio {
    private String name;
    static int accounts;
    private int[] amounts = new int[100];
    private String[] companies = new String[100];
    private int counter = 0;

    public StockPortfolio(String name) {
        this.name = name;
        accounts++;
        for (int i = 0; i < companies.length; i++) {
            companies[i] = "";

        }

    }

    public void newPurchases(String name, int amount) {
        for (int i = 0; i < companies.length; i++) {
            if (companies[i].equalsIgnoreCase(name)) {
                amounts[i] += amount;
                return;
            }
        }
        companies[counter] = name;
        amounts[counter] = amount;
        counter++;

    }

    public void sales(String name, int amount) throws Exception {
        for (int i = 0; i < companies.length; i++) {
            if (companies[i].equalsIgnoreCase(name)) {
                if (amounts[i] > amount) {
                    amounts[i] -= amount;
                    return;
                }
            }

        }
        throw new Exception("You don't own any shares of " + name);
    }

    public String toString() {
        String print = "Hello, " + name + "!\n";
        print += "You own the following stocks:\n";
        for (int i = 0; i < companies.length; i++) {
            if (amounts[i] > 0) {
                print += companies[i] + ": " + amounts[i] + " Shares\n";
            }
        }
        return print;
    }

    public static void main(String[] args) throws Exception {
        StockPortfolio account = new StockPortfolio("Akiva");
        account.newPurchases("Netflix", 6);
        account.newPurchases("Google", 12);
        account.sales("google", 3);
        System.out.println(account);
    }
}