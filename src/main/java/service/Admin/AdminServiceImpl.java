package service.Admin;

import base.service.BaseServiceImpl;
import model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.Admin.AdminRepository;


public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository> implements AdminService {

    private final SessionFactory sessionFactory;

    @Override
    public Admin authentication(String email, String password) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Admin admin = repository.authentication(email, password);
            transaction.commit();
            return admin;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }
    }

    public AdminServiceImpl(AdminRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

}
