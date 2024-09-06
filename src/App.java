import java.sql.SQLException;
import java.util.InputMismatchException;

import Controllers.Users;
import Models.Connect;
import Util.Input;
import Views.Admin;
import Views.Charity;
import Views.donator;

public class App extends Input {
    public static void main(String[] args) {
        try {
            Connect.getConnection();
            System.out.println("database connected");
        } catch (SQLException err) {
            System.out.println(err);
            System.out.println("database not connected");
        }

        while (true) {
            try {
                System.out.println("1.Login");
                System.out.println("2.Donate Now");
                System.out.println("3.Exit");
                System.out.println("Enter Your Choice");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Enter your Email :");
                    String email = sc.nextLine();
                    System.out.println("Enter your Password :");
                    String password = sc.nextLine();
                    System.out.println();
                    int check = Users.login(email, password);
                    if (check == 1) {
                        Admin.start();
                    }
                    else if(check==2){
                        Charity.start();
                    }
                } 
                else if (choice == 2) {
                  donator.start();
                }
                else{
                    return; 
                }


            } catch (SQLException err) {
                System.out.println("Database Error");
                System.out.println(err);
            } catch (InputMismatchException err) {
                System.out.println("Invalid Input");

            } catch (Exception err) {
                System.out.println(err.getMessage());

            }
        }

    }
}
