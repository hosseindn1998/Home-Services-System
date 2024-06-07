package connection;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private SessionFactorySingleton() {
    }

    private static class lazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Comment.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Offer.class)
                    .addAnnotatedClass(Service.class)
                    .addAnnotatedClass(SubService.class)
                    .addAnnotatedClass(Technician.class)
                    .addAnnotatedClass(Wallet.class)
                    .addAnnotatedClass(TechnicianSubService.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return lazyHolder.INSTANCE;
    }
}
