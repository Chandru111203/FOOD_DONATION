package Views;

import java.util.ArrayList;

import Controllers.CharrityController;
import Controllers.donatorcontroller;
import Resources.Charity_DetailDTO;
import Util.Input;

public class donator extends Input {
    public static void start() {
        while (true) {
            try {
                System.out.println("*".repeat(120));
                
                System.out.println("1.donate amount");
                System.out.println("2.donate food");
                System.out.println("3.Currently food available");
                System.out.println("4.Exit");
                System.out.println("*".repeat(120));
                System.out.println("Enter your choice: ");
                int choose = sc.nextInt();
                sc.nextLine();

                if (choose == 1) {
                    ArrayList<Charity_DetailDTO> arr = CharrityController.getCharity();
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "charity ID", "charity name", "charity head",
                            "city", "phone_no", "total members");
                    System.out.println("-".repeat(120));
                    for (Charity_DetailDTO amount : arr) {
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", amount.getCharity_id(),
                                amount.getCharity_name(), amount.getName(), amount.getCity(), amount.getPhone_no(),
                                amount.getNo_of_members());
                    }
                    System.out.println();
                    System.out.println("Select the charity ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter your phone no: ");
                    String phone_no = sc.nextLine();
                    System.out.println("Enter the amount: ");
                    int amount = sc.nextInt();
                    sc.nextLine();

                    donatorcontroller.adddonation(id, name, phone_no, amount);
                } else if (choose == 2) {
                    ArrayList<Charity_DetailDTO> arr = CharrityController.getCharity();
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "charity ID", "charity name", "charity head",
                            "city", "phone_no", "total memners");
                    System.out.println("-".repeat(120));
                    for (Charity_DetailDTO amount : arr) {
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", amount.getCharity_id(),
                                amount.getCharity_name(), amount.getName(), amount.getCity(), amount.getPhone_no(),
                                amount.getNo_of_members());
                    }
                    System.out.println();
                    System.out.println("Select Charity ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Date(yyyy-mm-dd): ");
                    String Date = sc.nextLine();
                    System.out.println("Select the timing: ");
                    System.out.println("morning/afternoon/night");
                    String session = sc.nextLine();
                    System.out.println("enter your name: ");
                    String name = sc.nextLine();
                    System.out.println("enter your phone no: ");
                    String phone_no = sc.nextLine();
                    System.out.println("enter your location: ");
                    String location = sc.nextLine();
                    System.out.println("food availability: ");
                    int availability = sc.nextInt();
                    donatorcontroller.addfood(id, Date, session, name, phone_no, location, availability);
                } else if (choose == 3) {
                    System.out.println("Enter the Date: ");
                    String Date = sc.nextLine();
                    System.out.println("Select the timing: ");
                    System.out.println("morning/afternoon/night");
                    String session = sc.nextLine();
                    System.out.println("enter your name: ");
                    String name = sc.nextLine();
                    System.out.println("enter your phone no: ");
                    String phone_no = sc.nextLine();
                    System.out.println("enter your location: ");
                    String location = sc.nextLine();
                    System.out.println("food availability: ");
                    int availability = sc.nextInt();

                    donatorcontroller.addfoodrandom(Date, session, name, phone_no, location, availability);
                } else {
                    return;
                }
            } catch (Exception err) {
                System.out.println("database error");
                System.out.println(err.getMessage());
            }
        }
    }
}
