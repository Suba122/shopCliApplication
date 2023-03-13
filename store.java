import Database.Database;
import java.util.Scanner;

public class store {

    static String storeName;
    float openingBalance;
    void store_opening(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the shop name: ");
        storeName = sc.nextLine().replace(" ", "_");
        System.out.println(storeName);
        System.out.print("Enter the opening Balance: ");
        openingBalance = sc.nextInt();

        Database.databaseCreation(storeName);
        Database.createTables();
    }
    public static void main(String[] args) {
        store store = new store();
        store.store_opening();


    }
}