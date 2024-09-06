package Views;

// import java.sql.SQLException;
import java.util.ArrayList;

import Controllers.AdminController;
import Controllers.CharrityController;
// import Models.userDAO;
import Resources.Charity_DetailDTO;
import Resources.UserDTO;
import Util.Input;

public class Admin extends Input {
    

    public static void start() {
        while (true) {
            try {
                System.out.println("Welcome admin");
                System.out.println("*".repeat(120));

                System.out.println("1.add Charity");
                System.out.println("2.Remove Charity");
                System.out.println("3.view Charity");
                System.out.println("4.add Admin");
                System.out.println("5.Remove Admin");
                System.out.println("6.Exit");
                System.out.println("*".repeat(120));

                int select = sc.nextInt();
                sc.nextLine();
                if (select == 1) {
                    System.out.println("Enter your name: ");
                    String charity_head = sc.nextLine();
                    System.out.println("Enter your email id: ");
                    String email = sc.nextLine();
                    System.out.println("Enter your password: ");
                    String password = sc.nextLine();
                    System.out.println("Enter your charity name");
                    String charity_name = sc.nextLine();
                    System.out.println("Enter your district");
                    String district = sc.nextLine();
                    System.out.println("Enter your city");
                    String city = sc.nextLine();
                    System.out.println("Enter your no_of_member");
                    int no_of_member = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your phone_no");
                    String phone_no = sc.nextLine();
                    System.out.println();
                    AdminController.registerCharity(charity_name, district, city, no_of_member, phone_no, charity_head,
                            email, password);
                    System.out.println("Charity Added successfully");               
                    
                } else if (select == 2) {
                    ArrayList<Charity_DetailDTO> ar = CharrityController.getCharityfordeletion();
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "charity ID", "charity name", "charity head",
                    "city", "user id");
                    System.out.println("-".repeat(100));
                    for (Charity_DetailDTO delete : ar) {
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", delete.getCharity_id(),
                        delete.getCharity_name(), delete.getName(), delete.getCity(), delete.getUser_id());
                        
                    }
                    System.out.println();
                    System.out.println("select charity id: ");
                    int charity_id1 = sc.nextInt();
                    System.out.println("select user id: ");
                    int user_id1 = sc.nextInt();
                    AdminController.removeCharity(charity_id1, user_id1);
                    System.out.println("Charity Removed");
                }
                else if(select==3){
                    ArrayList<Charity_DetailDTO> ar = CharrityController.getCharityfordeletion();
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "charity ID", "charity name", "charity head",
                    "city", "user id");
                    System.out.println("-".repeat(100));
                    for (Charity_DetailDTO delete : ar) {
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", delete.getCharity_id(),
                        delete.getCharity_name(), delete.getName(), delete.getCity(), delete.getUser_id());
                        
                    }
                    System.out.println();
                }
                else if (select == 4) {
                    System.out.println("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter your email: ");
                    String email = sc.nextLine();
                    System.out.println("Enter your password: ");
                    String password = sc.nextLine();
                    System.out.println("Enter your phone no: ");
                    String phone_no = sc.nextLine();
                    
                    AdminController.registeradmin(name, email, password, phone_no);
                    System.out.println("Admin Added successfully");               
                } else if (select == 5) {
                    ArrayList<UserDTO> ar = AdminController.removeadmin();
                    System.out.printf("%-20s%-20s\n", "user id", "name");
                    System.out.println("-".repeat(40));
                    for (UserDTO delete : ar) {
                        System.out.printf("%-20s%-20s\n", delete.getUser_id(), delete.getName());
                    }
                    System.out.println();
                    System.out.println("enter the user_id: ");
                    int user_id = sc.nextInt();
                    AdminController.deleteadmin(user_id);
                    System.out.println("Admin Removed");
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
