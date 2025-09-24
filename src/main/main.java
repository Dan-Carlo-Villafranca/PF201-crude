
package main;

import config.config;
import java.util.Scanner;

public class main {
    
    private static void viewUsers() {
        String votersQuery = "SELECT * FROM tbl_residents";
        String[] votersHeaders = {"ID", "Name", "Age", "Gender", "Address", "Contact"};
        String[] votersColumns = {"r_id", "r_name", "r_age", "r_gender", "r_address", "r_contact"};
        
        config conf = new config();
        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        int choice, action;
        
        System.out.println("Vaccination Records");
        System.out.println("1. Users");
        System.out.println("2. Vaccines");
        System.out.println("3. Records");
        System.out.print("Enter Choice: ");
        choice = sc.nextInt();
        sc.nextLine();
        
        switch (choice) {
            case 1:
                System.out.println("USERS");
                System.out.println("1. Add Information");
                System.out.println("2. View Information");
                System.out.println("3. Update Information");
                System.out.println("4. Delete Information");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");
                action = sc.nextInt();
                sc.nextLine();
        
                switch (action) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        String age = sc.nextLine();
                        System.out.print("Enter gender(M/F): ");
                        String gender = sc.nextLine();
                        System.out.print("Enter address: ");
                        String address = sc.nextLine();
                        System.out.print("Enter contact: ");
                        String contact = sc.nextLine();
                        
                        String sql = "INSERT INTO tbl_residents (r_name, r_age, r_gender, r_address, r_contact) VALUES (?, ?, ?, ?, ?)";
                        conf.addRecord(sql, name, age, gender, address, contact);
                        break;
                    case 2:
                        //view users nga function
                        viewUsers();
                        break; 
                    
                    case 3:
                        //update nga function
                        viewUsers();
                        System.out.print("Enter id to update: ");
                        int id = sc.nextInt();
                        
                        System.out.print("Enter new name: ");
                        name = sc.next();
                        
                        System.out.print("Enter new age: ");
                        age = sc.next();
                        
                        System.out.print("Enter new gender: ");
                        gender = sc.next();
                        
                        System.out.print("Enter new address: ");
                        address = sc.next();
                        
                        System.out.print("Enter new contact: ");
                        contact = sc.next();

                        
                        sql = "UPDATE tbl_residents SET r_name = ?, r_age = ?, r_gender = ?, r_address = ?, r_contact = ? WHERE r_id = ?";
                        conf.updateRecord(sql, name, age, gender, address, contact, id);
                        break;
            
                    case 4:
                        //Delete information
                        config dbConfig = new config();
                        System.out.print("Enter Information ID to delete: ");
                        id = sc.nextInt();
                        
                        String sqlDelete = "DELETE FROM tbl_residents WHERE r_id = ?";
                        dbConfig.deleteRecord(sqlDelete, id);
                        
                        break;
                        
                    case 5:
                        //Exit
                        System.out.println("Exiting Program.");
                        break;
                    default:
                System.out.println("Invalid option. Please try again.");
        }
                break;
    }
}
}