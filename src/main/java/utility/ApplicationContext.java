package utility;

import connection.SessionFactorySingleton;
import org.hibernate.SessionFactory;
import repository.Admin.AdminRepositoryImpl;
import repository.Comment.CommentRepositoryImpl;
import repository.Customer.CustomerRepositoryImpl;
import repository.Offer.OfferRepositoryImpl;
import repository.Order.OrderRepositoryImpl;
import repository.Service.ServiceRepositoryImpl;
import repository.SubService.SubServiceRepositoryImpl;
import repository.Technician.TechnicianRepositoryImpl;
import repository.Wallet.WalletRepositoryImpl;
import repository.technician_subservice.TechnicianSubServiceRepositoryImpl;
import service.Admin.AdminServiceImpl;
import service.Comment.CommentServiceImpl;
import service.Customer.CustomerServiceImpl;
import service.Offer.OfferServiceImpl;
import service.Order.OrderServiceImpl;
import service.Service.ServiceServiceImpl;
import service.SubService.SubServiceServiceImpl;
import service.Technician.TechnicianServiceImpl;
import service.Wallet.WalletServiceImpl;
import service.technician_subservice.TechnicianSubServiceServiceImpl;

public class ApplicationContext {
    static final SessionFactory SESSION_FACTORY;
    private static final AdminRepositoryImpl ADMIN_REPOSITORY;
    private static final AdminServiceImpl ADMIN_SERVICE;
    private static final CommentRepositoryImpl COMMENT_REPOSITORY;
    public static final CommentServiceImpl COMMENT_SERVICE;
    public static final CustomerRepositoryImpl CUSTOMER_REPOSITORY;
    public static final CustomerServiceImpl CUSTOMER_SERVICE;
    public static final OfferRepositoryImpl OFFER_REPOSITORY;
    public static final OfferServiceImpl OFFER_SERVICE;
    public static final OrderRepositoryImpl ORDER_REPOSITORY;
    public static final OrderServiceImpl ORDER_SERVICE;
    public static final ServiceRepositoryImpl SERVICE_REPOSITORY;
    public static final ServiceServiceImpl SERVICE_SERVICE;
    public static final SubServiceRepositoryImpl SUB_SERVICE_REPOSITORY;
    public static final SubServiceServiceImpl SUB_SERVICE_SERVICE;
    public static final TechnicianRepositoryImpl TECHNICIAN_REPOSITORY;
    public static final TechnicianServiceImpl TECHNICIAN_SERVICE;
    public static final WalletRepositoryImpl WALLET_REPOSITORY;
    public static final WalletServiceImpl WALLET_SERVICE;
    public static final TechnicianSubServiceRepositoryImpl TECHNICIAN_SUB_SERVICE_REPOSITORY;
    public static final TechnicianSubServiceServiceImpl TECHNICIAN_SUB_SERVICE_SERVICE;


    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();
        ADMIN_REPOSITORY = new AdminRepositoryImpl(SESSION_FACTORY);
        ADMIN_SERVICE = new AdminServiceImpl(ADMIN_REPOSITORY, SESSION_FACTORY);
        COMMENT_REPOSITORY = new CommentRepositoryImpl(SESSION_FACTORY);
        COMMENT_SERVICE = new CommentServiceImpl(COMMENT_REPOSITORY, SESSION_FACTORY);
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpl(SESSION_FACTORY);
        CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY, SESSION_FACTORY);
        OFFER_REPOSITORY = new OfferRepositoryImpl(SESSION_FACTORY);
        OFFER_SERVICE = new OfferServiceImpl(OFFER_REPOSITORY, SESSION_FACTORY);
        ORDER_REPOSITORY = new OrderRepositoryImpl(SESSION_FACTORY);
        ORDER_SERVICE = new OrderServiceImpl(ORDER_REPOSITORY, SESSION_FACTORY);
        SERVICE_REPOSITORY = new ServiceRepositoryImpl(SESSION_FACTORY);
        SERVICE_SERVICE = new ServiceServiceImpl(SERVICE_REPOSITORY, SESSION_FACTORY);
        SUB_SERVICE_REPOSITORY = new SubServiceRepositoryImpl(SESSION_FACTORY);
        SUB_SERVICE_SERVICE = new SubServiceServiceImpl(SUB_SERVICE_REPOSITORY, SESSION_FACTORY);
        TECHNICIAN_REPOSITORY = new TechnicianRepositoryImpl(SESSION_FACTORY);
        TECHNICIAN_SERVICE = new TechnicianServiceImpl(TECHNICIAN_REPOSITORY, SESSION_FACTORY);
        WALLET_REPOSITORY = new WalletRepositoryImpl(SESSION_FACTORY);
        WALLET_SERVICE = new WalletServiceImpl(WALLET_REPOSITORY, SESSION_FACTORY);
        TECHNICIAN_SUB_SERVICE_REPOSITORY = new TechnicianSubServiceRepositoryImpl(SESSION_FACTORY);
        TECHNICIAN_SUB_SERVICE_SERVICE = new TechnicianSubServiceServiceImpl(TECHNICIAN_SUB_SERVICE_REPOSITORY, SESSION_FACTORY);
    }

    public static AdminServiceImpl getAdminService() {
        return ADMIN_SERVICE;
    }

    public static CommentServiceImpl getCommentService() {
        return COMMENT_SERVICE;
    }

    public static CustomerServiceImpl getCustomerService() {
        return CUSTOMER_SERVICE;
    }

    public static OfferServiceImpl getOfferService() {
        return OFFER_SERVICE;
    }

    public static OrderServiceImpl getOrderService() {
        return ORDER_SERVICE;
    }

    public static ServiceServiceImpl getServiceService() {
        return SERVICE_SERVICE;
    }

    public static SubServiceServiceImpl getSubServiceService() {
        return SUB_SERVICE_SERVICE;
    }

    public static TechnicianServiceImpl getTechnicianService() {
        return TECHNICIAN_SERVICE;
    }

    public static WalletServiceImpl getWalletService() {
        return WALLET_SERVICE;
    }

    public static TechnicianSubServiceServiceImpl getTechnicianSubServiceService() {
        return TECHNICIAN_SUB_SERVICE_SERVICE;
    }
}
