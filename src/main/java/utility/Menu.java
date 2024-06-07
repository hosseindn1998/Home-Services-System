package utility;

import base.exception.BadInputException;
import base.exception.DuplicateValueException;
import base.exception.NotFoundException;
import model.*;
import service.Admin.AdminServiceImpl;
import service.Customer.CustomerServiceImpl;
import service.Order.OrderServiceImpl;
import service.Service.ServiceServiceImpl;
import service.SubService.SubServiceServiceImpl;
import service.Technician.TechnicianServiceImpl;
import service.Wallet.WalletServiceImpl;
import service.technician_subservice.TechnicianSubServiceServiceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public void adminMenu() {
        boolean exit = false;
        do {
            System.out.println("  *** Admin Menu ***  ");
            System.out.println("1-Add Service");
            System.out.println("2-See Service");
            System.out.println("3-Delete Service");
            System.out.println("4-Add SubService");
            System.out.println("5-See SubService");
            System.out.println("6-Update SubService");
            System.out.println("7-Delete SubService");
            System.out.println("8-Download Picture Of Technician");
            System.out.println("9-Verify Technician");
            System.out.println("10-Add Technician To SubService");
            System.out.println("11-Delete Technician From SubService");
            System.out.println("12-Delete Technician by ID");
            System.out.println("13-Delete Customer by ID");
            System.out.println("0-Logout");

            int number = getIntFromUser();


            switch (number) {
                case 1 -> addService();
                case 2 -> seeServices();
                case 3 -> deleteService();
                case 4 -> addSubService();
                case 5 -> seeSubServices();
                case 6 -> updateSubService();
                case 7 -> deleteSubService();
                case 8 -> fetchAvatarFile();
                case 9 -> verifyTechnician();
                case 10 -> addTechnicianToSubService();
                case 11 -> deleteTechnicianFromSubService();
                case 12 -> deleteTechnician();
                case 13 -> deleteCustomer();
                case 0 -> {
                    exit = true;
                    logout();
                }
                default -> System.out.println("Integer must be between 0-13");
            }
        } while (!exit);
    }
    public void customerMenu() {
        boolean exit = false;
        do {
            System.out.println("  *** Customer Menu ***  ");
            System.out.println("1-Change Password");
            System.out.println("2-Add Order");
            System.out.println("3-See Orders");
            System.out.println("0-Logout");

            int number = getIntFromUser();


            switch (number) {
                case 1 -> changeCustomerPassword();
                case 2 -> addOrder();
                case 3 -> seeOrderByCustomer();
                case 0 -> {
                    exit = true;
                    logout();
                }
                default -> System.out.println("Integer must be between 0-3");
            }

        } while (!exit);
    }
    public void technicianMenu() {
        boolean exit = false;
        do {
            System.out.println("  *** Technician Menu ***  ");
            System.out.println("1-Change Password");
            System.out.println("0-Logout");


            int number = getIntFromUser();


            switch (number) {
                case 1 -> changeTechnicianPassword();
                case 0 -> {
                    exit = true;
                    logout();
                }
                default -> System.out.println("Integer must be between 0-3");
            }
        } while (!exit);
    }
    public void logout() {
        loggedInUser = null;
        System.out.println("You Are Logged Out Successfully");
    }
    public void loginAsAdmin() {
        System.out.println("Please Enter Your Email:");
        String email = getString();
        System.out.println("Please Enter Your Password");
        String password = getString();
        try {
            Admin admin = adminService.authentication(email, password);
            if (admin == null)
                throw new NotFoundException("Error : email or password is false");
            loggedInUser = admin.getId();
            adminMenu();
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void setAvatarFile(Technician technician, String fileAddressAndName) {
        try {
            Path path = Paths.get(fileAddressAndName);
            if (Files.size(path) > (300 * 1024))
                throw new BadInputException("File must be les than 300 Kb");
            technician.setAvatar(Files.readAllBytes(path));
            technicianService.saveOrUpdate(technician);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void fetchAvatarFile() {
        System.out.println("Please enter technician id :");
        Technician technician = technicianService.findById(getLongFromUser());
        String fileAddress;
        do {
            System.out.println("Please Enter Valid Path file" +
                    "for Example E:\\code.jpg");
            fileAddress = scanner.next();
            scanner.nextLine();
        } while (!Validation.isValidPathFile(fileAddress));

        byte[] avatar = technician.getAvatar();
        try (FileOutputStream fos = new FileOutputStream(fileAddress)) {
            fos.write(avatar);
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteTechnician() {
        try {
            seeTechnicians();
            System.out.println("Please Inter TechnicianId You Want To Delete :");
            Long technicianId = getLongFromUser();
            technicianService.delete(technicianService.findById(technicianId));
            System.out.println("Technician Deleted Successfully");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteCustomer() {
        try {
            seeCustomers();
            System.out.println("Please Inter CustomerId You Want To Delete :");
            Long technicianId = getLongFromUser();
            customerService.delete(customerService.findById(technicianId));
            System.out.println("Customer Deleted Successfully");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void signUpTechnician() {
        try {

            Wallet wallet = walletService.saveOrUpdate(new Wallet(0L));
            Technician technician = Technician.builder()
                    .firstName(getFirstName())
                    .lastName(getLastName())
                    .email(getEmail())
                    .password(getPassword())
                    .technicianStatus(TechnicianStatus.NEW_TECHNICIAN)
                    .registeredDate(LocalDate.now())
                    .rate(0.0d)
                    .wallet(wallet)
                    .build();
            System.out.println("Please Enter Picture For Avatar File Address (for example E:\\code.jpg ):");
            String fileAddress = getString();
            if (!Validation.isValidPathFile(fileAddress))
                throw new BadInputException("Path file is Not valid,try again");
            setAvatarFile(technician, fileAddress);
            technicianService.saveOrUpdate(technician);
        } catch (BadInputException | DuplicateValueException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException ignored) {
        }
    }
    public void signUpCustomer() {
        try {
            Wallet wallet = walletService.saveOrUpdate(new Wallet(0L));
            Customer customer = Customer.builder()
                    .firstName(getFirstName())
                    .lastName(getLastName())
                    .email(getEmail())
                    .password(getPassword())
                    .registeredDate(LocalDate.now())
                    .wallet(wallet)
                    .build();
            customerService.saveOrUpdate(customer);
        } catch (DuplicateValueException | BadInputException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException ignored) {

        }
    }
    public void changeCustomerPassword() {
        System.out.println("Please enter new password :");
        String newPassword = getString();
        try {
            Customer customer = customerService.findById(loggedInUser);
            customer.setPassword(newPassword);
            customerService.saveOrUpdate(customer);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void changeTechnicianPassword() {
        System.out.println("Please enter new password :");
        String newPassword = getString();
        try {
            Technician technician = technicianService.findById(loggedInUser);
            technician.setPassword(newPassword);
            technicianService.saveOrUpdate(technician);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



}