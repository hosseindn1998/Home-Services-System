package utility;

import service.Admin.AdminServiceImpl;
import service.Customer.CustomerServiceImpl;
import service.Order.OrderServiceImpl;
import service.Service.ServiceServiceImpl;
import service.SubService.SubServiceServiceImpl;
import service.Technician.TechnicianServiceImpl;
import service.Wallet.WalletServiceImpl;
import service.technician_subservice.TechnicianSubServiceServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final AdminServiceImpl adminService = ApplicationContext.getAdminService();
    private final CustomerServiceImpl customerService = ApplicationContext.getCustomerService();
    private final OrderServiceImpl orderService = ApplicationContext.getOrderService();
    private final ServiceServiceImpl serviceService = ApplicationContext.getServiceService();
    private final SubServiceServiceImpl subServiceService = ApplicationContext.getSubServiceService();
    private final TechnicianServiceImpl technicianService = ApplicationContext.getTechnicianService();
    private final WalletServiceImpl walletService = ApplicationContext.getWalletService();
    private final TechnicianSubServiceServiceImpl technicianSubServiceService = ApplicationContext.getTechnicianSubServiceService();
    private Long loggedInUser;
    public Integer getIntFromUser() {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input must be Only Integer,Try again!");
            }
            scanner.nextLine();
        }
        scanner.nextLine();
        return input;
    }
    public Long getLongFromUser() {
        return (long) getIntFromUser();
    }
    public String getString() {
        String string = scanner.next();
        scanner.nextLine();
        return string;
    }
    public LocalDate getDateFromUser() {
        String input = getString();
        try (Scanner scanner = new Scanner(input)) {
            String dateString = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        }
    }
    public String getFirstName(){
        System.out.println("Please Enter First Name : ");
        return getString();
    }
    public String getLastName(){
        System.out.println("Please Enter Last Name :");
        return getString();
    }
    public String getEmail(){
        System.out.println("Please Enter Email Name :");
        return getString().toLowerCase().trim();
    }

    public String getPassword(){
        System.out.println("Please Enter Choosing Password :");
        return getString();
    }
    public void publicMenu() {
        boolean exit = false;
        do {
            System.out.println("Welcome To Your Site!");
            System.out.println("1-SignIn As Customer");
            System.out.println("2-SignUp As Customer");
            System.out.println("3-SignIn As Technician");
            System.out.println("4-SignUp As Technician");
            System.out.println("5-Sign In As Admin");
            System.out.println("0-Exit");

            int number = getIntFromUser();


            switch (number) {
                case 1 -> loginAsCustomer();
                case 2 -> signUpCustomer();
                case 3 -> loginAsTechnician();
                case 4 -> signUpTechnician();
                case 5 -> loginAsAdmin();
                case 0 -> exit = true;
                default -> System.out.println("Integer must be between 1-5");
            }

        } while (!exit);
    }

}
