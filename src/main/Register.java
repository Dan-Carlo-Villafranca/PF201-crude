
package main;

import config.config;
import java.util.Scanner;

public class Register {
    public static void register(){
        config conf = new config();
        Scanner sc = new Scanner(System.in);
        String type = null;
        boolean isLooping = true;
        
        //REGISTRATION FORM
        
        System.out.print("Full name: ");
        String name = sc.nextLine();
        boolean emailExist = true;
        
        // email validation if naay duplicate
        
        String email;
        
        do{
        System.out.print("Enter Email: ");
        email = sc.nextLine();
        
        String validation = "SELECT email FROM tbl_users WHERE email=?"; 
        
        if (!conf.fetchRecords(validation, email).isEmpty()){
            System.out.println("Email is already registered. Please input another.");
            emailExist = true; // loop
        } else {
            emailExist = false; //terminate
        }
        } while (emailExist); // end of validation
        
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
    while (isLooping)   {
        //Type selection para sa user
        System.out.println("1. Admin");
        System.out.println("2. Staff");
        System.out.print("Select Type: ");
        String answer = sc.nextLine();
        
            switch (answer){
                case "1":
                    type = "Admin";
                    isLooping = false;
                    break;
                case "2":
                    type = "Staff";
                    isLooping = false;
                    break;
                default:
                    System.out.println("Invalid Input. Try Again.");
            }
        } 
        String sql = "INSERT INTO tbl_users (name, email, password, status, type) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, name, email, password, "Pending", type);
    }
}
