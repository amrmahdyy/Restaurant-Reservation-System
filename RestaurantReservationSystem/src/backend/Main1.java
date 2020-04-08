package backend;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main1 {
//    public static boolean userNameStatus;
//    private static String role = "";
    public static int  temp=0;
    int temp2;
//
//    public static void main(String[] args) {
//        System.out.println("\uD83C\uDF72 \uD83C\uDF72 \uD83C\uDF72 \uD83C\uDF72 \uD83C\uDF72 \n");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
//        ClientData d1 = new ClientData();
//        int index;
//        Verification user = new Verification();
//        Person p1 = new Person();
//        Customer c1 = new Customer();
//
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter username\n");
//        String userName = input.nextLine();
//        System.out.println("Enter password\n");
//        String password = input.nextLine();
//        for (int j = 0; j < 5; j++) {
//            if ((userName.equals(p1.getuserNameArray(j)) && password.equals(p1.getPasswordArray(j)))) {
//                System.out.println("username and password are correct");
//                userNameStatus = true;
//                role = p1.getRoleArray(j);
//                temp = j;
//
//                //  System.out.println(role);
//                if (userNameStatus == true)
//                    break;
//            }
//
//        }
//        System.out.println(role);
//        switch (role) {
//            case "Client":
//
//                System.out.println("Enter number of seats for your table");
//                int numberOfSeats = input.nextInt();
//                System.out.println("Enter the type of  your table type 'true' for smoking and 'false' for nonSmoking   \n");
//                boolean tof = input.nextBoolean();
//                String typeOfTable = Boolean.toString(tof);
//                c1.checkAvaliability(numberOfSeats, typeOfTable);
//                if (c1.getNoAvaliabiltyStatus().equals("false")) {
//                    c1.printMenu();
//                    System.out.println("Choose a number from the menu\n");
//                    int choice = input.nextInt();
//                    if (choice > 0 && choice < 6) {
//                        c1.printReceipt(choice - 1);
//                    }
//                    System.out.println("Please write 1 to confirm your reservation and write 0 to exit\n");
//                    int confirm = input.nextInt();
//                    String conf = Integer.toString(confirm);
//                    if (conf.equals("1")) {
//                        c1.confirmOrder(confirm - 1);
//                        System.out.println("Reservation confirmed");
//                    }
//                    break;
//                }
//            case "Waiter":
//                Waiter w1 = new Waiter();
//                System.out.println("Welcome To Dashboard write 1 to view Today's reservation");
//                int choice = input.nextInt();
//                if (choice == 1)
//                    w1.printReservationNames();
//                break;
//
//            case "Cooker":
//                Cooker cooker = new Cooker();
//                System.out.println("Welcome To Dashboard write 1 to view Today's Meals \uD83D\uDE0B \uD83D\uDE0B \uD83D\uDE0B \n");
//                choice = input.nextInt();
//                if (choice == 1)
//                    cooker.printMealsAndTables();
//                break;
//
//            case "Manager":
//                Manager manager = new Manager();
//                int choices=10;
//                while (choices != 0) {
//                    System.out.println("Welcome To Dashboard !!\n Write 1 to view Orders\n write 2 to view client Names\n" +
//                            " write 3 to view tables reserved\n write 4 to clear Data \n write 0 to exit");
//                    choices = input.nextInt();
//                    if (choices == 1)
//                        manager.orders();
//                    if (choices == 2)
//                        manager.clientNames();
//                    if (choices == 3)
//                        manager.tablesReserved();
//                    if (choices == 4)
//                        manager.clearClientData();
//                    if(choices==0)
//                        break;
//                }
//        }
//
//    }
//
   public int getTemp2() {
        temp2=temp;
        return temp2;
    }
}
