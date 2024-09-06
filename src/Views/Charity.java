package Views;

// import  java.sql.SQLException;
import java.util.ArrayList;

import Controllers.CharrityController;
import Controllers.donatorcontroller;
import Resources.DonatorDTO;
import Resources.Food_TransactionDTO;
import Util.Cookie;
import Util.Input;

public class Charity extends Input {
    public static void start() {
        while (true) {
            try {
                System.out.println("Welcome");
                System.out.println("*".repeat(120));

                System.out.println("1.See the Request");
                System.out.println("2.Search for donation");
                System.out.println("3.Donation received");
                System.out.println("4.Update No_of_members");
                System.out.println("5.Update Location");
                System.out.println("6.Exit");
                System.out.println("*".repeat(120));

                int choose = sc.nextInt();
                sc.nextLine();
                System.out.println();
                if (choose == 1) {
                    int count=0;
                    int printcount=0;
                    int user_id = Cookie.getUser().getUserId();
                    ArrayList<Food_TransactionDTO> arr = CharrityController.getbyid(user_id);
                   
                    for (Food_TransactionDTO food : arr) {
                        if(printcount==0){
                            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "transaction id", "location",
                            "food availability", "date", "secssion", "food donator");
                            System.out.println("-".repeat(120));
                            printcount=1;
                        }
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", food.getTransacton_id(),
                                food.getLocation(), food.getFood_availability(), food.getDate(), food.getSession(),
                                food.getFoodDonator());
                                count=1;
                    }
                    System.out.println();
                    if(count==0){
                        System.out.println("x".repeat(52)+"No request found"+"x".repeat(52));
                        continue;
                    }
                    
                    System.out.println("1.Accept the request");
                    System.out.println("2.Back home");
                    System.out.println();
                    int sel=sc.nextInt();
                    sc.nextLine();
                    if(sel==1){
                        System.out.print("Enter tansaction id: ");
                        int id=sc.nextInt();
                        CharrityController.acceptrequest(id,user_id);
                    }
                    else{
                        continue;
                    }
                    System.out.println();
                    count=0;
                    printcount=0;

                } else if (choose == 2) {
                    int count=0;
                    int printcount=0;
                    System.out.println("Enetr the location: ");
                    String location = sc.nextLine();
                    ArrayList<Food_TransactionDTO> arr = CharrityController.getByLocation(location);
                    for (Food_TransactionDTO food : arr) {
                        if(printcount==0){
                            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "transaction id", "location",
                                    "food availability", "date", "secssion", "food donator");
                            System.out.println("-".repeat(120));
                            printcount=1;
                        }
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", food.getTransacton_id(),
                                food.getLocation(), food.getFood_availability(), food.getDate(), food.getSession(),
                                food.getFoodDonator());
                                count=1;
                    }
                    System.out.println();
                    if(count==0){
                        System.out.println("x".repeat(51)+"No food available "+"x".repeat(51));
                        continue;
                    }
                    System.out.println("1.Select the Donation");
                    System.out.println("2.Back home");
                    System.out.println();
                    int sel=sc.nextInt();
                    sc.nextLine();
                    if(sel==1){
                        System.out.print("Enter tansaction id: ");
                        int id = sc.nextInt();
                        int user_id = Cookie.getUser().getUserId();
                        CharrityController.acceptdonation(id, user_id);
                    }
                    else{
                        continue;
                    }
                    count=0;
                    printcount=0;
                    System.out.println();


                } else if (choose == 3) {
                    int printcount=0;
                    int count=0;
                    int id = Cookie.getUser().getUserId();
                    ArrayList<DonatorDTO> arr = donatorcontroller.donationreceived(id);
                    for (DonatorDTO received : arr) {
                        if(printcount==0){
                            System.out.printf("%-20s%-20s\n", "name", "amount");
                            System.out.println("-".repeat(40));
                            printcount=1;
                        }
                        System.out.printf("%-20s%-20s\n", received.getDonator_name(), received.getAmount());
                        count=1;
                    }
                    System.out.println();
                    if(count==0){
                        System.out.println("-".repeat(50)+"No donation received"+"-".repeat(50));
                        
                    }
                    System.out.println();
                    System.out.println("1-back to home");
                    int back=sc.nextInt();
                    if(back==1){
                        continue;
                    }

                } else if (choose == 4) {
                    System.out.println("Enter the updated member size: ");
                    int size = sc.nextInt();
                    int id = Cookie.getUser().getUserId();
                    CharrityController.updatemember(id, size);
                    System.out.println("Update successfully");
                } else if (choose == 5) {
                    System.out.println("Update District Name: ");
                    int id = Cookie.getUser().getUserId();
                    String district = sc.nextLine();
                    System.out.println("Update City Name: ");
                    String city = sc.nextLine();
                    CharrityController.updatelocation(id, district, city);
                    System.out.println("Update successfully");
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
