package service.Technician;


import base.exception.NotFoundException;
import base.service.BaseServiceImpl;
import model.Technician;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.Technician.TechnicianRepository;

import java.util.List;


public class TechnicianServiceImpl extends BaseServiceImpl<Technician, Long, TechnicianRepository> implements TechnicianService {

    private final SessionFactory sessionFactory;

    public TechnicianServiceImpl(TechnicianRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Boolean isExistsByEmail(String email) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Boolean result = repository.isExistsByEmail(email);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Technician authentication(String email, String password) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Technician technician = repository.authentication(email, password);
            session.getTransaction().commit();
            return technician;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Technician> findAllVerified() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            List<Technician> technicians = repository.findAllVerified();
            if (technicians.isEmpty())
                throw new NotFoundException("No items found ");
            session.getTransaction().commit();
            return technicians;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
