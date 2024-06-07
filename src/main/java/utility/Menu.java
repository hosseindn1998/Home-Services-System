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

}
